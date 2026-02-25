package smartclassroomdevices.impl;

import smartclassroomdevices.behaviours.Powerable;
import smartclassroomdevices.SmartClassroomDevice;
import smartclassroomdevices.behaviours.TemperatureControllable;

public class AirConditioner implements Powerable, TemperatureControllable, SmartClassroomDevice {
    @Override
    public void powerOn() { /* ok */ }

    @Override
    public void powerOff() {
        System.out.println("AC OFF");
    }

    @Override
    public void setTemperatureC(int c) {
        System.out.println("AC set to " + c + "C");
    }

    @Override
    public String getClassSimpleName() {
        return AirConditioner.class.getSimpleName();
    }
}
