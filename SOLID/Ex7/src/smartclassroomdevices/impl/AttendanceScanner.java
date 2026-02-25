package smartclassroomdevices.impl;

import smartclassroomdevices.behaviours.AttendanceScannable;
import smartclassroomdevices.behaviours.Powerable;
import smartclassroomdevices.SmartClassroomDevice;

public class AttendanceScanner implements Powerable, AttendanceScannable, SmartClassroomDevice {
    @Override
    public void powerOn() { /* ok */ }

    @Override
    public void powerOff() { /* no output */ }

    @Override
    public int scanAttendance() {
        return 3;
    }


    @Override
    public String getClassSimpleName() {
        return AttendanceScanner.class.getSimpleName();
    }
}
