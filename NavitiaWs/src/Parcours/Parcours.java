package Parcours;

//Un OBJET Parcours possède impérativement 4 variables
//	- une distance
//	- un mode de transport
//	- une date de départ
//	- une date de fin
//C'est une classe abstraite dont vont hériter tous les types de parcours

public abstract class Parcours {

	// Variables
	String mod;
	String date_depart;
	String date_end;
	
	// Constructeurs
	Parcours(){}
	
	Parcours(String mod, String date_depart, String date_end){

		this.mod = mod;
		this.date_depart = date_depart;
		this.date_end = date_end;
	}
	
	
	// Getters & Setters
	public String getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}


	public String getMod() {
		return mod;
	}
	
	public void setMod(String mod) {
		this.mod = mod;
	}
	
	
	// Méthodes
	public String describeItself(){
		return "";
	}
	
}
