package fr.inria.phoenix.scenario.boardontime.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher;
import fr.inria.phoenix.diasuite.framework.context.incidentdetection.IncidentDetectionValue;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.JourneySelectionValue;
/* (non-Javadoc)
 * The implementation of the Dispatcher context
 * @see fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher
 */
public class Dispatcher extends AbstractDispatcher {
    
    public Dispatcher(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }

    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher#onJourneySelection(JourneySelectionValue, DiscoverForJourneySelection)
     */
    @Override
    protected void onJourneySelection(JourneySelectionValue journeySelection, DiscoverForJourneySelection discover) {
        // TODO Auto-generated method stub
    	discover.messengers().anyOne().sendMessage(null, null, journeySelection.value(), null);
    }

    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher#onIncidentDetection(IncidentDetectionValue, DiscoverForIncidentDetection)
     */
    @Override
    protected void onIncidentDetection(IncidentDetectionValue incidentDetection, DiscoverForIncidentDetection discover) {
        // TODO Auto-generated method stub
    }
}
