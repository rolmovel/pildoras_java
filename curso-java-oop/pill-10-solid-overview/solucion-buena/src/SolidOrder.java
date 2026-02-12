public class SolidOrder {
    private final double amount;
    private final String customerEmail;

    public SolidOrder(double amount, String customerEmail) {
        this.amount = amount;
        this.customerEmail = customerEmail;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
