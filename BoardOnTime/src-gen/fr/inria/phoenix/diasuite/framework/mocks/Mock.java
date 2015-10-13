package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;
import fr.inria.phoenix.diasuite.framework.controller.dispatcher.AbstractDispatcher;
import fr.inria.phoenix.diasuite.framework.controller.transportercontroller.AbstractTransporterController;
import fr.inria.phoenix.diasuite.framework.context.bikechecker.AbstractBikeChecker;
import fr.inria.phoenix.diasuite.framework.context.bike_availability.AbstractBike_availability;
import fr.inria.phoenix.diasuite.framework.context.gpsconversion.AbstractGpsConversion;
import fr.inria.phoenix.diasuite.framework.context.incidentdetection.AbstractIncidentDetection;
import fr.inria.phoenix.diasuite.framework.context.journeycomputer.AbstractJourneyComputer;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.AbstractJourneySelection;

/**
 * Use this class to test your DiaSuite application.
 *
 * <p>
 * Here is n example of usage to test an application that should trigger an action <code>action</code> on a device <code>TestDevice</code>
 * when it receive a source "src" from this device:
 * <pre>
 * ...
 * import static fr.inria.phoenix.diasuite.framework.mocks.Mock.*;
 * ...
 *    @Before
 *    public void setUp() throws Exception {
 *        underTest(MyAppComponentBinder.class);
 *    }
 *    
 *    @After
 *    public void tearDown() {
 *        shutdown();
 *    }
 *    
 *    @Test
 *    public void testMyApplication() {
 *        assertTrue(mockTestDevice().src("hehe").expectAction());
 *    }
 * ...
 */
@SuppressWarnings("all")
public final class Mock extends AppComponentBinder {
    
    /**
     * The time out, in milliseconds, before considering an action will never happens.
     * It should be changed if the application has long computations.
     */
    public static long TIMEOUT = 1000;
    
    private static Mock mocker;
    
    /**
     * Put a class under test
     * @param binder The application class
     * @return The mocking factory
     */
    public static Mock underTest(Class<? extends AppComponentBinder> binder) throws Exception {
        mocker = new Mock(binder);
        return mocker;
    }
    
    /**
     * Tear-down the device mocking framework
     */
    public static void shutdown() {
        if(mocker != null)
            mocker.undeployAll();
        mocker = null;
    }
    
    private AppComponentBinder delegate;
    private Mock(Class<? extends AppComponentBinder> binder) throws Exception {
        delegate = binder.newInstance();
        // Starts the framework
        deployAll();
    }
    
    @SuppressWarnings("unchecked")
    public ServiceConfiguration getServiceConfiguration(String name) {
        try {
            Class<? extends ServiceConfiguration> clazz = (Class<? extends ServiceConfiguration>) Class.forName("fr.inria.diagen.commlayer.local.LocalServiceConfiguration");
            java.lang.reflect.Constructor<? extends ServiceConfiguration> constructor = clazz.getConstructor(String.class);
            return constructor.newInstance(name);
        } catch (Exception ex) {
            fr.inria.diagen.log.DiaLog.critical("Unabled to initialize local communication layer. Please make sure correct libraries are in the classpath", ex);
            System.exit(-1);
            return null;
        }
    }
    
