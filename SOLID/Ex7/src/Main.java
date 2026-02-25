import controller.ClassroomController;
import deviceRegistry.DeviceRegistry;
import smartclassroomdevices.impl.AirConditioner;
import smartclassroomdevices.impl.AttendanceScanner;
import smartclassroomdevices.impl.LightsPanel;
import smartclassroomdevices.impl.Projector;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Classroom ===");
        DeviceRegistry reg = new DeviceRegistry();
        reg.add(new Projector());
        reg.add(new LightsPanel());
        reg.add(new AirConditioner());
        reg.add(new AttendanceScanner());

        ClassroomController c = new ClassroomController(reg);
        c.startClass();
        c.endClass();
    }
}
