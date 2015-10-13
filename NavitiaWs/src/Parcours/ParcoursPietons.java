package Parcours;


public class ParcoursPietons extends Parcours{

	// Variables

    long distance;
	String place_depart;
	String place_end;
	Polyline polyline;
	

	// Constructeurs
	public ParcoursPietons(){
		this.mod = super.mod;
		this.date_depart = super.date_depart;
		this.date_end = super.date_end;
	}
	
	public ParcoursPietons(long distance, String mod, String place_depart, String place_end,
			String date_depart, String date_end, Polyline polyline){
		
		this.distance = distance;
		this.mod = mod;
		this.place_depart = place_depart;
		this.place_end = place_end;
		this.date_depart = date_depart;
		this.date_end = date_end;
		this.polyline = polyline;
	}
	
	
	// Getters & Setters 
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

	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }


    // Méthodes
	public String describeItself(){
		
		String str = super.describeItself()
				+ "\n\tDe : " + this.getPlace_depart() 
				+ " (" + this.getDate_depart() + ")"
				+ "\n\tà : " + this.getPlace_end()
				+ " (" + this.getDate_end() + ")"
				+ "\n\tMode : " + this.getMod()
                + "\n\tDistance :" + this.getDistance()
				+ "\n\tPolyline : " + this.getPolyline().getListCoordinates().size() + " points"
				+ " (" + this.getPolyline().getLength() + " mètres)";
		
		return str;
		
	}


}
