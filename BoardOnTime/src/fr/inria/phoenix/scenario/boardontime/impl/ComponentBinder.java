package fr.inria.phoenix.scenario.boardontime.impl;
        
import fr.inria.phoenix.diasuite.framework.context.bike_availability.AbstractBike_availability;
import fr.inria.phoenix.diasuite.framework.context.bikechecker.AbstractBikeChecker;
import fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion;
import fr.inria.phoenix.diasuite.framework.context.incidentdetection.AbstractIncidentDetection;
import fr.inria.phoenix.diasuite.framework.context.journeycomputer.AbstractJourneyComputer;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection;
import fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher;
import fr.inria.phoenix.diasuite.framework.controller.transportercontroller.AbstractTransporterController;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;
import fr.inria.phoenix.scenario.boardontime.impl.context.BikeChecker;
import fr.inria.phoenix.scenario.boardontime.impl.context.Bike_availability;
import fr.inria.phoenix.scenario.boardontime.impl.context.GpsConversion;
import fr.inria.phoenix.scenario.boardontime.impl.context.IncidentDetection;
import fr.inria.phoenix.scenario.boardontime.impl.context.JourneyComputer;
import fr.inria.phoenix.scenario.boardontime.impl.context.JourneySelection;
import fr.inria.phoenix.scenario.boardontime.impl.controller.Dispatcher;
import fr.inria.phoenix.scenario.boardontime.impl.controller.TransporterController;

/* (non-Javadoc)
 * The binder to provides the various components of the application
 * @see fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder
 */
public class ComponentBinder extends AppComponentBinder {

	@Override
	public Class<? extends AbstractBikeChecker> getBikeCheckerClass() {
		// TODO Auto-generated method stub
		return BikeChecker.class;
	}

	@Override
	public Class<? extends AbstractBike_availability> getBike_availabilityClass() {
		// TODO Auto-generated method stub
		return Bike_availability.class;
	}

	@Override
	public Class<? extends AbstractGpsConversion> getGpsConversionClass() {
		// TODO Auto-generated method stub
		return GpsConversion.class;
	}

	@Override
	public Class<? extends AbstractIncidentDetection> getIncidentDetectionClass() {
		// TODO Auto-generated method stub
		return IncidentDetection.class;
	}

	@Override
	public Class<? extends AbstractJourneyComputer> getJourneyComputerClass() {
		// TODO Auto-generated method stub
		return JourneyComputer.class;
	}

	@Override
	public Class<? extends AbstractJourneySelection> getJourneySelectionClass() {
		// TODO Auto-generated method stub
		return JourneySelection.class;
	}

	@Override
	public Class<? extends AbstractDispatcher> getDispatcherClass() {
		// TODO Auto-generated method stub
		return Dispatcher.class;
	}

	@Override
	public Class<? extends AbstractTransporterController> getTransporterControllerClass() {
		// TODO Auto-generated method stub
		return TransporterController.class;
	}
}
