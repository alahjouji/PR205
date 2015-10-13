package fr.inria.phoenix.scenario.boardontime.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.controller.transportercontroller.AbstractTransporterController;
import fr.inria.phoenix.diasuite.framework.context.bike_availability.Bike_availabilityValue;
import fr.inria.phoenix.diasuite.framework.datatype.contact.Contact;

/* (non-Javadoc)
 * The implementation of the TransporterController context
 * @see fr.inria.phoenix.diasuite.framework.controller.transportercontroller.AbstractTransporterController
 */
public class TransporterController extends AbstractTransporterController {
    
    public TransporterController(ServiceConfiguration serviceConfiguration) {
        super(serviceConfiguration);
    }

    /* (non-Javadoc)
     * @see fr.inria.phoenix.diasuite.framework.controller.transportercontroller.AbstractTransporterController#onBike_availability(Bike_availabilityValue, DiscoverForBike_availability)
     */
    @Override
    protected void onBike_availability(Bike_availabilityValue bike_availability, DiscoverForBike_availability discover) {
        // TODO Auto-generated method stub
	    Contact him = new Contact("Him", "him@company.com",null, null, null, null);
    	discover.mailers().anyOne().sendMessage(him, "Besoin de vélos/places", bike_availability.value(), null);
    }
}
