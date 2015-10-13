package Parcours;


import java.util.HashMap;
import java.util.List;

public class Polyline {

	// Variables
	
	long length;
	List<HashMap<String, Double>> listCoordinates;
	
	// Constructeurs
	
	public Polyline(){}
		
	public Polyline(long length, List<HashMap<String, Double>> listCoordonates) {
		this.length = length;
		this.listCoordinates = listCoordonates;
	}



	// Getters & Setters
	
	public long getLength() {
		return length;
	}
	
	public void setLength(long length) {
		this.length = length;
	}
	
	public List<HashMap<String, Double>> getListCoordinates() {
		return listCoordinates;
	}
	
	public void setListCoordinates(List<HashMap<String, Double>> listCoordinates) {
		this.listCoordinates = listCoordinates;
	}
	
	
	// Methodes

	public String describeItself(){
		
		return "\nJe suis un PolyLine de : "
				+ this.getLength() + " mètres de long."
				+ "\nJe possède : "
				+ this.getListCoordinates().size() + " points.";
	}

}
