package Parcours;


import Parcours.Parcours;

import java.util.ArrayList;

import java.util.List;

//Un OBJET Itineraire possède 8 variables :
//	- date de départ
//	- date d'arrivée
//	- tarif
//	- lieu de départ
//	- lieu d'arrivée
//	- liste des moyens de transport
//	- nombre de correspondance
//	- liste des parcours

public class Itineraire {

	// Variables
	String date_begining;
	String date_end;
	float tarif;
	String place_begining;
	String place_end;
	List<String> mods;
	int nb_transfers;
	List<Parcours> sections;
    String duration;

	// Constructeurs
	public Itineraire(){}

	public Itineraire(String date_begining, String date_end,
			float tarif, String place_begining, String place_end,
			List<String> mods, int nb_transfers, List<Parcours> sections){

		this.date_begining = date_begining;
		this.date_end = date_end;
		this.tarif = tarif;
		this.place_begining = place_begining;
		this.place_end = place_end;
		this.mods = mods;
		this.nb_transfers = nb_transfers;
		this.sections = sections;

	}
	
	
	// Getters & Setters
	public List<Parcours> getSections() {
		return sections;
	}

	public void setSections(List<Parcours> sections) {
		this.sections = sections;
	}

	public int getNb_transfers() {
		return nb_transfers;
	}

	public void setNb_transfers(int nb_transfers) {
		this.nb_transfers = nb_transfers;
	}

	public String getDate_begining() {
		return date_begining;
	}

	public void setDate_begining(String date_begining) {
		this.date_begining = date_begining;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public String getPlace_begining() {
		return place_begining;
	}

	public void setPlace_begining(String place_begining) {
		this.place_begining = place_begining;
	}

	public String getPlace_end() {
		return place_end;
	}

	public void setPlace_end(String place_end) {
		this.place_end = place_end;
	}

	public String getMods() {

        String str = "";
        List<String> allMods = new ArrayList<String>();
        if(this.getSections()!=null){
            for(int i = 0 ; i < this.getSections().size() ; i++){
                Parcours p = this.getSections().get(i);
                String m = p.getMod();
                if(!allMods.contains(m)&& !m.equals("Attente")) {
                    allMods.add(m);
                    str = str + m + ", ";
                }
            }

            str = str.substring(0, str.length()-2);
        }

        return str;
	}

	public void setMods(List<String> mods) {
		this.mods = mods;
	}

    public String getDuration(){

        return duration;
    }

    public void setDUration(String duration){
        this.duration = duration;
    }

	// Méthode
	public String describeItself(){

		String str ="";
		str = str + "\tDépart  : " + this.getPlace_begining()
				+ " (" + this.getDate_begining() +")"
				+"\n\tArrivée : " + this.getPlace_end()
				+ " (" + this.getDate_end() +")"
				+ "\n\tDurée : " + this.getDuration()
				+ "\n\tCorrespondance(s) : " + this.getNb_transfers()
				+ "\n\tNombre de sections : " + this.getSections().size();

		for (int i = 0 ; i < this.getSections().size(); i ++){
			str = str
					+"\n\n\t> Section n°"+(i+1)
					+this.getSections().get(i).describeItself();
		}

		return str;
	}

}