    private String randomId() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 10; i++)
            result.append(Integer.toString((int) (Math.random() * 10)));
        return result.toString();
    }
    
    // Delegation part
    public Class<? extends AbstractDispatcher> getDispatcherClass() {
        return delegate.getDispatcherClass();
    }
    public Class<? extends AbstractTransporterController> getTransporterControllerClass() {
        return delegate.getTransporterControllerClass();
    }
    public Class<? extends AbstractBikeChecker> getBikeCheckerClass() {
        return delegate.getBikeCheckerClass();
    }
    public Class<? extends AbstractBike_availability> getBike_availabilityClass() {
        return delegate.getBike_availabilityClass();
    }
    public Class<? extends AbstractGpsConversion> getGpsConversionClass() {
        return delegate.getGpsConversionClass();
    }
    public Class<? extends AbstractIncidentDetection> getIncidentDetectionClass() {
        return delegate.getIncidentDetectionClass();
    }
    public Class<? extends AbstractJourneyComputer> getJourneyComputerClass() {
        return delegate.getJourneyComputerClass();
    }
    public Class<? extends AbstractJourneySelection> getJourneySelectionClass() {
        return delegate.getJourneySelectionClass();
    }
    
    // Mocks constructor for all devices
    /**
     * Returns a mock of the device <code>Device</code>.
    <p>
    source eventTime as String;
    
    <pre>
    device Device {
     * 	attribute id as String;
     * 	source isAlive as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Device</code>.
     */
    public DeviceMock device(java.lang.String id) {
        DeviceMock mock = new DeviceMock(getServiceConfiguration("Device" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Device</code>.
    <p>
    source eventTime as String;
    
    <pre>
    device Device {
     * 	attribute id as String;
     * 	source isAlive as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Device</code>.
     */
    public static DeviceMock mockDevice(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.device(id);
    }
    
    /**
     * Returns a mock of the device <code>BordeauxMetropole</code>.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>BordeauxMetropole</code>.
     */
    public BordeauxMetropoleMock bordeauxMetropole(java.lang.String id) {
        BordeauxMetropoleMock mock = new BordeauxMetropoleMock(getServiceConfiguration("BordeauxMetropole" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>BordeauxMetropole</code>.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>BordeauxMetropole</code>.
     */
    public static BordeauxMetropoleMock mockBordeauxMetropole(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.bordeauxMetropole(id);
    }
    
    /**
     * Returns a mock of the device <code>GpsWs</code>.
    
    <pre>
    device GpsWs extends Device {
     * 	source destCoordinates as GpsCoordinates indexed by filter as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>GpsWs</code>.
     */
    public GpsWsMock gpsWs(java.lang.String id) {
        GpsWsMock mock = new GpsWsMock(getServiceConfiguration("GpsWs" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>GpsWs</code>.
    
    <pre>
    device GpsWs extends Device {
     * 	source destCoordinates as GpsCoordinates indexed by filter as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>GpsWs</code>.
     */
    public static GpsWsMock mockGpsWs(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.gpsWs(id);
    }
    
    /**
     * Returns a mock of the device <code>IHM</code>.
    <p>
    ------------------
    IHM
    ------------------------------------
    
    <pre>
    device IHM extends Device {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>IHM</code>.
     */
    public IHMMock iHM(java.lang.String id) {
        IHMMock mock = new IHMMock(getServiceConfiguration("IHM" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>IHM</code>.
    <p>
    ------------------
    IHM
    ------------------------------------
    
    <pre>
    device IHM extends Device {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>IHM</code>.
     */
    public static IHMMock mockIHM(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.iHM(id);
    }
    
    /**
     * Returns a mock of the device <code>ApplianceDashBoard</code>.
    
    <pre>
    device ApplianceDashBoard extends IHM {
     * 	action ADBStatus;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>ApplianceDashBoard</code>.
     */
    public ApplianceDashBoardMock applianceDashBoard(java.lang.String id) {
        ApplianceDashBoardMock mock = new ApplianceDashBoardMock(getServiceConfiguration("ApplianceDashBoard" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ApplianceDashBoard</code>.
    
    <pre>
    device ApplianceDashBoard extends IHM {
     * 	action ADBStatus;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>ApplianceDashBoard</code>.
     */
    public static ApplianceDashBoardMock mockApplianceDashBoard(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.applianceDashBoard(id);
    }
    
    /**
     * Returns a mock of the device <code>NavitiaWS</code>.
    
    <pre>
    device NavitiaWS extends Device {
     * 	source journeys as Sending indexed by filter as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>NavitiaWS</code>.
     */
    public NavitiaWSMock navitiaWS(java.lang.String id) {
        NavitiaWSMock mock = new NavitiaWSMock(getServiceConfiguration("NavitiaWS" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>NavitiaWS</code>.
    
    <pre>
    device NavitiaWS extends Device {
     * 	source journeys as Sending indexed by filter as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>NavitiaWS</code>.
     */
    public static NavitiaWSMock mockNavitiaWS(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.navitiaWS(id);
    }
    
    /**
     * Returns a mock of the device <code>PhotoLibrary</code>.
    <p>
    ** DEVICES **
    
    <pre>
    device PhotoLibrary extends Device {
     * 	attribute owner as String;
     * 	source photos as Photo [] indexed by filter as PhotoFilter;
     * 	source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
     * 	action AddPhoto;
     * 	action AddPhotoToAlbum;
     * 	action RemovePhoto;
     * 	action RemovePhotoFromAlbum;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>PhotoLibrary</code>.
     */
    public PhotoLibraryMock photoLibrary(java.lang.String id,
            java.lang.String owner) {
        PhotoLibraryMock mock = new PhotoLibraryMock(getServiceConfiguration("PhotoLibrary" + randomId()), id, owner);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>PhotoLibrary</code>.
    <p>
    ** DEVICES **
    
    <pre>
    device PhotoLibrary extends Device {
     * 	attribute owner as String;
     * 	source photos as Photo [] indexed by filter as PhotoFilter;
     * 	source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
     * 	action AddPhoto;
     * 	action AddPhotoToAlbum;
     * 	action RemovePhoto;
     * 	action RemovePhotoFromAlbum;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>PhotoLibrary</code>.
     */
    public static PhotoLibraryMock mockPhotoLibrary(java.lang.String id,
            java.lang.String owner) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.photoLibrary(id, owner);
    }
    
    /**
     * Returns a mock of the device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    device SocialNetworkPhotoLibrary extends PhotoLibrary {
     * 	source recentPhotosSharedByContacts as Photo [] indexed by filter as PhotoFilter;
     * 	source tags as Tag [] indexed by photoID as String;
     * 	source comments as Comment [] indexed by photoID as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>SocialNetworkPhotoLibrary</code>.
     */
    public SocialNetworkPhotoLibraryMock socialNetworkPhotoLibrary(java.lang.String id,
            java.lang.String owner) {
        SocialNetworkPhotoLibraryMock mock = new SocialNetworkPhotoLibraryMock(getServiceConfiguration("SocialNetworkPhotoLibrary" + randomId()), id, owner);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    device SocialNetworkPhotoLibrary extends PhotoLibrary {
     * 	source recentPhotosSharedByContacts as Photo [] indexed by filter as PhotoFilter;
     * 	source tags as Tag [] indexed by photoID as String;
     * 	source comments as Comment [] indexed by photoID as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>SocialNetworkPhotoLibrary</code>.
     */
    public static SocialNetworkPhotoLibraryMock mockSocialNetworkPhotoLibrary(java.lang.String id,
            java.lang.String owner) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.socialNetworkPhotoLibrary(id, owner);
    }
    
    /**
     * Returns a mock of the device <code>PhysicalDevice</code>.
    <p>
    -------------------------
    -- DEVICES
    -------------------------
    
    <pre>
    device PhysicalDevice extends Device {
     * 	attribute location as String;
     * 	attribute user as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PhysicalDevice</code>.
     */
    public PhysicalDeviceMock physicalDevice(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        PhysicalDeviceMock mock = new PhysicalDeviceMock(getServiceConfiguration("PhysicalDevice" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>PhysicalDevice</code>.
    <p>
    -------------------------
    -- DEVICES
    -------------------------
    
    <pre>
    device PhysicalDevice extends Device {
     * 	attribute location as String;
     * 	attribute user as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PhysicalDevice</code>.
     */
    public static PhysicalDeviceMock mockPhysicalDevice(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.physicalDevice(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Appliance</code>.
    <p>
    source status as OnOff;
    
    <pre>
    device Appliance extends PhysicalDevice {
     * 	action On;
     * 	action Off;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Appliance</code>.
     */
    public ApplianceMock appliance(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ApplianceMock mock = new ApplianceMock(getServiceConfiguration("Appliance" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Appliance</code>.
    <p>
    source status as OnOff;
    
    <pre>
    device Appliance extends PhysicalDevice {
     * 	action On;
     * 	action Off;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Appliance</code>.
     */
    public static ApplianceMock mockAppliance(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.appliance(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Alarm</code>.
    <p>
    source status as OnOff;
    
    <pre>
    device Alarm extends Appliance {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Alarm</code>.
     */
    public AlarmMock alarm(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        AlarmMock mock = new AlarmMock(getServiceConfiguration("Alarm" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Alarm</code>.
    <p>
    source status as OnOff;
    
    <pre>
    device Alarm extends Appliance {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Alarm</code>.
     */
    public static AlarmMock mockAlarm(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.alarm(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ModAlarm</code>.
    
    <pre>
    device ModAlarm extends Alarm {
     * 	attribute modality as Modality;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param modality the value of the <code>modality</code> attribute
    @return a mock of the device <code>ModAlarm</code>.
     */
    public ModAlarmMock modAlarm(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            fr.inria.phoenix.diasuite.framework.datatype.modality.Modality modality) {
        ModAlarmMock mock = new ModAlarmMock(getServiceConfiguration("ModAlarm" + randomId()), id, location, user, modality);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ModAlarm</code>.
    
    <pre>
    device ModAlarm extends Alarm {
     * 	attribute modality as Modality;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param modality the value of the <code>modality</code> attribute
    @return a mock of the device <code>ModAlarm</code>.
     */
    public static ModAlarmMock mockModAlarm(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            fr.inria.phoenix.diasuite.framework.datatype.modality.Modality modality) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.modAlarm(id, location, user, modality);
    }
    
    /**
     * Returns a mock of the device <code>RepetitiveAlarm</code>.
    
    <pre>
    device RepetitiveAlarm extends Alarm {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>RepetitiveAlarm</code>.
     */
    public RepetitiveAlarmMock repetitiveAlarm(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        RepetitiveAlarmMock mock = new RepetitiveAlarmMock(getServiceConfiguration("RepetitiveAlarm" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>RepetitiveAlarm</code>.
    
    <pre>
    device RepetitiveAlarm extends Alarm {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>RepetitiveAlarm</code>.
     */
    public static RepetitiveAlarmMock mockRepetitiveAlarm(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.repetitiveAlarm(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Cooker</code>.
    
    <pre>
    device Cooker extends Appliance {
     * 	source status as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Cooker</code>.
     */
    public CookerMock cooker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        CookerMock mock = new CookerMock(getServiceConfiguration("Cooker" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Cooker</code>.
    
    <pre>
    device Cooker extends Appliance {
     * 	source status as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Cooker</code>.
     */
    public static CookerMock mockCooker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.cooker(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Fan</code>.
    
    <pre>
    device Fan extends Appliance {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Fan</code>.
     */
    public FanMock fan(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        FanMock mock = new FanMock(getServiceConfiguration("Fan" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Fan</code>.
    
    <pre>
    device Fan extends Appliance {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Fan</code>.
     */
    public static FanMock mockFan(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.fan(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Heater</code>.
    
    <pre>
    device Heater extends Appliance {
     * 	source status as OnOff;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Heater</code>.
     */
    public HeaterMock heater(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        HeaterMock mock = new HeaterMock(getServiceConfiguration("Heater" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Heater</code>.
    
    <pre>
    device Heater extends Appliance {
     * 	source status as OnOff;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Heater</code>.
     */
    public static HeaterMock mockHeater(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.heater(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Light</code>.
    
    <pre>
    device Light extends Appliance {
     * 	source status as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Light</code>.
     */
    public LightMock light(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        LightMock mock = new LightMock(getServiceConfiguration("Light" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Light</code>.
    
    <pre>
    device Light extends Appliance {
     * 	source status as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Light</code>.
     */
    public static LightMock mockLight(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.light(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>DimmableLight</code>.
    
    <pre>
    device DimmableLight extends Light {
     * 	action VariationControl;
     * 	source level as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>DimmableLight</code>.
     */
    public DimmableLightMock dimmableLight(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        DimmableLightMock mock = new DimmableLightMock(getServiceConfiguration("DimmableLight" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>DimmableLight</code>.
    
    <pre>
    device DimmableLight extends Light {
     * 	action VariationControl;
     * 	source level as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>DimmableLight</code>.
     */
    public static DimmableLightMock mockDimmableLight(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.dimmableLight(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Thermostat</code>.
    
    <pre>
    device Thermostat extends Appliance {
     * 	action SetTemperature;
     * 	source targetTemperature as Temperature;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Thermostat</code>.
     */
    public ThermostatMock thermostat(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ThermostatMock mock = new ThermostatMock(getServiceConfiguration("Thermostat" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Thermostat</code>.
    
    <pre>
    device Thermostat extends Appliance {
     * 	action SetTemperature;
     * 	source targetTemperature as Temperature;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Thermostat</code>.
     */
    public static ThermostatMock mockThermostat(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.thermostat(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Battery</code>.
    
    <pre>
    device Battery extends PhysicalDevice{
     * 	source batteryState as Integer;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Battery</code>.
     */
    public BatteryMock battery(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        BatteryMock mock = new BatteryMock(getServiceConfiguration("Battery" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Battery</code>.
    
    <pre>
    device Battery extends PhysicalDevice{
     * 	source batteryState as Integer;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Battery</code>.
     */
    public static BatteryMock mockBattery(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.battery(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Button</code>.
    <p>
    ------------------
    Sensors
    ------------------------------------
    
    <pre>
    device Button extends PhysicalDevice {
     * 	source pushed as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Button</code>.
     */
    public ButtonMock button(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ButtonMock mock = new ButtonMock(getServiceConfiguration("Button" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Button</code>.
    <p>
    ------------------
    Sensors
    ------------------------------------
    
    <pre>
    device Button extends PhysicalDevice {
     * 	source pushed as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Button</code>.
     */
    public static ButtonMock mockButton(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.button(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Camera</code>.
    <p>
    ------------------
    Cameras
    ------------------------------------
    
    <pre>
    device Camera extends PhysicalDevice {
     * 	source image as File;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Camera</code>.
     */
    public CameraMock camera(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        CameraMock mock = new CameraMock(getServiceConfiguration("Camera" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Camera</code>.
    <p>
    ------------------
    Cameras
    ------------------------------------
    
    <pre>
    device Camera extends PhysicalDevice {
     * 	source image as File;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Camera</code>.
     */
    public static CameraMock mockCamera(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.camera(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>VideoCamera</code>.
    
    <pre>
    device VideoCamera extends Camera {
     * 	action StartStopRecording;
     * 	source video as File;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>VideoCamera</code>.
     */
    public VideoCameraMock videoCamera(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        VideoCameraMock mock = new VideoCameraMock(getServiceConfiguration("VideoCamera" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>VideoCamera</code>.
    
    <pre>
    device VideoCamera extends Camera {
     * 	action StartStopRecording;
     * 	source video as File;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>VideoCamera</code>.
     */
    public static VideoCameraMock mockVideoCamera(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.videoCamera(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>PTZVideoCamera</code>.
    
    <pre>
    device PTZVideoCamera extends VideoCamera {
     * 	action PTZ;
     * 	source panAngle as Float;
     * 	source tiltAngle as Float;
     * 	source zoom as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PTZVideoCamera</code>.
     */
    public PTZVideoCameraMock pTZVideoCamera(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        PTZVideoCameraMock mock = new PTZVideoCameraMock(getServiceConfiguration("PTZVideoCamera" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>PTZVideoCamera</code>.
    
    <pre>
    device PTZVideoCamera extends VideoCamera {
     * 	action PTZ;
     * 	source panAngle as Float;
     * 	source tiltAngle as Float;
     * 	source zoom as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PTZVideoCamera</code>.
     */
    public static PTZVideoCameraMock mockPTZVideoCamera(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.pTZVideoCamera(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>DoorLocker</code>.
    
    <pre>
    device DoorLocker extends PhysicalDevice {
     * 	action Lock;
     * 	action UnLock;
     * 	source locked as Boolean;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>DoorLocker</code>.
     */
    public DoorLockerMock doorLocker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        DoorLockerMock mock = new DoorLockerMock(getServiceConfiguration("DoorLocker" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>DoorLocker</code>.
    
    <pre>
    device DoorLocker extends PhysicalDevice {
     * 	action Lock;
     * 	action UnLock;
     * 	source locked as Boolean;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>DoorLocker</code>.
     */
    public static DoorLockerMock mockDoorLocker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.doorLocker(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Identifier</code>.
    
    <pre>
    device Identifier extends PhysicalDevice {
     * 	source present as Boolean indexed by id as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Identifier</code>.
     */
    public IdentifierMock identifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        IdentifierMock mock = new IdentifierMock(getServiceConfiguration("Identifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Identifier</code>.
    
    <pre>
    device Identifier extends PhysicalDevice {
     * 	source present as Boolean indexed by id as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Identifier</code>.
     */
    public static IdentifierMock mockIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.identifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>BluetoothIdentifier</code>.
    
    <pre>
    device BluetoothIdentifier extends Identifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>BluetoothIdentifier</code>.
     */
    public BluetoothIdentifierMock bluetoothIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        BluetoothIdentifierMock mock = new BluetoothIdentifierMock(getServiceConfiguration("BluetoothIdentifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>BluetoothIdentifier</code>.
    
    <pre>
    device BluetoothIdentifier extends Identifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>BluetoothIdentifier</code>.
     */
    public static BluetoothIdentifierMock mockBluetoothIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.bluetoothIdentifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>FingerPrintIdentifier</code>.
    
    <pre>
    device FingerPrintIdentifier extends Identifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>FingerPrintIdentifier</code>.
     */
    public FingerPrintIdentifierMock fingerPrintIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        FingerPrintIdentifierMock mock = new FingerPrintIdentifierMock(getServiceConfiguration("FingerPrintIdentifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>FingerPrintIdentifier</code>.
    
    <pre>
    device FingerPrintIdentifier extends Identifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>FingerPrintIdentifier</code>.
     */
    public static FingerPrintIdentifierMock mockFingerPrintIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.fingerPrintIdentifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>RfidIdentifier</code>.
    
    <pre>
    device RfidIdentifier extends Identifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>RfidIdentifier</code>.
     */
    public RfidIdentifierMock rfidIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        RfidIdentifierMock mock = new RfidIdentifierMock(getServiceConfiguration("RfidIdentifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>RfidIdentifier</code>.
    
    <pre>
    device RfidIdentifier extends Identifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>RfidIdentifier</code>.
     */
    public static RfidIdentifierMock mockRfidIdentifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.rfidIdentifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Initiator</code>.
    
    <pre>
    device Initiator extends PhysicalDevice {
     * 	source answer1 as String;
     * 	source answer2 as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Initiator</code>.
     */
    public InitiatorMock initiator(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        InitiatorMock mock = new InitiatorMock(getServiceConfiguration("Initiator" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Initiator</code>.
    
    <pre>
    device Initiator extends PhysicalDevice {
     * 	source answer1 as String;
     * 	source answer2 as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Initiator</code>.
     */
    public static InitiatorMock mockInitiator(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.initiator(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Input</code>.
    
    <pre>
    device Input extends PhysicalDevice {
     * 	source message as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Input</code>.
     */
    public InputMock input(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        InputMock mock = new InputMock(getServiceConfiguration("Input" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Input</code>.
    
    <pre>
    device Input extends PhysicalDevice {
     * 	source message as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Input</code>.
     */
    public static InputMock mockInput(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.input(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>AudioInput</code>.
    
    <pre>
    device AudioInput extends Input {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioInput</code>.
     */
    public AudioInputMock audioInput(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        AudioInputMock mock = new AudioInputMock(getServiceConfiguration("AudioInput" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>AudioInput</code>.
    
    <pre>
    device AudioInput extends Input {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioInput</code>.
     */
    public static AudioInputMock mockAudioInput(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.audioInput(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ScreenInput</code>.
    
    <pre>
    device ScreenInput extends Input {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ScreenInput</code>.
     */
    public ScreenInputMock screenInput(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ScreenInputMock mock = new ScreenInputMock(getServiceConfiguration("ScreenInput" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ScreenInput</code>.
    
    <pre>
    device ScreenInput extends Input {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ScreenInput</code>.
     */
    public static ScreenInputMock mockScreenInput(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.screenInput(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>IntrusionDetector</code>.
    <p>
    ------------------
    Security
    ------------------------------------
    
    <pre>
    device IntrusionDetector extends PhysicalDevice {
     * 	source intrusionDetected as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>IntrusionDetector</code>.
     */
    public IntrusionDetectorMock intrusionDetector(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        IntrusionDetectorMock mock = new IntrusionDetectorMock(getServiceConfiguration("IntrusionDetector" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>IntrusionDetector</code>.
    <p>
    ------------------
    Security
    ------------------------------------
    
    <pre>
    device IntrusionDetector extends PhysicalDevice {
     * 	source intrusionDetected as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>IntrusionDetector</code>.
     */
    public static IntrusionDetectorMock mockIntrusionDetector(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.intrusionDetector(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>KeyPad</code>.
    
    <pre>
    device KeyPad extends PhysicalDevice {
     * 	action UpdateLockStatus;
     * 	source isLocked as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>KeyPad</code>.
     */
    public KeyPadMock keyPad(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        KeyPadMock mock = new KeyPadMock(getServiceConfiguration("KeyPad" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>KeyPad</code>.
    
    <pre>
    device KeyPad extends PhysicalDevice {
     * 	action UpdateLockStatus;
     * 	source isLocked as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>KeyPad</code>.
     */
    public static KeyPadMock mockKeyPad(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.keyPad(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>LoggerSecondTab</code>.
    
    <pre>
    device LoggerSecondTab extends PhysicalDevice{
     * 	source logs as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>LoggerSecondTab</code>.
     */
    public LoggerSecondTabMock loggerSecondTab(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        LoggerSecondTabMock mock = new LoggerSecondTabMock(getServiceConfiguration("LoggerSecondTab" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>LoggerSecondTab</code>.
    
    <pre>
    device LoggerSecondTab extends PhysicalDevice{
     * 	source logs as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>LoggerSecondTab</code>.
     */
    public static LoggerSecondTabMock mockLoggerSecondTab(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.loggerSecondTab(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Messenger</code>.
    <p>
    ------------------
    MESSENGERS
    ------------------------------------
    attribute modality as Modality;
    
    <pre>
    device Messenger extends PhysicalDevice {
     * 	action SendMessage;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Messenger</code>.
     */
    public MessengerMock messenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        MessengerMock mock = new MessengerMock(getServiceConfiguration("Messenger" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Messenger</code>.
    <p>
    ------------------
    MESSENGERS
    ------------------------------------
    attribute modality as Modality;
    
    <pre>
    device Messenger extends PhysicalDevice {
     * 	action SendMessage;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Messenger</code>.
     */
    public static MessengerMock mockMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.messenger(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>AudioMessenger</code>.
    
    <pre>
    device AudioMessenger extends Messenger {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioMessenger</code>.
     */
    public AudioMessengerMock audioMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        AudioMessengerMock mock = new AudioMessengerMock(getServiceConfiguration("AudioMessenger" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>AudioMessenger</code>.
    
    <pre>
    device AudioMessenger extends Messenger {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioMessenger</code>.
     */
    public static AudioMessengerMock mockAudioMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.audioMessenger(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ScreenMessenger</code>.
    
    <pre>
    device ScreenMessenger extends Messenger {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ScreenMessenger</code>.
     */
    public ScreenMessengerMock screenMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ScreenMessengerMock mock = new ScreenMessengerMock(getServiceConfiguration("ScreenMessenger" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ScreenMessenger</code>.
    
    <pre>
    device ScreenMessenger extends Messenger {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ScreenMessenger</code>.
     */
    public static ScreenMessengerMock mockScreenMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.screenMessenger(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>TvMessenger</code>.
    
    <pre>
    device TvMessenger extends Messenger {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TvMessenger</code>.
     */
    public TvMessengerMock tvMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TvMessengerMock mock = new TvMessengerMock(getServiceConfiguration("TvMessenger" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TvMessenger</code>.
    
    <pre>
    device TvMessenger extends Messenger {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TvMessenger</code>.
     */
    public static TvMessengerMock mockTvMessenger(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.tvMessenger(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Microphone</code>.
    
    <pre>
    device Microphone extends PhysicalDevice {
     * 	action StartStopRecording;
     * 	source sound as File;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Microphone</code>.
     */
    public MicrophoneMock microphone(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        MicrophoneMock mock = new MicrophoneMock(getServiceConfiguration("Microphone" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Microphone</code>.
    
    <pre>
    device Microphone extends PhysicalDevice {
     * 	action StartStopRecording;
     * 	source sound as File;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Microphone</code>.
     */
    public static MicrophoneMock mockMicrophone(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.microphone(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Notifier</code>.
    
    <pre>
    device Notifier extends PhysicalDevice {
     * 	action Notification;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Notifier</code>.
     */
    public NotifierMock notifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        NotifierMock mock = new NotifierMock(getServiceConfiguration("Notifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Notifier</code>.
    
    <pre>
    device Notifier extends PhysicalDevice {
     * 	action Notification;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Notifier</code>.
     */
    public static NotifierMock mockNotifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.notifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>AudioNotifier</code>.
    
    <pre>
    device AudioNotifier extends Notifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioNotifier</code>.
     */
    public AudioNotifierMock audioNotifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        AudioNotifierMock mock = new AudioNotifierMock(getServiceConfiguration("AudioNotifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>AudioNotifier</code>.
    
    <pre>
    device AudioNotifier extends Notifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioNotifier</code>.
     */
    public static AudioNotifierMock mockAudioNotifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.audioNotifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>VisualNotifier</code>.
    
    <pre>
    device VisualNotifier extends Notifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>VisualNotifier</code>.
     */
    public VisualNotifierMock visualNotifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        VisualNotifierMock mock = new VisualNotifierMock(getServiceConfiguration("VisualNotifier" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>VisualNotifier</code>.
    
    <pre>
    device VisualNotifier extends Notifier {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>VisualNotifier</code>.
     */
    public static VisualNotifierMock mockVisualNotifier(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.visualNotifier(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>PhotoFrame</code>.
    
    <pre>
    device PhotoFrame extends PhysicalDevice {
     * 	source photos as File[];
     * 	action PhotoFrameManagement;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PhotoFrame</code>.
     */
    public PhotoFrameMock photoFrame(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        PhotoFrameMock mock = new PhotoFrameMock(getServiceConfiguration("PhotoFrame" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>PhotoFrame</code>.
    
    <pre>
    device PhotoFrame extends PhysicalDevice {
     * 	source photos as File[];
     * 	action PhotoFrameManagement;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PhotoFrame</code>.
     */
    public static PhotoFrameMock mockPhotoFrame(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.photoFrame(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Prompter</code>.
    
    <pre>
    device Prompter extends PhysicalDevice {
     * 	action AskQuestion;
     * 	source answer as String indexed by questionId as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Prompter</code>.
     */
    public PrompterMock prompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        PrompterMock mock = new PrompterMock(getServiceConfiguration("Prompter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Prompter</code>.
    
    <pre>
    device Prompter extends PhysicalDevice {
     * 	action AskQuestion;
     * 	source answer as String indexed by questionId as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Prompter</code>.
     */
    public static PrompterMock mockPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.prompter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>AudioPrompter</code>.
    
    <pre>
    device AudioPrompter extends Prompter {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioPrompter</code>.
     */
    public AudioPrompterMock audioPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        AudioPrompterMock mock = new AudioPrompterMock(getServiceConfiguration("AudioPrompter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>AudioPrompter</code>.
    
    <pre>
    device AudioPrompter extends Prompter {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>AudioPrompter</code>.
     */
    public static AudioPrompterMock mockAudioPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.audioPrompter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ScreenPrompter</code>.
    
    <pre>
    device ScreenPrompter extends Prompter {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ScreenPrompter</code>.
     */
    public ScreenPrompterMock screenPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ScreenPrompterMock mock = new ScreenPrompterMock(getServiceConfiguration("ScreenPrompter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ScreenPrompter</code>.
    
    <pre>
    device ScreenPrompter extends Prompter {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ScreenPrompter</code>.
     */
    public static ScreenPrompterMock mockScreenPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.screenPrompter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>TvPrompter</code>.
    
    <pre>
    device TvPrompter extends Prompter {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TvPrompter</code>.
     */
    public TvPrompterMock tvPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TvPrompterMock mock = new TvPrompterMock(getServiceConfiguration("TvPrompter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TvPrompter</code>.
    
    <pre>
    device TvPrompter extends Prompter {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TvPrompter</code>.
     */
    public static TvPrompterMock mockTvPrompter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.tvPrompter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>RemoteControl</code>.
    
    <pre>
    device RemoteControl extends PhysicalDevice {
     * 	source order as MultimediaOrder;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>RemoteControl</code>.
     */
    public RemoteControlMock remoteControl(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        RemoteControlMock mock = new RemoteControlMock(getServiceConfiguration("RemoteControl" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>RemoteControl</code>.
    
    <pre>
    device RemoteControl extends PhysicalDevice {
     * 	source order as MultimediaOrder;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>RemoteControl</code>.
     */
    public static RemoteControlMock mockRemoteControl(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.remoteControl(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Sensor</code>.
    
    <pre>
    device Sensor extends PhysicalDevice {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Sensor</code>.
     */
    public SensorMock sensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        SensorMock mock = new SensorMock(getServiceConfiguration("Sensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Sensor</code>.
    
    <pre>
    device Sensor extends PhysicalDevice {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Sensor</code>.
     */
    public static SensorMock mockSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.sensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>COSensor</code>.
    
    <pre>
    device COSensor extends Sensor {
     * 	source smoke as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>COSensor</code>.
     */
    public COSensorMock cOSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        COSensorMock mock = new COSensorMock(getServiceConfiguration("COSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>COSensor</code>.
    
    <pre>
    device COSensor extends Sensor {
     * 	source smoke as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>COSensor</code>.
     */
    public static COSensorMock mockCOSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.cOSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ContactSensor</code>.
    
    <pre>
    device ContactSensor extends Sensor {
     * 	source state as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ContactSensor</code>.
     */
    public ContactSensorMock contactSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ContactSensorMock mock = new ContactSensorMock(getServiceConfiguration("ContactSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ContactSensor</code>.
    
    <pre>
    device ContactSensor extends Sensor {
     * 	source state as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ContactSensor</code>.
     */
    public static ContactSensorMock mockContactSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.contactSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>EnergyMeter</code>.
    
    <pre>
    device EnergyMeter extends Sensor {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>EnergyMeter</code>.
     */
    public EnergyMeterMock energyMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        EnergyMeterMock mock = new EnergyMeterMock(getServiceConfiguration("EnergyMeter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>EnergyMeter</code>.
    
    <pre>
    device EnergyMeter extends Sensor {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>EnergyMeter</code>.
     */
    public static EnergyMeterMock mockEnergyMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.energyMeter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ElectricMeter</code>.
    
    <pre>
    device ElectricMeter extends EnergyMeter {
     * 	source currentElectricConsumption as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ElectricMeter</code>.
     */
    public ElectricMeterMock electricMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ElectricMeterMock mock = new ElectricMeterMock(getServiceConfiguration("ElectricMeter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ElectricMeter</code>.
    
    <pre>
    device ElectricMeter extends EnergyMeter {
     * 	source currentElectricConsumption as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ElectricMeter</code>.
     */
    public static ElectricMeterMock mockElectricMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.electricMeter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>GasMeter</code>.
    
    <pre>
    device GasMeter extends EnergyMeter {
     * 	source currentGasConsumption as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>GasMeter</code>.
     */
    public GasMeterMock gasMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        GasMeterMock mock = new GasMeterMock(getServiceConfiguration("GasMeter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>GasMeter</code>.
    
    <pre>
    device GasMeter extends EnergyMeter {
     * 	source currentGasConsumption as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>GasMeter</code>.
     */
    public static GasMeterMock mockGasMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.gasMeter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>WaterMeter</code>.
    
    <pre>
    device WaterMeter extends EnergyMeter {
     * 	source currentWaterConsumption as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>WaterMeter</code>.
     */
    public WaterMeterMock waterMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        WaterMeterMock mock = new WaterMeterMock(getServiceConfiguration("WaterMeter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>WaterMeter</code>.
    
    <pre>
    device WaterMeter extends EnergyMeter {
     * 	source currentWaterConsumption as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>WaterMeter</code>.
     */
    public static WaterMeterMock mockWaterMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.waterMeter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>HumiditySensor</code>.
    
    <pre>
    device HumiditySensor extends Sensor {
     * 	source level as Integer;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>HumiditySensor</code>.
     */
    public HumiditySensorMock humiditySensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        HumiditySensorMock mock = new HumiditySensorMock(getServiceConfiguration("HumiditySensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>HumiditySensor</code>.
    
    <pre>
    device HumiditySensor extends Sensor {
     * 	source level as Integer;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>HumiditySensor</code>.
     */
    public static HumiditySensorMock mockHumiditySensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.humiditySensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>LightSensor</code>.
    
    <pre>
    device LightSensor extends Sensor {
     * 	source level as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>LightSensor</code>.
     */
    public LightSensorMock lightSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        LightSensorMock mock = new LightSensorMock(getServiceConfiguration("LightSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>LightSensor</code>.
    
    <pre>
    device LightSensor extends Sensor {
     * 	source level as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>LightSensor</code>.
     */
    public static LightSensorMock mockLightSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.lightSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>MotionDetector</code>.
    <p>
    structure ContactSens{
     * 	state as Boolean;
     * 	timestamp as String;
     * }
     * structure State{
     * 	state as Float;
     * 	timestamp as String;
     * }
     * structure ElectricConsumption{
     * 	currentElectricConsumption as Float;
     * 	timestamp as String;
     * }
    source timestamp as Timestamp;
    
    <pre>
    device MotionDetector extends Sensor {
     * 	source motion as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>MotionDetector</code>.
     */
    public MotionDetectorMock motionDetector(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        MotionDetectorMock mock = new MotionDetectorMock(getServiceConfiguration("MotionDetector" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>MotionDetector</code>.
    <p>
    structure ContactSens{
     * 	state as Boolean;
     * 	timestamp as String;
     * }
     * structure State{
     * 	state as Float;
     * 	timestamp as String;
     * }
     * structure ElectricConsumption{
     * 	currentElectricConsumption as Float;
     * 	timestamp as String;
     * }
    source timestamp as Timestamp;
    
    <pre>
    device MotionDetector extends Sensor {
     * 	source motion as State;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>MotionDetector</code>.
     */
    public static MotionDetectorMock mockMotionDetector(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.motionDetector(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>OverflowSensor</code>.
    
    <pre>
    device OverflowSensor extends Sensor {
     * 	source overflow as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>OverflowSensor</code>.
     */
    public OverflowSensorMock overflowSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        OverflowSensorMock mock = new OverflowSensorMock(getServiceConfiguration("OverflowSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>OverflowSensor</code>.
    
    <pre>
    device OverflowSensor extends Sensor {
     * 	source overflow as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>OverflowSensor</code>.
     */
    public static OverflowSensorMock mockOverflowSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.overflowSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>SmokeSensor</code>.
    
    <pre>
    device SmokeSensor extends Sensor {
     * 	source smoke as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>SmokeSensor</code>.
     */
    public SmokeSensorMock smokeSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        SmokeSensorMock mock = new SmokeSensorMock(getServiceConfiguration("SmokeSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>SmokeSensor</code>.
    
    <pre>
    device SmokeSensor extends Sensor {
     * 	source smoke as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>SmokeSensor</code>.
     */
    public static SmokeSensorMock mockSmokeSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.smokeSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>TemperatureSensor</code>.
    
    <pre>
    device TemperatureSensor extends Sensor {
     * 	source temperature as Float indexed by unit as TemperatureUnit;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TemperatureSensor</code>.
     */
    public TemperatureSensorMock temperatureSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TemperatureSensorMock mock = new TemperatureSensorMock(getServiceConfiguration("TemperatureSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TemperatureSensor</code>.
    
    <pre>
    device TemperatureSensor extends Sensor {
     * 	source temperature as Float indexed by unit as TemperatureUnit;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TemperatureSensor</code>.
     */
    public static TemperatureSensorMock mockTemperatureSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.temperatureSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ServiceTablet</code>.
    
    <pre>
    device ServiceTablet extends PhysicalDevice {
     * 	action PushContacts;
     * 	source tabletMode as ServiceTabletMode;
     * 	source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ServiceTablet</code>.
     */
    public ServiceTabletMock serviceTablet(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ServiceTabletMock mock = new ServiceTabletMock(getServiceConfiguration("ServiceTablet" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ServiceTablet</code>.
    
    <pre>
    device ServiceTablet extends PhysicalDevice {
     * 	action PushContacts;
     * 	source tabletMode as ServiceTabletMode;
     * 	source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>ServiceTablet</code>.
     */
    public static ServiceTabletMock mockServiceTablet(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.serviceTablet(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Shutter</code>.
    <p>
    MISC
    
    <pre>
    device Shutter extends PhysicalDevice {
     * 	action Open;
     * 	action Close;
     * 	action SetShutterPosition;
     * 	source position as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Shutter</code>.
     */
    public ShutterMock shutter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ShutterMock mock = new ShutterMock(getServiceConfiguration("Shutter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Shutter</code>.
    <p>
    MISC
    
    <pre>
    device Shutter extends PhysicalDevice {
     * 	action Open;
     * 	action Close;
     * 	action SetShutterPosition;
     * 	source position as Float;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Shutter</code>.
     */
    public static ShutterMock mockShutter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.shutter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Speaker</code>.
    
    <pre>
    device Speaker extends PhysicalDevice {
     * 	action PlaySound;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Speaker</code>.
     */
    public SpeakerMock speaker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        SpeakerMock mock = new SpeakerMock(getServiceConfiguration("Speaker" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Speaker</code>.
    
    <pre>
    device Speaker extends PhysicalDevice {
     * 	action PlaySound;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Speaker</code>.
     */
    public static SpeakerMock mockSpeaker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.speaker(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Storage</code>.
    <p>
    ------------------
    Storages
    ------------------------------------
    
    <pre>
    device Storage extends PhysicalDevice {
     * 	attribute name as String;
     * 	source file as File indexed by info as FileInfo;
     * 	source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
     * 	action StoragePutAction;
     * 	action StorageDeleteAction;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>Storage</code>.
     */
    public StorageMock storage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        StorageMock mock = new StorageMock(getServiceConfiguration("Storage" + randomId()), id, location, user, name);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Storage</code>.
    <p>
    ------------------
    Storages
    ------------------------------------
    
    <pre>
    device Storage extends PhysicalDevice {
     * 	attribute name as String;
     * 	source file as File indexed by info as FileInfo;
     * 	source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
     * 	action StoragePutAction;
     * 	action StorageDeleteAction;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>Storage</code>.
     */
    public static StorageMock mockStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.storage(id, location, user, name);
    }
    
    /**
     * Returns a mock of the device <code>LocalStorage</code>.
    
    <pre>
    device LocalStorage extends Storage {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>LocalStorage</code>.
     */
    public LocalStorageMock localStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        LocalStorageMock mock = new LocalStorageMock(getServiceConfiguration("LocalStorage" + randomId()), id, location, user, name);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>LocalStorage</code>.
    
    <pre>
    device LocalStorage extends Storage {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>LocalStorage</code>.
     */
    public static LocalStorageMock mockLocalStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.localStorage(id, location, user, name);
    }
    
    /**
     * Returns a mock of the device <code>MobileStorage</code>.
    
    <pre>
    device MobileStorage extends Storage {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>MobileStorage</code>.
     */
    public MobileStorageMock mobileStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        MobileStorageMock mock = new MobileStorageMock(getServiceConfiguration("MobileStorage" + randomId()), id, location, user, name);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>MobileStorage</code>.
    
    <pre>
    device MobileStorage extends Storage {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>MobileStorage</code>.
     */
    public static MobileStorageMock mockMobileStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.mobileStorage(id, location, user, name);
    }
    
    /**
     * Returns a mock of the device <code>NetworkStorage</code>.
    
    <pre>
    device NetworkStorage extends Storage {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>NetworkStorage</code>.
     */
    public NetworkStorageMock networkStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        NetworkStorageMock mock = new NetworkStorageMock(getServiceConfiguration("NetworkStorage" + randomId()), id, location, user, name);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>NetworkStorage</code>.
    
    <pre>
    device NetworkStorage extends Storage {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @param name the value of the <code>name</code> attribute
    @return a mock of the device <code>NetworkStorage</code>.
     */
    public static NetworkStorageMock mockNetworkStorage(java.lang.String id,
            java.lang.String location,
            java.lang.String user,
            java.lang.String name) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.networkStorage(id, location, user, name);
    }
    
    /**
     * Returns a mock of the device <code>TextToSpeech</code>.
    
    <pre>
    device TextToSpeech extends PhysicalDevice {
     * 	source textToAudio as File indexed by text as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TextToSpeech</code>.
     */
    public TextToSpeechMock textToSpeech(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TextToSpeechMock mock = new TextToSpeechMock(getServiceConfiguration("TextToSpeech" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TextToSpeech</code>.
    
    <pre>
    device TextToSpeech extends PhysicalDevice {
     * 	source textToAudio as File indexed by text as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TextToSpeech</code>.
     */
    public static TextToSpeechMock mockTextToSpeech(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.textToSpeech(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Tv</code>.
    <p>
    ------------------
    TV
    ------------------------------------
    
    <pre>
    device Tv extends PhysicalDevice {
     * 	action ChannelControl;
     * 	action VolumeControl;
     * 	source currentChannel as String;
     * 	source currentVolume as Float;
     * 	source mute as Boolean;
     * 	source turnedOn as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Tv</code>.
     */
    public TvMock tv(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TvMock mock = new TvMock(getServiceConfiguration("Tv" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Tv</code>.
    <p>
    ------------------
    TV
    ------------------------------------
    
    <pre>
    device Tv extends PhysicalDevice {
     * 	action ChannelControl;
     * 	action VolumeControl;
     * 	source currentChannel as String;
     * 	source currentVolume as Float;
     * 	source mute as Boolean;
     * 	source turnedOn as Boolean;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>Tv</code>.
     */
    public static TvMock mockTv(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.tv(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>SmartTv</code>.
    
    <pre>
    device SmartTv extends Tv {
     * 	action TimeControl;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>SmartTv</code>.
     */
    public SmartTvMock smartTv(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        SmartTvMock mock = new SmartTvMock(getServiceConfiguration("SmartTv" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>SmartTv</code>.
    
    <pre>
    device SmartTv extends Tv {
     * 	action TimeControl;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>SmartTv</code>.
     */
    public static SmartTvMock mockSmartTv(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.smartTv(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>TvRecorder</code>.
    
    <pre>
    device TvRecorder extends PhysicalDevice {
     * 	action TvRecording;
     * 	source recordedProgram as File indexed by name as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TvRecorder</code>.
     */
    public TvRecorderMock tvRecorder(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TvRecorderMock mock = new TvRecorderMock(getServiceConfiguration("TvRecorder" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TvRecorder</code>.
    
    <pre>
    device TvRecorder extends PhysicalDevice {
     * 	action TvRecording;
     * 	source recordedProgram as File indexed by name as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param location the value of the <code>location</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>TvRecorder</code>.
     */
    public static TvRecorderMock mockTvRecorder(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.tvRecorder(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Service</code>.
    <p>
    -------------------------
    -- SERVICES
    -------------------------
    
    <pre>
    device Service extends Device {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Service</code>.
     */
    public ServiceMock service(java.lang.String id) {
        ServiceMock mock = new ServiceMock(getServiceConfiguration("Service" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Service</code>.
    <p>
    -------------------------
    -- SERVICES
    -------------------------
    
    <pre>
    device Service extends Device {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Service</code>.
     */
    public static ServiceMock mockService(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.service(id);
    }
    
    /**
     * Returns a mock of the device <code>ActivityNotifier</code>.
    
    <pre>
    device ActivityNotifier extends Service {
     * 	source activity as DailyActivity;
     * 	action Update;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>ActivityNotifier</code>.
     */
    public ActivityNotifierMock activityNotifier(java.lang.String id) {
        ActivityNotifierMock mock = new ActivityNotifierMock(getServiceConfiguration("ActivityNotifier" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ActivityNotifier</code>.
    
    <pre>
    device ActivityNotifier extends Service {
     * 	source activity as DailyActivity;
     * 	action Update;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>ActivityNotifier</code>.
     */
    public static ActivityNotifierMock mockActivityNotifier(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.activityNotifier(id);
    }
    
    /**
     * Returns a mock of the device <code>BuiltIn</code>.
    
    <pre>
    device BuiltIn extends Service {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>BuiltIn</code>.
     */
    public BuiltInMock builtIn(java.lang.String id) {
        BuiltInMock mock = new BuiltInMock(getServiceConfiguration("BuiltIn" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>BuiltIn</code>.
    
    <pre>
    device BuiltIn extends Service {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>BuiltIn</code>.
     */
    public static BuiltInMock mockBuiltIn(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.builtIn(id);
    }
    
    /**
     * Returns a mock of the device <code>Clock</code>.
    <p>
    BUILTIN SERVICES
    
    <pre>
    device Clock extends BuiltIn {
     * 	source tickSecond as Integer;
     * 	source tickMinute as Integer;
     * 	source tickHour as Integer;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Clock</code>.
     */
    public ClockMock clock(java.lang.String id) {
        ClockMock mock = new ClockMock(getServiceConfiguration("Clock" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Clock</code>.
    <p>
    BUILTIN SERVICES
    
    <pre>
    device Clock extends BuiltIn {
     * 	source tickSecond as Integer;
     * 	source tickMinute as Integer;
     * 	source tickHour as Integer;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Clock</code>.
     */
    public static ClockMock mockClock(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.clock(id);
    }
    
    /**
     * Returns a mock of the device <code>Timer</code>.
    
    <pre>
    device Timer extends BuiltIn {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Timer</code>.
     */
    public TimerMock timer(java.lang.String id) {
        TimerMock mock = new TimerMock(getServiceConfiguration("Timer" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Timer</code>.
    
    <pre>
    device Timer extends BuiltIn {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;	
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Timer</code>.
     */
    public static TimerMock mockTimer(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.timer(id);
    }
    
    /**
     * Returns a mock of the device <code>CommunicationService</code>.
    
    <pre>
    device CommunicationService extends Service {
     * 	action SendMessage;
     * 	action AskQuestion;
     * 	source questionAnswer as String indexed by questionId as String;
     * 	source lastMessage as Message;
     * 	action SendTrustedMessage; 
     * 	action AskTrustedQuestion; 
     * 	source trustedQuestionAnswer as String indexed by questionId as String;
     * 	source lastTrustedMessage as Message;
     * 	source safeContacts as Contact[];
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>CommunicationService</code>.
     */
    public CommunicationServiceMock communicationService(java.lang.String id) {
        CommunicationServiceMock mock = new CommunicationServiceMock(getServiceConfiguration("CommunicationService" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>CommunicationService</code>.
    
    <pre>
    device CommunicationService extends Service {
     * 	action SendMessage;
     * 	action AskQuestion;
     * 	source questionAnswer as String indexed by questionId as String;
     * 	source lastMessage as Message;
     * 	action SendTrustedMessage; 
     * 	action AskTrustedQuestion; 
     * 	source trustedQuestionAnswer as String indexed by questionId as String;
     * 	source lastTrustedMessage as Message;
     * 	source safeContacts as Contact[];
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>CommunicationService</code>.
     */
    public static CommunicationServiceMock mockCommunicationService(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.communicationService(id);
    }
    
    /**
     * Returns a mock of the device <code>InstantMessenger</code>.
    
    <pre>
    device InstantMessenger extends CommunicationService {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>InstantMessenger</code>.
     */
    public InstantMessengerMock instantMessenger(java.lang.String id) {
        InstantMessengerMock mock = new InstantMessengerMock(getServiceConfiguration("InstantMessenger" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>InstantMessenger</code>.
    
    <pre>
    device InstantMessenger extends CommunicationService {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>InstantMessenger</code>.
     */
    public static InstantMessengerMock mockInstantMessenger(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.instantMessenger(id);
    }
    
    /**
     * Returns a mock of the device <code>Mailer</code>.
    
    <pre>
    device Mailer extends CommunicationService {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Mailer</code>.
     */
    public MailerMock mailer(java.lang.String id) {
        MailerMock mock = new MailerMock(getServiceConfiguration("Mailer" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Mailer</code>.
    
    <pre>
    device Mailer extends CommunicationService {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>Mailer</code>.
     */
    public static MailerMock mockMailer(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.mailer(id);
    }
    
    /**
     * Returns a mock of the device <code>SMSSender</code>.
    
    <pre>
    device SMSSender extends CommunicationService {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>SMSSender</code>.
     */
    public SMSSenderMock sMSSender(java.lang.String id) {
        SMSSenderMock mock = new SMSSenderMock(getServiceConfiguration("SMSSender" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>SMSSender</code>.
    
    <pre>
    device SMSSender extends CommunicationService {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>SMSSender</code>.
     */
    public static SMSSenderMock mockSMSSender(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.sMSSender(id);
    }
    
    /**
     * Returns a mock of the device <code>HomeService</code>.
    
    <pre>
    device HomeService extends Service {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>HomeService</code>.
     */
    public HomeServiceMock homeService(java.lang.String id) {
        HomeServiceMock mock = new HomeServiceMock(getServiceConfiguration("HomeService" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>HomeService</code>.
    
    <pre>
    device HomeService extends Service {
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>HomeService</code>.
     */
    public static HomeServiceMock mockHomeService(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.homeService(id);
    }
    
    /**
     * Returns a mock of the device <code>AddressBook</code>.
    
    <pre>
    device AddressBook extends HomeService {
     * 	attribute owner as String;
     * 	source contacts as Contact[] indexed by filter as Contact;
     * 	action AddressBookAction;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>AddressBook</code>.
     */
    public AddressBookMock addressBook(java.lang.String id,
            java.lang.String owner) {
        AddressBookMock mock = new AddressBookMock(getServiceConfiguration("AddressBook" + randomId()), id, owner);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>AddressBook</code>.
    
    <pre>
    device AddressBook extends HomeService {
     * 	attribute owner as String;
     * 	source contacts as Contact[] indexed by filter as Contact;
     * 	action AddressBookAction;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>AddressBook</code>.
     */
    public static AddressBookMock mockAddressBook(java.lang.String id,
            java.lang.String owner) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.addressBook(id, owner);
    }
    
    /**
     * Returns a mock of the device <code>Agenda</code>.
    
    <pre>
    device Agenda extends HomeService {
     * 	attribute owner as String;
     * 	source currentEvent as AgendaEvent;
     * 	source nextEvent as AgendaEvent;
     * 	source nextEvents as AgendaEvent[];
     * 	source events as AgendaEvent[] indexed by filter as AgendaEvent;
     * 	action AgendaEventAction;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>Agenda</code>.
     */
    public AgendaMock agenda(java.lang.String id,
            java.lang.String owner) {
        AgendaMock mock = new AgendaMock(getServiceConfiguration("Agenda" + randomId()), id, owner);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Agenda</code>.
    
    <pre>
    device Agenda extends HomeService {
     * 	attribute owner as String;
     * 	source currentEvent as AgendaEvent;
     * 	source nextEvent as AgendaEvent;
     * 	source nextEvents as AgendaEvent[];
     * 	source events as AgendaEvent[] indexed by filter as AgendaEvent;
     * 	action AgendaEventAction;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param owner the value of the <code>owner</code> attribute
    @return a mock of the device <code>Agenda</code>.
     */
    public static AgendaMock mockAgenda(java.lang.String id,
            java.lang.String owner) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.agenda(id, owner);
    }
    
    /**
     * Returns a mock of the device <code>TaskManager</code>.
    
    <pre>
    device TaskManager extends HomeService {
     * 	source tasks as Task[];
     * 	action AddTask;
     * 	action DeleteTask;
     * 	action UpdateTaskState;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>TaskManager</code>.
     */
    public TaskManagerMock taskManager(java.lang.String id) {
        TaskManagerMock mock = new TaskManagerMock(getServiceConfiguration("TaskManager" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TaskManager</code>.
    
    <pre>
    device TaskManager extends HomeService {
     * 	source tasks as Task[];
     * 	action AddTask;
     * 	action DeleteTask;
     * 	action UpdateTaskState;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>TaskManager</code>.
     */
    public static TaskManagerMock mockTaskManager(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.taskManager(id);
    }
    
    /**
     * Returns a mock of the device <code>TelephonyGateway</code>.
    <p>
    Telephony
    
    <pre>
    device TelephonyGateway extends HomeService {
     * 	action TelephonyGatewayConfiguration;
     * 	source redirectionNumberOut as String;
     * 	source redirectionNumberIn as String;
     * 	source currentCall as Call;
     * 	source missedCalls as MissedCall[];
     * 	source lastMissedCall as MissedCall;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>TelephonyGateway</code>.
     */
    public TelephonyGatewayMock telephonyGateway(java.lang.String id) {
        TelephonyGatewayMock mock = new TelephonyGatewayMock(getServiceConfiguration("TelephonyGateway" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TelephonyGateway</code>.
    <p>
    Telephony
    
    <pre>
    device TelephonyGateway extends HomeService {
     * 	action TelephonyGatewayConfiguration;
     * 	source redirectionNumberOut as String;
     * 	source redirectionNumberIn as String;
     * 	source currentCall as Call;
     * 	source missedCalls as MissedCall[];
     * 	source lastMissedCall as MissedCall;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>TelephonyGateway</code>.
     */
    public static TelephonyGatewayMock mockTelephonyGateway(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.telephonyGateway(id);
    }
    
    /**
     * Returns a mock of the device <code>TvGuide</code>.
    
    <pre>
    device TvGuide extends HomeService {
     * 	source availableChannels as Channel[];
     * 	source currentProgram as TvSchedule indexed by channelId as String;
     * 	source nextProgram as TvSchedule indexed by channelId as String;
     * 	source programs as TvSchedule[] indexed by filter as TvSchedule;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>TvGuide</code>.
     */
    public TvGuideMock tvGuide(java.lang.String id) {
        TvGuideMock mock = new TvGuideMock(getServiceConfiguration("TvGuide" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TvGuide</code>.
    
    <pre>
    device TvGuide extends HomeService {
     * 	source availableChannels as Channel[];
     * 	source currentProgram as TvSchedule indexed by channelId as String;
     * 	source nextProgram as TvSchedule indexed by channelId as String;
     * 	source programs as TvSchedule[] indexed by filter as TvSchedule;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>TvGuide</code>.
     */
    public static TvGuideMock mockTvGuide(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.tvGuide(id);
    }
    
    /**
     * Returns a mock of the device <code>WeatherForecaster</code>.
    
    <pre>
    device WeatherForecaster extends HomeService {
     * 	source currentWeather as Weather indexed by region as String;
     * 	source weatherForecasts as WeatherForecast[] indexed by region as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>WeatherForecaster</code>.
     */
    public WeatherForecasterMock weatherForecaster(java.lang.String id) {
        WeatherForecasterMock mock = new WeatherForecasterMock(getServiceConfiguration("WeatherForecaster" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>WeatherForecaster</code>.
    
    <pre>
    device WeatherForecaster extends HomeService {
     * 	source currentWeather as Weather indexed by region as String;
     * 	source weatherForecasts as WeatherForecast[] indexed by region as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @return a mock of the device <code>WeatherForecaster</code>.
     */
    public static WeatherForecasterMock mockWeatherForecaster(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.weatherForecaster(id);
    }
    
    /**
     * Returns a mock of the device <code>UserService</code>.
    
    <pre>
    device UserService extends Service {
     * 	attribute user as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>UserService</code>.
     */
    public UserServiceMock userService(java.lang.String id,
            java.lang.String user) {
        UserServiceMock mock = new UserServiceMock(getServiceConfiguration("UserService" + randomId()), id, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>UserService</code>.
    
    <pre>
    device UserService extends Service {
     * 	attribute user as String;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>UserService</code>.
     */
    public static UserServiceMock mockUserService(java.lang.String id,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.userService(id, user);
    }
    
    /**
     * Returns a mock of the device <code>PersonalAddressBook</code>.
    
    <pre>
    device PersonalAddressBook extends UserService {
     * 	source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PersonalAddressBook</code>.
     */
    public PersonalAddressBookMock personalAddressBook(java.lang.String id,
            java.lang.String user) {
        PersonalAddressBookMock mock = new PersonalAddressBookMock(getServiceConfiguration("PersonalAddressBook" + randomId()), id, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>PersonalAddressBook</code>.
    
    <pre>
    device PersonalAddressBook extends UserService {
     * 	source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
     * }
    </pre>
    @param id the value of the <code>id</code> attribute
    @param user the value of the <code>user</code> attribute
    @return a mock of the device <code>PersonalAddressBook</code>.
     */
    public static PersonalAddressBookMock mockPersonalAddressBook(java.lang.String id,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.personalAddressBook(id, user);
    }
    
}
