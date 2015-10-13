package fr.inria.phoenix.scenario.boardontime.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.incidentdetection.AbstractIncidentDetection;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

/* (non-Javadoc)
 * The implementation of the IncidentDetection context
 * @see fr.inria.phoenix.diasuite.framework.context.incidentdetection.AbstractIncidentDetection
 */
public class IncidentDetection extends AbstractIncidentDetection {
    
    public IncidentDetection(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }
    
    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.context.incidentdetection.AbstractIncidentDetection#onTimerTriggeredFromTimer(TimerTriggeredFromTimer, DiscoverForTimerTriggeredFromTimer)
     */
    @Override
    protected IncidentDetectionValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer, DiscoverForTimerTriggeredFromTimer discover) {
        // TODO Auto-generated method stub
        return null;
    }
}
