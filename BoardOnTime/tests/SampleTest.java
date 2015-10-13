import static fr.inria.phoenix.diasuite.framework.mocks.Mock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes;
import fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv;
import fr.inria.phoenix.diasuite.framework.datatype.contact.Contact;
import fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates;
import fr.inria.phoenix.diasuite.framework.datatype.sending.Sending;
import fr.inria.phoenix.diasuite.framework.mocks.BordeauxMetropoleMock;
import fr.inria.phoenix.diasuite.framework.mocks.GpsWsMock;
import fr.inria.phoenix.diasuite.framework.mocks.MailerMock;
import fr.inria.phoenix.diasuite.framework.mocks.MessengerMock;
import fr.inria.phoenix.diasuite.framework.mocks.NavitiaWSMock;
import fr.inria.phoenix.diasuite.framework.mocks.PrompterMock;
//import fr.inria.phoenix.diasuite.framework.mocks.TimerMock;
import fr.inria.phoenix.scenario.boardontime.impl.ComponentBinder;


public class SampleTest {

	@Before
	public void setUp() throws Exception {
        underTest(ComponentBinder.class);
	}

	@After
	public void tearDown() throws Exception {
        shutdown();
	}

	/*@Test
	public void test() {
	    PrompterMock prompter=mockPrompter("MockPrompter","here","me");
	    GpsWsMock gps=mockGpsWs("MockGPS");
	    NavitiaWSMock navitia=mockNavitiaWS("MockNavitia");
	    MailerMock mailer = mockMailer("MockMailer");
	    BordeauxMetropoleMock bdx=mockBordeauxMetropole("MockBordeaux");
	    MessengerMock messenger = mockMessenger("MockTvMessenger","Here", "Me");
	    //TimerMock timer=mockTimer("MockTimer");
	    prompter.answer("avenue de Collegno", "1");
	    prompter.answer("-0.605424 44.8067872", "2");
	    GpsCoordinates dest=new GpsCoordinates();
	    dest.setLongitude("-0.573101");
	    dest.setLatitude("44.831207");
	    gps.setDestCoordinates(dest, "avenue de Collegno");
	    Sending send=new Sending();
	    List<String>  journeys=new ArrayList<String>();
	    List<String>  times=new ArrayList<String>();
	    journeys.add((">>>	Itinéraire n°1\n\tDépart  : Allée la Roumagne (Talence) (04:00:00)\n\t"
				+ "Arrivée : 30 Place de la Victoire (Bordeaux) (04:20:45)\n\tDurée : 20min45\n\tCorrespondance(s) : 0\n\t"
				+ "Nombre de sections : 2\n\t\t> Section n°1\n\tDe : Arts et Métiers (Talence) (04:02:26)\n\t"
				+ "à  : Victoire (Bordeaux) (04:19:17)\n\tMode : Vélo\n\tType : street_network\n\t"
				+ "Polyline : 109 points (4145 mètres)\n\t\t> Section n°2\n\tDe : 24 Place de la Victoire (Bordeaux) (04:20:17)\n\t"
				+ "à  : 30 Place de la Victoire (Bordeaux) (04:20:45)\n\tMode : Piéton\n\tDistance :30\n\t\t"
				+ "> Section n°3\n\tDe : somme (Talence) (04:02:26)\n\t"
				+ "à  : gare sait jean (Bordeaux) (04:19:17)\n\tMode : Vélo\n\tType : street_network\n\t"
				+ "Polyline : 109 points (4145 mètres)"
				+ "Polyline : 2 points (31 mètres)"));
	    
	    times.add("0h43:12");
	    journeys.add((">>>	Itinéraire n°2\n\tDépart  : Allée la Roumagne (Talence) (04:00:00)\n\t"
				+ "Arrivée : 30 Place de la Victoire (Bordeaux) (04:20:45)\n\tDurée : 20min45\n\tCorrespondance(s) : 0\n\t"
				+ "Nombre de sections : 2\n\t\t> Section n°1\n\tDe : Arts et Métiers (Talence) (04:02:26)\n\t"
				+ "à  : Victoire (Bordeaux) (04:19:17)\n\tMode : Vélo\n\tType : street_network\n\t"
				+ "Polyline : 109 points (4145 mètres)\n\t\t> Section n°2\n\tDe : 24 Place de la Victoire (Bordeaux) (04:20:17)\n\t"
				+ "à  : 30 Place de la Victoire (Bordeaux) (04:20:45)\n\tMode : Piéton\n\tDistance :30"));
	    times.add("0h18:12");
	    send.setJourneys(journeys);
	    send.setTimes(times);
	    navitia.setJourneys(send, "from="+"-0.605424"+";"+"44.8067872"+"&to="+dest.getLongitude()+
    			";"+dest.getLatitude()+"&datetime=20150220T0400"+"&first_section_mode=bss");
	    BikesAv bi=new BikesAv();
	    List<String>  dep=new ArrayList<String>();
	    List<String>  arr=new ArrayList<String>();
	    dep.add("Arts et Métiers");
	    arr.add("Victoire");
	    bi.setArr(arr);
	    bi.setDep(dep);
	    Bikes bik=new Bikes();
	    List<Integer>  bik1=new ArrayList<Integer>();
	    List<Integer>  bik2=new ArrayList<Integer>();
	    bik1.add(0);
	    bik2.add(15);
	    bik.setStationsBi(bik1);
	    bik.setStationsPl(bik2);
	    bdx.setBikes(bik, bi);
	    Contact him = new Contact("Him", "him@company.com",null,null,null,null);
	    assertTrue(messenger.expectSendMessage(null, null, ">>>	Itinéraire n°2\n\tDépart  : Allée la Roumagne (Talence) (04:00:00)\n\t"
				+ "Arrivée : 30 Place de la Victoire (Bordeaux) (04:20:45)\n\tDurée : 20min45\n\tCorrespondance(s) : 0\n\t"
				+ "Nombre de sections : 2\n\t\t> Section n°1\n\tDe : Arts et Métiers (Talence) (04:02:26)\n\t"
				+ "à  : Victoire (Bordeaux) (04:19:17)\n\tMode : Vélo\n\tType : street_network\n\t"
				+ "Polyline : 109 points (4145 mètres)\n\t\t> Section n°2\n\tDe : 24 Place de la Victoire (Bordeaux) (04:20:17)\n\t"
				+ "à  : 30 Place de la Victoire (Bordeaux) (04:20:45)\n\tMode : Piéton\n\tDistance :30"));
	    assertTrue(mailer.expectSendMessage(him, "Besoin de vélos/places", "On a besoin de: "
	    		+ "\n1 vélo à la station Arts et Métiers"));
	}
	
	/*@Test
	public void test() {
	    PrompterMock prompter=mockPrompter("MockPrompter","here","me");
	    GpsWsMock gps=mockGpsWs("MockGPS");
	    prompter.answer("avenue de Collegno", "1");
	    prompter.answer("-0.605424 44.8067872", "2");
	    GpsCoordinates dest=new GpsCoordinates();
	    dest.setLongitude("-0.573101");
	    dest.setLatitude("44.831207");
	    gps.destCoordinates(dest, "avenue de Collegno");
		
	}*/
	
}
