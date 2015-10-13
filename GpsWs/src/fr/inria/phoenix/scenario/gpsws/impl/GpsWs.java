package fr.inria.phoenix.scenario.gpsws.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates;
import fr.inria.phoenix.diasuite.framework.device.gpsws.AbstractGpsWs;

@SuppressWarnings("deprecation")
public class GpsWs extends AbstractGpsWs {

	public GpsWs(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration, "GpsWs");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	@Override
	protected GpsCoordinates getDestCoordinates(String filter) throws Exception {
		// TODO Auto-generated method stub
		filter = filter.replaceAll("\\s", "+");
		String IDENTIFICATION_KEY = "AIzaSyCGhipfqn8TPU9MyTa1CXbvZAm1EzNlWEE";
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address="+filter+"&key="+IDENTIFICATION_KEY;
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		
		HttpResponse response = httpclient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		for (String line = null; (line = reader.readLine()) != null;) {
			builder.append(line).append("\n");
		}
		
		String content = builder.toString();
		
		JSONParser jp = new JSONParser();
		Object obj;
		
		obj = jp.parse(content);
		
		JSONObject json = (JSONObject) obj;
		JSONArray results= (JSONArray) json.get("results");
		json = (JSONObject) results.get(0);
		json = (JSONObject) json.get("geometry");
		json = (JSONObject) json.get("location");
		
		String latitude = json.get("lat").toString();
		String longitude = json.get("lng").toString();
		
		
		GpsCoordinates gpscoor = new GpsCoordinates();
		gpscoor.setLatitude(latitude);
		gpscoor.setLongitude(longitude);
		return gpscoor;
	}

}
