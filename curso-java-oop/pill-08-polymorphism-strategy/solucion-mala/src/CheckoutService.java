public class CheckoutService {
    public String taxMode = "NONE";
    public String shippingMode = "STANDARD";
    public double taxPercent = 0.15;
    public double shippingBase = 10;

    public void setModes(String taxMode, String shippingMode) {
        this.taxMode = taxMode;
        this.shippingMode = shippingMode;
    }

    public double calculate(double base) {
        double total = base;
        if ("FLAT".equals(taxMode)) {
            total += base * taxPercent;
        } else if ("NONE".equals(taxMode)) {
            // nada
        } else if ("REGIONAL".equals(taxMode)) {
            total += base * 0.2;
        }

        if ("STANDARD".equals(shippingMode)) {
            total += shippingBase;
        } else if ("EXPRESS".equals(shippingMode)) {
            total += shippingBase * 2;
        } else if ("FREE".equals(shippingMode)) {
            // nada
        }
        return total;
    }
}
