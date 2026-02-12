public class Truck extends Vehicle {
    private final double maxLoad;

    public Truck(String vin, double fuelCapacity, double consumptionPer100km, double maxLoad) {
        super(vin, fuelCapacity, consumptionPer100km);
        this.maxLoad = maxLoad;
    }

    public double calculateToll() {
        return maxLoad * 0.02;
    }

    public double getMaxLoad() {
        return maxLoad;
    }
}
