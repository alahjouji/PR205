package fr.inria.phoenix.scenario.bordeauxmetropole.impl;
import java.util.ArrayList;
import java.util.List;


public class Station {

	// Variables
	String name;
	int nbVelo;
	int nbPlace;
	boolean maintenance;
	boolean carteBleue;
	//	static String url = "http://www.vcub.fr/stations/liste";


	//Constructeurs	

	public Station() {
	}

	public Station(String name, int nbVelo, int nbPlace, boolean maintenance, boolean carteBleue) {
		super();
		this.name = name;
		this.nbVelo = nbVelo;
		this.nbPlace = nbPlace;
		this.maintenance = maintenance;
		this.carteBleue = carteBleue;
	}



	// Getters & Setters

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNbVelo() {
		return nbVelo;
	}


	public void setNbVelo(int nbVelo) {
		this.nbVelo = nbVelo;
	}


	public int getNbPlace() {
		return nbPlace;
	}


	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public boolean getMaintenance() {
		return maintenance;
	}


	public void setMaintenance(boolean maintenance) {
		this.maintenance = maintenance;
	}

	public boolean getCarteBleue() {
		return carteBleue;
	}

	public void setCarteBleue(boolean carteBleue) {
		this.carteBleue = carteBleue;
	}

	// Méthodes

	public String describeItself(){

		String str="";
		str = str + "Station : " + this.getName() + "\n";

		if(!maintenance){
			str = str + "Vélo(s) disponible(s) : " + this.getNbVelo() + "\n";
			str = str + "Place(s) disponible(s) : " + this.getNbPlace() + "\n";

			if(carteBleue)
				str = str + "Carte bleue : Oui \n";
			else
				str = str + "Carte bleue : Non \n";
		}

		else
			str = str + "La station est en maintenance \n";


		return str;
	}

	public Station getStationFromCode(String codeSource, String stationName){

		Station station = new Station();
		station.setName(stationName);

		stationName = formatStation(stationName);

		if(isOnMaintenance(codeSource, stationName))
			station.setMaintenance(true);

		else {
			String infos = filterInformations(codeSource, stationName);
			station.setMaintenance(false);
			station.setNbPlace(getVCUBPlaces(infos));
			station.setNbVelo(getNbVCUB(infos));

			if(acceptCarteBleue(infos)){
				station.setCarteBleue(true);
			}
			else{
				station.setCarteBleue(false);
			}

		}

		return station;

	}

	public String formatStation(String stationName){

		if (!stationName.equals("Bègles Poste") && !stationName.equals("Palais des Congrès"))
			stationName = stationName.replace("è", "e");

		if(!stationName.equals("Lycée Vaclav Havel")  && !stationName.equals("Hôtel de Ville Mérignac"))
			stationName = stationName.replace("é", "e");

		if(!stationName.equals("Hôtel de Ville Mérignac"))
			stationName = stationName.replace("ô", "o");
		
		if(stationName.equals("Victoire"))
			stationName = "Place de la Victoire";

		if(stationName.equals("Arts et Métiers"))
			stationName = "Arts et Metiers";
		
		stationName = stationName.replace("&", "et");
		stationName = stationName.replace(" - ", "---");
		stationName = stationName.replace(" ", "-");

		return stationName;
	}

	public boolean isOnMaintenance(String codeSource,String stationName){

		if (!codeSource.contains("<a href=\"/stations/"+stationName+"\">"))
			return true;
		else
			return false;
	}

	public static String filterInformations(String codeSource, String stationName){

		String beginningFilter = "<a href=\"/stations/"+stationName+"\">";
		codeSource = codeSource.substring(codeSource.indexOf(beginningFilter));
		codeSource = codeSource.substring(beginningFilter.length());
		String endFilter = "<td class=\"station-access no-livefilter\">";

		codeSource = codeSource.substring(0, codeSource.indexOf(endFilter));

		return codeSource;
	}

	public static int getVCUBPlaces(String codeSource){

		String beginningFilter;
		String[] list= {"<td class=\"a-place eq no-livefilter\">"
				, "<td class=\"a-place up no-livefilter\">"
				, "<td class=\"a-place down no-livefilter\">"};

		int i = 0;
		while(!codeSource.contains(list[i])){
			i = i+1;
		}
		beginningFilter = list[i];

		codeSource = codeSource.substring(codeSource.indexOf(beginningFilter));
		codeSource = codeSource.substring(beginningFilter.length());
		String endFilter = "</td>";
		codeSource = codeSource.substring(0, codeSource.indexOf(endFilter));

		return Integer.parseInt(codeSource);

	}

	public static int getNbVCUB(String codeSource){

		String[] list= {"<td class=\"a-bicycle eq no-livefilter\">"
				, "<td class=\"a-bicycle down no-livefilter\">"
				, "<td class=\"a-bicycle up no-livefilter\">"
		};

		String beginningFilter;

		int i = 0;
		while(!codeSource.contains(list[i])){
			i = i+1;
		}
		beginningFilter = list[i];

		codeSource = codeSource.substring(codeSource.indexOf(beginningFilter));
		codeSource = codeSource.substring(beginningFilter.length());
		String endFilter = "</td>";
		codeSource = codeSource.substring(0, codeSource.indexOf(endFilter));


		return Integer.parseInt(codeSource);

	}

	public static boolean acceptCarteBleue(String infos){

		if (infos.contains("Carte Bleue"))
			return true;
		else
			return false;
	}

	public static List<String> getStationName(String code, String beginningfilter, String endingfilter){

		List<String> listStation = new ArrayList<String>(); 

		String neo = code;
		String debut = beginningfilter+"A";

		neo = neo.substring(neo.indexOf(debut));
		neo = neo.substring(0, neo.indexOf("</div>"));

		String name = neo.substring(beginningfilter.length(), neo.indexOf(endingfilter));

		neo = neo.substring(beginningfilter.length());

		listStation.add(name);

		while(neo.contains(beginningfilter)){
			neo = neo.substring(neo.indexOf(beginningfilter));
			name = neo.substring(beginningfilter.length(), neo.indexOf(endingfilter));

			if(!listStation.contains(name))
				listStation.add(name);

			neo = neo.substring(beginningfilter.length()+1);
		}

		return listStation;

	}

	public static List<String> getStationMaintenance(String codeSource, String beginningfilter, String endingfilter){

		List<String> listStation = new ArrayList<String>(); 

		String neo = codeSource;
		String debut = "<a href=\"/stations/"+"A";

		neo = neo.substring(neo.indexOf(debut));
		neo = neo.substring(0, neo.indexOf("</div>"));

		while(neo.contains(beginningfilter)){

			neo = neo.substring(neo.indexOf(beginningfilter));
			//String name = neo.substring(beginningfilter.length(), neo.indexOf("<"));
			String info = neo.substring(0,neo.indexOf(endingfilter));


			neo = neo.substring(beginningfilter.length()+1);

			if(info.contains("maintenance")){
				String name = neo.substring(0, neo.indexOf("<")).replace("  ", "");
				name = name.substring(1, name.length()-1);
				listStation.add(name);
			}
		}

		return listStation;

	}


}
