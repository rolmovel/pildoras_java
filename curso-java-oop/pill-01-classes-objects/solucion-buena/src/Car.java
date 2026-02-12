public class Car {
    private final String brand;
    private int speed;

    public Car(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    public void accelerate(int amount) {
        if (amount > 0) speed += amount;
    }

    public void brake(int amount) {
        if (amount > 0) speed = Math.max(0, speed - amount);
    }

    public String getBrand() { return brand; }
    public int getSpeed() { return speed; }
}
