package fr.inria.phoenix.scenario.gpsws.impl;

import fr.inria.diagen.commlayer.driver.DeviceActivator;

public class Activator extends DeviceActivator {

    // Description, name and ID
    private static final String DEVICE_DESCRIPTION = "A GpsWs implementation"; // TODO auto-generated variable
    private static final String DEVICE_NAME = "GpsWs"; // TODO auto-generated variable
    private static final String DEVICE_ID = "fr.inria.phoenix.diasuite.framework.device.gpsws"; // TODO auto-generated variable

    /**
     * The constructor
     */
    public Activator() {
        // Declare ourself
        super(DEVICE_ID, DEVICE_NAME, DEVICE_DESCRIPTION);
        // TODO auto-generated stub. Please use {@link DeviceActivator#addEnabler(DeviceEnabler)} to declare your enablers
    }
    
    protected void onInitialize() {
    	addDevice(new GpsWs(getServiceConfiguration("GpsWs")));
        // TODO auto-generated stub. Please use {@link DeviceActivator#addDevice(Service)} to declare your devices
    }
    
    public static void main(String[] args) throws Exception {
        new Activator().execute(args);
    }
}
