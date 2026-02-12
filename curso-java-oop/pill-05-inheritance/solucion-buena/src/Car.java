public class Car extends Vehicle {
    private final int doors;

    public Car(String vin, double fuelCapacity, double consumptionPer100km, int doors) {
        super(vin, fuelCapacity, consumptionPer100km);
        this.doors = doors;
    }

    @Override
    public void start() {
        System.out.println("Carro con VIN " + getVin() + " encendiendo suavemente");
    }

    public int getDoors() {
        return doors;
    }
}
