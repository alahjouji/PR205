package Parcours;

public class ParcoursTransport extends Parcours{

	// Variables
	String transport_id;
	String transport_direction;
	String place_depart;
	String place_end;
	Polyline polyline;

	// Constructeurs
	public ParcoursTransport(){
		this.mod = super.mod;
		this.date_depart = super.date_depart;
		this.date_end = super.date_end;
	}
	
	public ParcoursTransport(String mod, String place_depart, String place_end,
			String tram_id, String date_depart, String date_end, Polyline polyline){

		this.mod = mod;
		this.place_depart = place_depart;
		this.place_end = place_end;
		this.transport_id = tram_id;
		this.date_depart = date_depart;
		this.date_end = date_end;
		this.polyline = polyline;
	}
	
	
	// Getters & Setters
	public String getTram_direction() {
		return transport_direction;
	}

	public void setTram_direction(String tram_direction) {
		this.transport_direction = tram_direction;
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

	public String getTram_id() {
		return transport_id;
	}

	public void setTram_id(String tram_id) {
		this.transport_id = tram_id;
	}
	
	public Polyline getPolyline() {
		return polyline;
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
				+ "\n\tLigne : " + this.getTram_id()
				+ "\n\tDirection : " + this.getTram_direction()
				+ "\n\tPolyline : " + this.getPolyline().getListCoordinates().size() + " points"
				+ " (" + this.getPolyline().getLength() + " mètres)";
		
		return str;
	}

}
