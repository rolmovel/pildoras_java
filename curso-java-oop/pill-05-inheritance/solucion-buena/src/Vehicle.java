public abstract class Vehicle {
    private final String vin;
    private final double fuelCapacity;
    private final double consumptionPer100km;

    protected Vehicle(String vin, double fuelCapacity, double consumptionPer100km) {
        this.vin = vin;
        this.fuelCapacity = fuelCapacity;
        this.consumptionPer100km = consumptionPer100km;
    }

    public void start() {
        System.out.println("Arrancando vehículo " + vin);
    }

    public void stop() {
        System.out.println("Deteniendo vehículo " + vin);
    }

    public double calculateRange() {
        return (fuelCapacity / consumptionPer100km) * 100;
    }

    public String getVin() {
        return vin;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getConsumptionPer100km() {
        return consumptionPer100km;
    }
}
