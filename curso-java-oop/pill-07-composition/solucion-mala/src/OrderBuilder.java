public class OrderBuilder {
    public String[] productNames = new String[50];
    public double[] productPrices = new double[50];
    public int[] quantities = new int[50];
    public String customerName;
    public String street;
    public String city;
    public String country;
    public double discountPercent;
    public int count;

    public void addProduct(String name, double price, int quantity) {
        productNames[count] = name;
        productPrices[count] = price;
        quantities[count] = quantity;
        count++;
    }

    public void setAddress(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public void applyDiscount(double percent) {
        this.discountPercent = percent;
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += productPrices[i] * quantities[i];
        }
        return total - (total * discountPercent);
    }
}
