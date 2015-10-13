package fr.inria.phoenix.scenario.boardontime.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion;
import fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates;
import fr.inria.phoenix.diasuite.framework.device.prompter.AnswerFromPrompter;

/* (non-Javadoc)
 * The implementation of the GpsConversion context
 * @see fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion
 */
public class GpsConversion extends AbstractGpsConversion {
    private GpsCoordinates destCoord;
    public GpsConversion(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion#onAnswerFromPrompter(AnswerFromPrompter, DiscoverForAnswerFromPrompter)
     */
    @Override
    protected void onAnswerFromPrompter(AnswerFromPrompter answerFromPrompter, DiscoverForAnswerFromPrompter discover) {
        // TODO Auto-generated method stub
    	String destAdress = answerFromPrompter.value();
    	System.out.println("gps    "+destAdress);
    	destCoord = discover.gpsWss().anyOne().getDestCoordinates(destAdress);
    	System.out.println("gps    "+destCoord.getLongitude());
    	System.out.println("gps    "+destCoord.getLatitude());
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion#getValue()
     */
    @Override
    protected GpsCoordinates getValue() {
        // TODO Auto-generated method stub
        return destCoord;
    }
}
