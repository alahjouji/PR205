package fr.inria.phoenix.diasuite.framework.misc;

import java.util.HashMap;
import java.util.Map;

import fr.inria.diagen.core.service.local.Service;

/**
 * A container for the list of available devices. For internal use by introspection libraries
 * 
 * @internal
 */
public class ClassList implements fr.inria.diagen.core.deploy.DeviceLister {

    public final Map<String, Class<? extends Service>> deviceList = new HashMap<String, Class<? extends Service>>();

    public ClassList() {
        deviceList.put("/Device/Device/", fr.inria.phoenix.diasuite.framework.device.device.AbstractDevice.class);
        deviceList.put("/Device/Device/BordeauxMetropole/", fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole.AbstractBordeauxMetropole.class);
        deviceList.put("/Device/Device/GpsWs/", fr.inria.phoenix.diasuite.framework.device.gpsws.AbstractGpsWs.class);
        deviceList.put("/Device/Device/IHM/", fr.inria.phoenix.diasuite.framework.device.ihm.AbstractIHM.class);
        deviceList.put("/Device/Device/IHM/ApplianceDashBoard/", fr.inria.phoenix.diasuite.framework.device.appliancedashboard.AbstractApplianceDashBoard.class);
        deviceList.put("/Device/Device/NavitiaWS/", fr.inria.phoenix.diasuite.framework.device.navitiaws.AbstractNavitiaWS.class);
        deviceList.put("/Device/Device/PhotoLibrary/", fr.inria.phoenix.diasuite.framework.device.photolibrary.AbstractPhotoLibrary.class);
        deviceList.put("/Device/Device/PhotoLibrary/SocialNetworkPhotoLibrary/", fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.AbstractSocialNetworkPhotoLibrary.class);
        deviceList.put("/Device/Device/PhysicalDevice/", fr.inria.phoenix.diasuite.framework.device.physicaldevice.AbstractPhysicalDevice.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/", fr.inria.phoenix.diasuite.framework.device.appliance.AbstractAppliance.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Alarm/", fr.inria.phoenix.diasuite.framework.device.alarm.AbstractAlarm.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Alarm/ModAlarm/", fr.inria.phoenix.diasuite.framework.device.modalarm.AbstractModAlarm.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Alarm/RepetitiveAlarm/", fr.inria.phoenix.diasuite.framework.device.repetitivealarm.AbstractRepetitiveAlarm.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Cooker/", fr.inria.phoenix.diasuite.framework.device.cooker.AbstractCooker.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Fan/", fr.inria.phoenix.diasuite.framework.device.fan.AbstractFan.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Heater/", fr.inria.phoenix.diasuite.framework.device.heater.AbstractHeater.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Light/", fr.inria.phoenix.diasuite.framework.device.light.AbstractLight.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Light/DimmableLight/", fr.inria.phoenix.diasuite.framework.device.dimmablelight.AbstractDimmableLight.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Thermostat/", fr.inria.phoenix.diasuite.framework.device.thermostat.AbstractThermostat.class);
        deviceList.put("/Device/Device/PhysicalDevice/Battery/", fr.inria.phoenix.diasuite.framework.device.battery.AbstractBattery.class);
        deviceList.put("/Device/Device/PhysicalDevice/Button/", fr.inria.phoenix.diasuite.framework.device.button.AbstractButton.class);
        deviceList.put("/Device/Device/PhysicalDevice/Camera/", fr.inria.phoenix.diasuite.framework.device.camera.AbstractCamera.class);
        deviceList.put("/Device/Device/PhysicalDevice/Camera/VideoCamera/", fr.inria.phoenix.diasuite.framework.device.videocamera.AbstractVideoCamera.class);
        deviceList.put("/Device/Device/PhysicalDevice/Camera/VideoCamera/PTZVideoCamera/", fr.inria.phoenix.diasuite.framework.device.ptzvideocamera.AbstractPTZVideoCamera.class);
        deviceList.put("/Device/Device/PhysicalDevice/DoorLocker/", fr.inria.phoenix.diasuite.framework.device.doorlocker.AbstractDoorLocker.class);
        deviceList.put("/Device/Device/PhysicalDevice/Identifier/", fr.inria.phoenix.diasuite.framework.device.identifier.AbstractIdentifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/Identifier/BluetoothIdentifier/", fr.inria.phoenix.diasuite.framework.device.bluetoothidentifier.AbstractBluetoothIdentifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/Identifier/FingerPrintIdentifier/", fr.inria.phoenix.diasuite.framework.device.fingerprintidentifier.AbstractFingerPrintIdentifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/Identifier/RfidIdentifier/", fr.inria.phoenix.diasuite.framework.device.rfididentifier.AbstractRfidIdentifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/Initiator/", fr.inria.phoenix.diasuite.framework.device.initiator.AbstractInitiator.class);
        deviceList.put("/Device/Device/PhysicalDevice/Input/", fr.inria.phoenix.diasuite.framework.device.input.AbstractInput.class);
        deviceList.put("/Device/Device/PhysicalDevice/Input/AudioInput/", fr.inria.phoenix.diasuite.framework.device.audioinput.AbstractAudioInput.class);
        deviceList.put("/Device/Device/PhysicalDevice/Input/ScreenInput/", fr.inria.phoenix.diasuite.framework.device.screeninput.AbstractScreenInput.class);
        deviceList.put("/Device/Device/PhysicalDevice/IntrusionDetector/", fr.inria.phoenix.diasuite.framework.device.intrusiondetector.AbstractIntrusionDetector.class);
        deviceList.put("/Device/Device/PhysicalDevice/KeyPad/", fr.inria.phoenix.diasuite.framework.device.keypad.AbstractKeyPad.class);
        deviceList.put("/Device/Device/PhysicalDevice/LoggerSecondTab/", fr.inria.phoenix.diasuite.framework.device.loggersecondtab.AbstractLoggerSecondTab.class);
        deviceList.put("/Device/Device/PhysicalDevice/Messenger/", fr.inria.phoenix.diasuite.framework.device.messenger.AbstractMessenger.class);
        deviceList.put("/Device/Device/PhysicalDevice/Messenger/AudioMessenger/", fr.inria.phoenix.diasuite.framework.device.audiomessenger.AbstractAudioMessenger.class);
        deviceList.put("/Device/Device/PhysicalDevice/Messenger/ScreenMessenger/", fr.inria.phoenix.diasuite.framework.device.screenmessenger.AbstractScreenMessenger.class);
        deviceList.put("/Device/Device/PhysicalDevice/Messenger/TvMessenger/", fr.inria.phoenix.diasuite.framework.device.tvmessenger.AbstractTvMessenger.class);
        deviceList.put("/Device/Device/PhysicalDevice/Microphone/", fr.inria.phoenix.diasuite.framework.device.microphone.AbstractMicrophone.class);
        deviceList.put("/Device/Device/PhysicalDevice/Notifier/", fr.inria.phoenix.diasuite.framework.device.notifier.AbstractNotifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/Notifier/AudioNotifier/", fr.inria.phoenix.diasuite.framework.device.audionotifier.AbstractAudioNotifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/Notifier/VisualNotifier/", fr.inria.phoenix.diasuite.framework.device.visualnotifier.AbstractVisualNotifier.class);
        deviceList.put("/Device/Device/PhysicalDevice/PhotoFrame/", fr.inria.phoenix.diasuite.framework.device.photoframe.AbstractPhotoFrame.class);
        deviceList.put("/Device/Device/PhysicalDevice/Prompter/", fr.inria.phoenix.diasuite.framework.device.prompter.AbstractPrompter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Prompter/AudioPrompter/", fr.inria.phoenix.diasuite.framework.device.audioprompter.AbstractAudioPrompter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Prompter/ScreenPrompter/", fr.inria.phoenix.diasuite.framework.device.screenprompter.AbstractScreenPrompter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Prompter/TvPrompter/", fr.inria.phoenix.diasuite.framework.device.tvprompter.AbstractTvPrompter.class);
        deviceList.put("/Device/Device/PhysicalDevice/RemoteControl/", fr.inria.phoenix.diasuite.framework.device.remotecontrol.AbstractRemoteControl.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/", fr.inria.phoenix.diasuite.framework.device.sensor.AbstractSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/COSensor/", fr.inria.phoenix.diasuite.framework.device.cosensor.AbstractCOSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/ContactSensor/", fr.inria.phoenix.diasuite.framework.device.contactsensor.AbstractContactSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/EnergyMeter/", fr.inria.phoenix.diasuite.framework.device.energymeter.AbstractEnergyMeter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/EnergyMeter/ElectricMeter/", fr.inria.phoenix.diasuite.framework.device.electricmeter.AbstractElectricMeter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/EnergyMeter/GasMeter/", fr.inria.phoenix.diasuite.framework.device.gasmeter.AbstractGasMeter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/EnergyMeter/WaterMeter/", fr.inria.phoenix.diasuite.framework.device.watermeter.AbstractWaterMeter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/HumiditySensor/", fr.inria.phoenix.diasuite.framework.device.humiditysensor.AbstractHumiditySensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/LightSensor/", fr.inria.phoenix.diasuite.framework.device.lightsensor.AbstractLightSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/MotionDetector/", fr.inria.phoenix.diasuite.framework.device.motiondetector.AbstractMotionDetector.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/OverflowSensor/", fr.inria.phoenix.diasuite.framework.device.overflowsensor.AbstractOverflowSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/SmokeSensor/", fr.inria.phoenix.diasuite.framework.device.smokesensor.AbstractSmokeSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/TemperatureSensor/", fr.inria.phoenix.diasuite.framework.device.temperaturesensor.AbstractTemperatureSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/ServiceTablet/", fr.inria.phoenix.diasuite.framework.device.servicetablet.AbstractServiceTablet.class);
        deviceList.put("/Device/Device/PhysicalDevice/Shutter/", fr.inria.phoenix.diasuite.framework.device.shutter.AbstractShutter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Speaker/", fr.inria.phoenix.diasuite.framework.device.speaker.AbstractSpeaker.class);
        deviceList.put("/Device/Device/PhysicalDevice/Storage/", fr.inria.phoenix.diasuite.framework.device.storage.AbstractStorage.class);
        deviceList.put("/Device/Device/PhysicalDevice/Storage/LocalStorage/", fr.inria.phoenix.diasuite.framework.device.localstorage.AbstractLocalStorage.class);
        deviceList.put("/Device/Device/PhysicalDevice/Storage/MobileStorage/", fr.inria.phoenix.diasuite.framework.device.mobilestorage.AbstractMobileStorage.class);
        deviceList.put("/Device/Device/PhysicalDevice/Storage/NetworkStorage/", fr.inria.phoenix.diasuite.framework.device.networkstorage.AbstractNetworkStorage.class);
        deviceList.put("/Device/Device/PhysicalDevice/TextToSpeech/", fr.inria.phoenix.diasuite.framework.device.texttospeech.AbstractTextToSpeech.class);
        deviceList.put("/Device/Device/PhysicalDevice/Tv/", fr.inria.phoenix.diasuite.framework.device.tv.AbstractTv.class);
        deviceList.put("/Device/Device/PhysicalDevice/Tv/SmartTv/", fr.inria.phoenix.diasuite.framework.device.smarttv.AbstractSmartTv.class);
        deviceList.put("/Device/Device/PhysicalDevice/TvRecorder/", fr.inria.phoenix.diasuite.framework.device.tvrecorder.AbstractTvRecorder.class);
        deviceList.put("/Device/Device/Service/", fr.inria.phoenix.diasuite.framework.device.service.AbstractService.class);
        deviceList.put("/Device/Device/Service/ActivityNotifier/", fr.inria.phoenix.diasuite.framework.device.activitynotifier.AbstractActivityNotifier.class);
        deviceList.put("/Device/Device/Service/BuiltIn/", fr.inria.phoenix.diasuite.framework.device.builtin.AbstractBuiltIn.class);
        deviceList.put("/Device/Device/Service/BuiltIn/Clock/", fr.inria.phoenix.diasuite.framework.device.clock.AbstractClock.class);
        deviceList.put("/Device/Device/Service/BuiltIn/Timer/", fr.inria.phoenix.diasuite.framework.device.timer.AbstractTimer.class);
        deviceList.put("/Device/Device/Service/CommunicationService/", fr.inria.phoenix.diasuite.framework.device.communicationservice.AbstractCommunicationService.class);
        deviceList.put("/Device/Device/Service/CommunicationService/InstantMessenger/", fr.inria.phoenix.diasuite.framework.device.instantmessenger.AbstractInstantMessenger.class);
        deviceList.put("/Device/Device/Service/CommunicationService/Mailer/", fr.inria.phoenix.diasuite.framework.device.mailer.AbstractMailer.class);
        deviceList.put("/Device/Device/Service/CommunicationService/SMSSender/", fr.inria.phoenix.diasuite.framework.device.smssender.AbstractSMSSender.class);
        deviceList.put("/Device/Device/Service/HomeService/", fr.inria.phoenix.diasuite.framework.device.homeservice.AbstractHomeService.class);
        deviceList.put("/Device/Device/Service/HomeService/AddressBook/", fr.inria.phoenix.diasuite.framework.device.addressbook.AbstractAddressBook.class);
        deviceList.put("/Device/Device/Service/HomeService/Agenda/", fr.inria.phoenix.diasuite.framework.device.agenda.AbstractAgenda.class);
        deviceList.put("/Device/Device/Service/HomeService/TaskManager/", fr.inria.phoenix.diasuite.framework.device.taskmanager.AbstractTaskManager.class);
        deviceList.put("/Device/Device/Service/HomeService/TelephonyGateway/", fr.inria.phoenix.diasuite.framework.device.telephonygateway.AbstractTelephonyGateway.class);
        deviceList.put("/Device/Device/Service/HomeService/TvGuide/", fr.inria.phoenix.diasuite.framework.device.tvguide.AbstractTvGuide.class);
        deviceList.put("/Device/Device/Service/HomeService/WeatherForecaster/", fr.inria.phoenix.diasuite.framework.device.weatherforecaster.AbstractWeatherForecaster.class);
        deviceList.put("/Device/Device/Service/UserService/", fr.inria.phoenix.diasuite.framework.device.userservice.AbstractUserService.class);
        deviceList.put("/Device/Device/Service/UserService/PersonalAddressBook/", fr.inria.phoenix.diasuite.framework.device.personaladdressbook.AbstractPersonalAddressBook.class);
    }

    public Map<String, Class<? extends Service>> getDeviceList() {
        return deviceList;
    }

}
