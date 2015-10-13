package fr.inria.phoenix.scenario.boardontime.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.journeycomputer.AbstractJourneyComputer;
import fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates;
import fr.inria.phoenix.diasuite.framework.datatype.sending.Sending;
import fr.inria.phoenix.diasuite.framework.device.prompter.AnswerFromPrompter;

/* (non-Javadoc)
 * The implementation of the JourneyComputer context
 * @see fr.inria.phoenix.diasuite.framework.context.journeycomputer.AbstractJourneyComputer
 */
public class JourneyComputer extends AbstractJourneyComputer {
    
    public JourneyComputer(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.journeycomputer.AbstractJourneyComputer#onAnswerFromPrompter(AnswerFromPrompter, DiscoverForAnswerFromPrompter)
     */
    @Override
    protected Sending onAnswerFromPrompter(AnswerFromPrompter answerFromPrompter, DiscoverForAnswerFromPrompter discover) {
        // TODO Auto-generated method stub
    	String gpsLocation = answerFromPrompter.value();
    	System.out.println("jc    "+gpsLocation);
    	String[] result = gpsLocation.split("\\s");
    	GpsCoordinates depCoord=new GpsCoordinates();
    	depCoord.setLongitude(result[0]);
    	depCoord.setLatitude(result[1]);
    	GpsCoordinates destCoord = discover.gpsConversion();
    	System.out.println("jc    "+destCoord.getLongitude());
    	System.out.println("jc    "+destCoord.getLatitude());
    	String format = "yyyyMMdd'T'HHmm";
    	java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
    	java.util.Date date = new java.util.Date(); 
    	String a=formater.format(date);
    	String nav="from="+depCoord.getLongitude()+";"+depCoord.getLatitude()+"&to="+destCoord.getLongitude()+
    			";"+destCoord.getLatitude()+"&datetime="+a+"&first_section_mode=bss";
    	Sending journeys=discover.navitiaWSs().anyOne().getJourneys(nav);
    	
        return journeys;
    }
}
