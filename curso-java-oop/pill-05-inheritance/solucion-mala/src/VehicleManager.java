public class VehicleManager {
    public String[] vins = new String[50];
    public String[] types = new String[50];
    public double[] fuelCapacity = new double[50];
    public double[] consumption = new double[50];
    public int[] doors = new int[50];
    public double[] maxLoads = new double[50];
    public int count = 0;

    public void addVehicle(String vin, String type, double tank, double cons) {
        vins[count] = vin;
        types[count] = type;
        fuelCapacity[count] = tank;
        consumption[count] = cons;
        count++;
    }

    public void processFleet() {
        for (int i = 0; i < count; i++) {
            if ("car".equals(types[i])) {
                System.out.println("Carro " + vins[i] + " con " + doors[i] + " puertas");
            } else if ("truck".equals(types[i])) {
                System.out.println("Camión " + vins[i] + " carga: " + maxLoads[i]);
            }
            double range = (fuelCapacity[i] / consumption[i]) * 100;
            System.out.println("Autonomía estimada: " + range);
        }
    }
}
