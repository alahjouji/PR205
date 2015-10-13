package Parcours;



public class ParcoursAttente extends Parcours{

    // Variables
    String duration;

    // Constructeurs
    public ParcoursAttente(){
        this.mod = super.mod;
        this.date_depart = super.date_depart;
        this.date_end = super.date_end;
    }

    public ParcoursAttente(String mod, String place_depart, String place_end,
                           String date_depart, String date_end){

        this.mod = mod;
        this.date_depart = date_depart;
        this.date_end = date_end;
    }


    // Getters & Setters
    public String getDuration(){

        return this.duration;
    }

    public void setDuration(String duree){

       this.duration = duree;
    }


    // Méthodes
    public String describeItself(){

        return "\n\tAttendre : " + this.getDuration();
    }


}
