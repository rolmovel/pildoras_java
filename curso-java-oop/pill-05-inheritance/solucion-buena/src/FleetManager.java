import java.util.ArrayList;
import java.util.List;

public class FleetManager {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void register(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void printStatus() {
        vehicles.forEach(vehicle -> {
            vehicle.start();
            System.out.println("Autonomía: " + vehicle.calculateRange());
            vehicle.stop();
        });
    }
}
