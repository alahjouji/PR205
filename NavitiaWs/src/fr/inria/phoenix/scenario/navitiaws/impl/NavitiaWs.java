package fr.inria.phoenix.scenario.navitiaws.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.datatype.sending.Sending;
import fr.inria.phoenix.diasuite.framework.device.navitiaws.AbstractNavitiaWS;

public class NavitiaWs extends AbstractNavitiaWS {

	public NavitiaWs(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration, "NavitiaWs");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Sending getJourneys(String filter) throws Exception {
		// TODO Auto-generated method stub
		filter="https://api.navitia.io/v1/journeys?"+filter;
		String IDENTIFICATION_KEY = "9695748a-da99-4e62-94aa-4b453f2f9fb7";
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(filter);
		httpGet.addHeader("Authorization", IDENTIFICATION_KEY);
		
		CloseableHttpResponse response = httpclient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8")); 
		StringBuilder builder = new StringBuilder();
		for (String line = null; (line = reader.readLine()) != null;) {
			builder.append(line).append("\n");
		}

		String content = builder.toString();
		
		JourneyParsing json = new JourneyParsing(content);

		
		List<String> journeys = new ArrayList<String>();
		List<String> times = new ArrayList<String>();
		for(int i = 0 ; i < json.getNbItineraire() ; i++){
			journeys.add(json.getItineraire(i).describeItself());

		}

		for(int i = 0 ; i < json.getNbItineraire() ; i++){
			if (!json.getItineraire(i).getDuration().contains("h"))
				times.add("0h"+json.getItineraire(i).getDuration());
			else
				times.add(json.getItineraire(i).getDuration());

		}
		Sending send=new Sending();
		send.setJourneys(journeys);
		send.setTimes(times);
		return send;
	}
	public static void main(String[] args) throws Exception {
		ServiceConfiguration serviceConfiguration = null;
		// TODO Auto-generated method stub
		NavitiaWs b=new NavitiaWs(serviceConfiguration);
		Sending a=b.getJourneys("from=-0.605424;44.8067872&to=-0.573101;44.831207&datetime=20150510T0338&first_section_mode=bss");
		List<String> m = a.getJourneys();
		System.out.println(m.get(0));
	}
}
