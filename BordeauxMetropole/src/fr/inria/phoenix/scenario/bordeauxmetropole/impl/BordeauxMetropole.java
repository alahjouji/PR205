package fr.inria.phoenix.scenario.bordeauxmetropole.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes;
import fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv;
import fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole.AbstractBordeauxMetropole;

public class BordeauxMetropole extends AbstractBordeauxMetropole {

	public BordeauxMetropole(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration, "BordeauxMetropole");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Bikes getBikes(BikesAv filter) throws Exception {
		// TODO Auto-generated method stub
		String code = "http://www.vcub.fr/stations/liste";
		String codeSource = getCode(code);
		Bikes bikes=new Bikes();
		List<Integer> stationsBi = new ArrayList<Integer>();
		List<Integer> stationsPl = new ArrayList<Integer>();
		for(int i = 0 ; i < filter.getDep().size() ; i++){
			Station station = new Station();
			station = station.getStationFromCode(codeSource, filter.getDep().get(i));
			stationsBi.add(station.getNbVelo());
		}
		for(int i = 0 ; i < filter.getArr().size() ; i++){
			Station station = new Station();
			station = station.getStationFromCode(codeSource, filter.getArr().get(i));
			stationsPl.add(station.getNbPlace());
		}
		bikes.setStationsBi(stationsBi);
		bikes.setStationsPl(stationsPl);
		return bikes;
	}
	
	public static String getCode(String url){
		String code = "";

		if(urlExists(url))
		{
			BufferedReader in = null;

			try
			{
				URL site = new URL(url);
				in = new BufferedReader(new InputStreamReader(site.openStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null)
				{
					code = code + "\n" + (inputLine);
				}

				in.close();

			}
			catch (IOException ex)
			{
				System.out.println("Erreur dans l'ouverture de l'URL : " + ex);
			}
			finally
			{
				try
				{
					in.close();
				}
				catch (IOException ex)
				{
					System.out.println("Erreur dans la fermeture du buffer : " + ex);
				}
			}
		}
		else
		{
			System.out.println("Le site n'existe pas !");
		}
		return code;
	}

	public static boolean urlExists(String url){
		try {
			URL site = new URL(url);
			try {
				site.openStream();
				return true;
			} catch (IOException ex) {
				return false;
			}
		} catch (MalformedURLException ex) {
			return false;
		}
	}

}
