package fr.inria.phoenix.scenario.boardontime.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.bikechecker.AbstractBikeChecker;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.JourneySelectionValue;

/* (non-Javadoc)
 * The implementation of the BikeChecker context
 * @see fr.inria.phoenix.diasuite.framework.context.bikechecker.AbstractBikeChecker
 */
public class BikeChecker extends AbstractBikeChecker {
    
    public BikeChecker(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.bikechecker.AbstractBikeChecker#onJourneySelection(JourneySelectionValue)
     */
    @Override
    protected BikeCheckerValuePublishable onJourneySelection(JourneySelectionValue journeySelectionValue) {
        // TODO Auto-generated method stub
    	String journey = journeySelectionValue.value(); 
    	if(journey.contains("Mode : Vélo"))
    		return new BikeCheckerValuePublishable(journey, true);
    	return new BikeCheckerValuePublishable(journey, false);
    }
}
