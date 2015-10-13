package fr.inria.phoenix.diasuite.framework.misc;

import fr.inria.diagen.core.deploy.AbstractDeploy;

import fr.inria.phoenix.diasuite.framework.context.bikechecker.AbstractBikeChecker;
import fr.inria.phoenix.diasuite.framework.context.bike_availability.AbstractBike_availability;
import fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion;
import fr.inria.phoenix.diasuite.framework.context.incidentdetection.AbstractIncidentDetection;
import fr.inria.phoenix.diasuite.framework.context.journeycomputer.AbstractJourneyComputer;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection;

import fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher;
import fr.inria.phoenix.diasuite.framework.controller.transportercontroller.AbstractTransporterController;

/**
 * This class should be implemented to bind the implementation of the various components
 */
public abstract class AppComponentBinder extends AbstractDeploy {

    // Context instances
    private AbstractBikeChecker bikeCheckerInstance = null;
    private AbstractBike_availability bike_availabilityInstance = null;
    private AbstractGpsConversion gpsConversionInstance = null;
    private AbstractIncidentDetection incidentDetectionInstance = null;
    private AbstractJourneyComputer journeyComputerInstance = null;
    private AbstractJourneySelection journeySelectionInstance = null;

    // Controller instances
    private AbstractDispatcher dispatcherInstance = null;
    private AbstractTransporterController transporterControllerInstance = null;
    
    @Override
    public void deployAll() {
        // Initialization of contexts
        if (bikeCheckerInstance == null)
            bikeCheckerInstance = getInstance(getBikeCheckerClass());
        if (bike_availabilityInstance == null)
            bike_availabilityInstance = getInstance(getBike_availabilityClass());
        if (gpsConversionInstance == null)
            gpsConversionInstance = getInstance(getGpsConversionClass());
        if (incidentDetectionInstance == null)
            incidentDetectionInstance = getInstance(getIncidentDetectionClass());
        if (journeyComputerInstance == null)
            journeyComputerInstance = getInstance(getJourneyComputerClass());
        if (journeySelectionInstance == null)
            journeySelectionInstance = getInstance(getJourneySelectionClass());
        // Intialization of controllers
        if (dispatcherInstance == null)
            dispatcherInstance = getInstance(getDispatcherClass());
        if (transporterControllerInstance == null)
            transporterControllerInstance = getInstance(getTransporterControllerClass());
        // Deploying contexts
        deploy(bikeCheckerInstance);
        deploy(bike_availabilityInstance);
        deploy(gpsConversionInstance);
        deploy(incidentDetectionInstance);
        deploy(journeyComputerInstance);
        deploy(journeySelectionInstance);
        // Deploying controllers
        deploy(dispatcherInstance);
        deploy(transporterControllerInstance);
    }
    
    @Override
    public void undeployAll() {
        // Undeploying contexts
        undeploy(bikeCheckerInstance);
        undeploy(bike_availabilityInstance);
        undeploy(gpsConversionInstance);
        undeploy(incidentDetectionInstance);
        undeploy(journeyComputerInstance);
        undeploy(journeySelectionInstance);
        // Undeploying controllers
        undeploy(dispatcherInstance);
        undeploy(transporterControllerInstance);
    }
    
    // Abstract binding methods for contexts
    /**
     * Overrides this method to provide the implementation class of the <code>BikeChecker</code> context
    <p>
    context 2bis
    
    <pre>
    context BikeChecker as String {
     * 	when provided JourneySelection
     * 	maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractBikeChecker} that implements the <code>BikeChecker</code> context
     */
    public abstract Class<? extends AbstractBikeChecker> getBikeCheckerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>Bike_availability</code> context
    <p>
    context 4
    
    <pre>
    context Bike_availability as String{
     *     when provided BikeChecker
     *     get bikes from BordeauxMetropole
     *     maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractBike_availability} that implements the <code>Bike_availability</code> context
     */
    public abstract Class<? extends AbstractBike_availability> getBike_availabilityClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>GpsConversion</code> context
    <p>
    context 0
    
    <pre>
    context GpsConversion as GpsCoordinates {
     *     when provided answer from Prompter
     *     get destCoordinates from GpsWs
     *     no publish; 
     *    when required;   
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractGpsConversion} that implements the <code>GpsConversion</code> context
     */
    public abstract Class<? extends AbstractGpsConversion> getGpsConversionClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>IncidentDetection</code> context
    <p>
    context 3
    
    <pre>
    context IncidentDetection as Boolean {
     *     when provided timerTriggered from Timer 
     *     get JourneySelection, real_time_schedules from BordeauxMetropole, theoretical_schedules from BordeauxMetropole
     *     maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractIncidentDetection} that implements the <code>IncidentDetection</code> context
     */
    public abstract Class<? extends AbstractIncidentDetection> getIncidentDetectionClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>JourneyComputer</code> context
    <p>
    context 1
    
    <pre>
    context JourneyComputer as Sending {
     *     when provided answer from Prompter
     *     get GpsConversion, journeys from NavitiaWS
     *     always publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractJourneyComputer} that implements the <code>JourneyComputer</code> context
     */
    public abstract Class<? extends AbstractJourneyComputer> getJourneyComputerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>JourneySelection</code> context
    <p>
    context 2
    
    <pre>
    context JourneySelection as String {
     * 	when provided JourneyComputer
     * 	always publish; 
     * 	when required;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractJourneySelection} that implements the <code>JourneySelection</code> context
     */
    public abstract Class<? extends AbstractJourneySelection> getJourneySelectionClass();
    
    // End of abstract binding methods for contexts
    
    // Abstract binding methods for controllers
    /**
     * Overrides this method to provide the implementation class of the <code>Dispatcher</code> controller
    <p>
    BoardOnTime controller
    
    <pre>
    controller Dispatcher {
     * 	when provided  JourneySelection
     * 	do SendMessage on Messenger;  
     * 	when provided  IncidentDetection
     * 	do Notification on Notifier;     
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractDispatcher} that implements the <code>Dispatcher</code> controller
     */
    public abstract Class<? extends AbstractDispatcher> getDispatcherClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>TransporterController</code> controller
    
    <pre>
    controller TransporterController{
     * 	when provided Bike_availability
     * 	do SendMessage on Mailer;    
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractTransporterController} that implements the <code>TransporterController</code> controller
     */
    public abstract Class<? extends AbstractTransporterController> getTransporterControllerClass();
    
    // End of abstract binding methods for controllers
}
