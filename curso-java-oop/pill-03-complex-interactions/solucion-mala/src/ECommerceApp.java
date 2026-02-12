import java.util.Arrays;

public class ECommerceApp {
    public String[] skus = new String[50];
    public String[] names = new String[50];
    public double[] prices = new double[50];
    public int[] inventory = new int[50];

    public String[][] cartSkus = new String[10][20];
    public int[][] cartQuantities = new int[10][20];
    public double globalDiscount = 0.0;
    public int productCount = 0;
    public int cartCount = 0;

    public void registerProduct(String sku, String name, double price, int stock) {
        skus[productCount] = sku;
        names[productCount] = name;
        prices[productCount] = price;
        inventory[productCount] = stock;
        productCount++;
    }

    public int createCart() {
        cartSkus[cartCount] = new String[20];
        cartQuantities[cartCount] = new int[20];
        return cartCount++;
    }

    public void addItemToCart(int cartId, String sku, int quantity) {
        for (int i = 0; i < 20; i++) {
            if (cartSkus[cartId][i] == null) {
                cartSkus[cartId][i] = sku;
                cartQuantities[cartId][i] = quantity;
                return;
            }
        }
    }

    public double checkout(int cartId) {
        double total = 0;
        for (int i = 0; i < 20; i++) {
            String sku = cartSkus[cartId][i];
            if (sku != null) {
                int productIndex = Arrays.asList(skus).indexOf(sku);
                total += prices[productIndex] * cartQuantities[cartId][i];
            }
        }
        return total - (total * globalDiscount);
    }

    public void forcePriceChange(String sku, double newPrice) {
        int index = Arrays.asList(skus).indexOf(sku);
        if (index >= 0) {
            prices[index] = newPrice;
        }
    }
}
