package Parcours;

public class ParcoursVelo extends Parcours{

    // Variables
    String type;
    String place_depart;
    String place_end;
    Polyline polyline;
    long distance;

    // Constructeurs
    public ParcoursVelo(){
    }

    public ParcoursVelo(String type, String place_depart, String place_end,
                        Polyline polyline){

        this.type = type;
        this.place_depart = place_depart;
        this.place_end = place_end;
        this.polyline = polyline;
    }


    // Getters & Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace_depart() {
        return place_depart;
    }

    public void setPlace_depart(String place_depart) {
        this.place_depart = place_depart;
    }

    public String getPlace_end() {
        return place_end;
    }

    public void setPlace_end(String place_end) {
        this.place_end = place_end;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public long getDistance(){
        return this.getPolyline().getLength();
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }


    // Méthodes
    public String describeItself(){

        String str = super.describeItself()
                + "\n\tDe : " + this.getPlace_depart()
                + " (" + this.getDate_depart() + ")"
                + "\n\tà : " + this.getPlace_end()
                + " (" + this.getDate_end() + ")"
                + "\n\tMode : " + this.getMod()
                + "\n\tType : " + this.getType();

        if(this.getType().equals("street_network")){
                str = str + "\n\tPolyline : "
                        + this.getPolyline().getListCoordinates().size()
                        + " points"
                        + " (" + this.getPolyline().getLength()
                        + " mètres)";
        }

        return str;
    }

}
