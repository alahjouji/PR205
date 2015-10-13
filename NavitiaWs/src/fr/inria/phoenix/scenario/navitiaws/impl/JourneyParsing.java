package fr.inria.phoenix.scenario.navitiaws.impl;


import Parcours.Itineraire;
import Parcours.Parcours;
import Parcours.ParcoursAttente;
import Parcours.ParcoursPietons;
import Parcours.ParcoursTransport;
import Parcours.ParcoursVelo;
import Parcours.Polyline;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class JourneyParsing {

    // Variables
    JSONObject _rootObject;
    JSONArray _journeysArray;


    // Constructeur avec le contenu de la requête
    public JourneyParsing(String mdata) {

        JSONParser parser = new JSONParser();
        Object obj;

        try {
            obj = parser.parse(mdata);
        } catch (ParseException e) {
            obj = null;
            e.printStackTrace();
        }


        JSONObject jsonObject = (JSONObject) obj;

        this._rootObject = jsonObject;
        this._journeysArray = (JSONArray) this.get_rootObject().get("journeys");
    }

    // Getters & Setters
    public JSONObject get_rootObject() {
        return _rootObject;
    }

    public void set_rootObject(JSONObject _rootObject) {
        this._rootObject = _rootObject;
    }

    public JSONArray get_journeysArray() {
        return _journeysArray;
    }

    public void set_journeysArray(JSONArray _journeysArray) {
        this._journeysArray = _journeysArray;
    }

    public int getNbItineraire(){
        return this._journeysArray.size();
    }

    // Récupération du nombre de correspondance (indexOfItineraire : numéro de l'itinéraire)
    public long getNbTransfers(int indexOfItineraire){

        JSONObject itineraire = (JSONObject) this._journeysArray.get(indexOfItineraire);
        return (Long) itineraire.get("nb_transfers");
    }

    // Récupération de la durée du voyage
    public String getDuration(int indexOfItineraire){

        JSONObject itineraire = (JSONObject) this._journeysArray.get(indexOfItineraire);
        long dur = (Long) itineraire.get("duration");

        long s = dur % 60;
        long m = (dur / 60) % 60;
        long h = (dur / (60 * 60)) % 24;

        switch((int) h){
            case 0:
                switch ((int) s){
                    case 0:
                        if((int) m > 1)
                        return String.format("%d minutes", m);
                    else
                        return String.format("%d minute", m);
                    case 1:
                        return String.format("%d minute", m);
                    default:
                        return String.format("%2dmin%02d", m, s);
                }
            default:
                switch ((int) s){
                    case 0:
                        return String.format("%dh%02", h, m);
                    default:
                        return String.format("%dh%02dmin%02d", h, m, s);
                }

        }
    }

    // Récupération de l'heure de départ
    public String getDepartHour(int indexOfItineraire){

        JSONObject itineraire = (JSONObject) this._journeysArray.get(indexOfItineraire);

        String mdate = (String) itineraire.get("departure_date_time");
        mdate = mdate.substring(mdate.indexOf("T")+1, mdate.length());

        SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date date = sdf2.parse(mdate);
            String d = sdf.format(date);
            return d;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // Récupération de l'heure d'arrivée
    public String getArrivalHour(int indexOfItineraire){

        JSONObject section = (JSONObject) this._journeysArray.get(indexOfItineraire);

        String mdate = (String) section.get("arrival_date_time");
        mdate = mdate.substring(mdate.indexOf("T")+1, mdate.length());

        SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date date = sdf2.parse(mdate);
            String d = sdf.format(date);
            return d;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // Récupération de l'heure de départ demandée
    public String getRequestedHour(int indexOfItineraire){

        JSONObject itineraire = (JSONObject) this._journeysArray.get(indexOfItineraire);

        String mdate = (String) itineraire.get("requested_date_time");
        mdate = mdate.substring(mdate.indexOf("T")+1, mdate.length());

        SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date date = sdf2.parse(mdate);
            String d = sdf.format(date);
            return d;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // Récupération du lieu de départ
    public String getDepartPlace(){

        // le lieu de départ du voyage est le lieu de départ de sa première section
        JSONObject itineraire = (JSONObject) this._journeysArray.get(0);
        JSONArray sections = (JSONArray) itineraire.get("sections");
        JSONObject depart = (JSONObject) sections.get(0);
        JSONObject from = (JSONObject) depart.get("from");

        return from.get("name").toString();
    }

    // Récupération du lieu d'arrivée
    public String getArrivalPlace(){

        // le lieu d'arrivée du voyage est le lieu d'arrivée de sa dernière section
        JSONObject itineraire = (JSONObject) this._journeysArray.get(0);
        JSONArray sections = (JSONArray) itineraire.get("sections");
        JSONObject arrival = (JSONObject) sections.get(sections.size()-1);
        JSONObject to = (JSONObject) arrival.get("to");

        return to.get("name").toString();
    }

    // On parse un itinéraire en OBJET Itinéraire
    public Itineraire getItineraire(int indexOfItineraire){

        Itineraire it = new Itineraire();
        it.setDate_begining(this.getDepartHour(indexOfItineraire));
        it.setDate_end(this.getArrivalHour(indexOfItineraire));
        it.setPlace_begining(this.getDepartPlace());
        it.setPlace_end(this.getArrivalPlace());
        it.setNb_transfers((int) this.getNbTransfers(indexOfItineraire));
        it.setDUration(this.getDuration(indexOfItineraire));

        // Récupération de l'itinéraire
        JSONObject itineraire = (JSONObject) this._journeysArray.get(indexOfItineraire);
        // Récupération des différentes sections
        JSONArray sections = (JSONArray) itineraire.get("sections");

        // Les différentes sections sont transformées en OBJET Parcours
        List<Parcours> listSection = new ArrayList<Parcours>();

        for(int i = 0 ; i < this.getNbSection(indexOfItineraire) ; i++){
            JSONObject section = (JSONObject) sections.get(i);
            Parcours parcours = this.getParcours(section);

            if(parcours.getMod().equals("Vélo")){
                ParcoursVelo pv = (ParcoursVelo) parcours;
                if(pv.getType().equals("street_network")) {
                    listSection.add(pv);
                }
            }

            else {
                listSection.add(parcours);
            }
        }
        it.setSections(listSection);

        return it;
    }

    // Récupération du nombre de sections d'un itinéraire
    public int getNbSection(int indexOfItineraire){

        JSONObject itineraire = (JSONObject) this._journeysArray.get(indexOfItineraire);
        return (int) ((JSONArray) itineraire.get("sections")).size();
    }

    // Récupération du mode de transport d'une section (Piéton, Transport Public)
    public String getSectionMode(JSONObject section){
        return (String) section.get("mode");
    }

    // Récupération du type de section (tranport public, rue, attente)
    public String getSectionType(JSONObject section){
        return (String) section.get("type");
    }

    // Récupération de la durée d'une section
    public String getSectionDuration(JSONObject section){

        long dur = (long) section.get("duration");
        long s = dur % 60;
        long m = (dur / 60) % 60;
        long h = (dur / (60 * 60)) % 24;


        switch((int) h){
            case 0:
                switch ((int) s){
                    case 0:
                        if((int) m > 1)
                            return String.format("%d minutes", m);
                        else
                            return String.format("%d minute", m);
                    default:
                        return String.format("%2dmin%02d", m, s);
                }
            default:
                switch ((int) s){
                    case 0:
                        return String.format("%dh%02", h, m);
                    default:
                        return String.format("%dh%02dmin%02d", h, m, s);
                }

        }
    }

    // Récupération de la section sous forme d'OBJET Parcours

    /*
       public Parcours getParcours(JSONObject section){

           // Le type de parcours (ParcoursPietions, ParcoursTransport, ParcoursAttente) dépend du type de section

           //		if(section.get("geojson") !=null){
           //			System.out.println(this.getPolylineData(section).describeItself());
           //		}

           Parcours parcours;
           switch ((String) section.get("type")){
               case "public_transport" :
                   parcours = this.getParcoursTransport(section);
                   return parcours;
               //break;
               case "transfer" :
                   parcours = this.getParcoursPietons(section);
                   return parcours;
               case "waiting" :
                   parcours = this.getParcoursAttente(section);
                   return parcours;
               default :
                   //System.out.println((String) section.get("mode"));
                   if(section.get("mode").equals("walking")){
                       parcours = this.getParcoursPietons(section);
                       return parcours;
                   }
                   else
                       return null;
           }
       }
   */
    public Parcours getParcours(JSONObject section){

        // Le type de parcours (ParcoursPietions, ParcoursTransport, ParcoursAttente) dépend du type de section
        Parcours parcours;

        List<String> bikeType = new ArrayList<String>();
        bikeType.add("bss_rent");
        bikeType.add("bss_put_back");

        String type = (String) section.get("type");

        if(type!=null && bikeType.contains(type)) {
            parcours = this.getParcoursVelo(section);
            return parcours;
        }

        else{
            switch (type) {
                case "public_transport":
                    parcours = this.getParcoursTransport(section);
                    return parcours;
                case "street_network":
                    String mode = (String) section.get("mode");

                    if(mode!=null && mode.equals("bike")) {
                        parcours = this.getParcoursVelo(section);
                        return parcours;
                    }

                    else{
                        parcours = this.getParcoursPietons(section);
                        return parcours;}

                case "waiting":
                    parcours = this.getParcoursAttente(section);
                    return parcours;
                case "transfer":
                    parcours = this.getParcoursPietons(section);
                    return parcours;
                default:
                    parcours = new ParcoursPietons();
                    return parcours;
            }
        }
    }

    // Récupération de l'heure de départ d'une section
    public String getSectionDepartHour(JSONObject section){

        String mdate = (String) section.get("departure_date_time");
        mdate = mdate.substring(mdate.indexOf("T")+1, mdate.length());

        SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date date = sdf2.parse(mdate);
            String d = sdf.format(date);
            return d;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // Récupération de l'heure d'arrivée d'une section
    public String getSectionArrivalHour(JSONObject section){

        String mdate = (String) section.get("arrival_date_time");
        mdate = mdate.substring(mdate.indexOf("T")+1, mdate.length());

        SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


        try {
            Date date = sdf2.parse(mdate);
            String d = sdf.format(date);
            return d;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // Récupération du lieu de départ d'une section
    public String getSectionDepartPlace(JSONObject section){

        JSONObject from = (JSONObject) section.get("from");

        if(from!=null)
            return (String) from.get("name");
        else
            return "Inconnu";
    }

    // Récupération du lieu d'arrivée d'une section
    public String getSectionArrivalPlace(JSONObject section){

        JSONObject to = (JSONObject) section.get("to");

        if(to!=null)
            return (String) to.get("name");
        else
            return "Inconnu";
    }

    // Convertion d'une section (JSON) en ParcoursTransport
    public ParcoursTransport getParcoursTransport(JSONObject section){

        ParcoursTransport pTransport = new ParcoursTransport();
        pTransport.setMod("Transport public");
        pTransport.setPlace_depart(this.getSectionDepartPlace(section));
        pTransport.setPlace_end(this.getSectionArrivalPlace(section));
        pTransport.setDate_depart(this.getSectionDepartHour(section));
        pTransport.setDate_end(this.getSectionArrivalHour(section));

        JSONObject infos = (JSONObject) section.get("display_informations");
        String mode = (String) infos.get("commercial_mode");
        pTransport.setMod(mode);

        switch(mode) {
            case "Tramway":
                pTransport.setTram_id((String) infos.get("label"));
                pTransport.setTram_direction((String) infos.get("headsign"));
                pTransport.setPolyline(this.getPolylineData(section));
                break;
            case "Bus":
                pTransport.setTram_id((String) infos.get("label"));
                pTransport.setTram_direction((String) infos.get("headsign"));
                pTransport.setPolyline(this.getPolylineData(section));
                break;
            case "Autocar" :
                pTransport.setTram_id((String) infos.get("label"));
                pTransport.setTram_direction((String) infos.get("direction"));
                pTransport.setPolyline(this.getPolylineData(section));
                break;
        }
        //Log.d("Création :", pTransport.describeItself());
        return pTransport;
    }

    public ParcoursVelo getParcoursVelo(JSONObject section){

        ParcoursVelo pVelo = new ParcoursVelo();
        pVelo.setMod("Vélo");
        pVelo.setType((String) section.get("type"));
        pVelo.setPlace_depart(this.getSectionDepartPlace(section));
        pVelo.setPlace_end(this.getSectionArrivalPlace(section));
        pVelo.setDate_depart(this.getSectionDepartHour(section));
        pVelo.setDate_end(this.getSectionArrivalHour(section));
        pVelo.setDate_end(this.getSectionArrivalHour(section));


        if(pVelo.getType().equals("street_network"))
            pVelo.setPolyline(this.getPolylineData(section));

        return pVelo;


    }

    // Convertion d'une section (JSON) en ParcoursPiétons
    public ParcoursPietons getParcoursPietons(JSONObject section){

        ParcoursPietons pPietons = new ParcoursPietons();
        pPietons.setMod("Piéton");
        pPietons.setPlace_depart(this.getSectionDepartPlace(section));
        pPietons.setPlace_end(this.getSectionArrivalPlace(section));
        pPietons.setDate_depart(this.getSectionDepartHour(section));
        pPietons.setDate_end(this.getSectionArrivalHour(section));
        pPietons.setPolyline(this.getPolylineData(section));

        JSONArray routes = (JSONArray) section.get("path");
        if(routes!=null) {
            long dist = 0;

            for (int i = 0; i < routes.size(); i++) {
                JSONObject route = (JSONObject) routes.get(i);
                dist = dist + Long.parseLong(route.get("length").toString());
            }
            pPietons.setDistance(dist);

        }

        return pPietons;
    }

    // Convertion d'une section (JSON) en ParcoursAttente
    public ParcoursAttente getParcoursAttente(JSONObject section){

        ParcoursAttente pAttente = new ParcoursAttente();
        pAttente.setMod("Attente");
        pAttente.setDuration(this.getSectionDuration(section));
        pAttente.setDate_depart(this.getSectionDepartHour(section));
        pAttente.setDate_end(this.getSectionArrivalHour(section));

        return pAttente;
    }

    // Récupération des données pour tracer l'itinéraire
    public Polyline getPolylineData(JSONObject section){

        Polyline polyLine = new Polyline();

        List<HashMap<String, Double>> listCoordinates = new ArrayList<HashMap<String, Double>>();

        JSONObject geojson = (JSONObject) section.get("geojson");

        JSONArray properties = (JSONArray) geojson.get("properties");
        JSONObject length = (JSONObject) properties.get(0);

        polyLine.setLength((long) length.get("length"));

        JSONArray coordinates = (JSONArray) geojson.get("coordinates");

        for (int i = 0 ; i <coordinates.size() ; i++){

            JSONArray path = (JSONArray) coordinates.get(i);
            HashMap<String, Double> hashmap = new HashMap<String, Double>();
            hashmap.put("Longitude", (double) path.get(0));
            hashmap.put("Latitude", (double) path.get(1));
            listCoordinates.add(hashmap);
        }

        polyLine.setListCoordinates(listCoordinates);

        return polyLine;
    }

    public boolean isAnError(JSONObject root){

        JSONObject error = (JSONObject) root.get("error");
        if(error!=null)
            return true;
        else
            return false;
    }

    public String kindOfError(JSONObject root){
        JSONObject error = (JSONObject) root.get("error");
        JSONObject id = (JSONObject) error.get("id");
        String kind = id.toString();
        // no_destination : uncovered ; no_solution ;
        return kind;

    }
}
