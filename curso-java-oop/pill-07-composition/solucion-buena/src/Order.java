import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Customer customer;
    private Address shippingAddress;
    private final List<OrderItem> items = new ArrayList<>();
    private final List<Charge> extraCharges = new ArrayList<>();

    public Order(Customer customer, Address shippingAddress) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public void addCharge(Charge charge) {
        extraCharges.add(charge);
    }

    public void updateAddress(Address newAddress) {
        this.shippingAddress = newAddress;
    }

    public double total() {
        double subtotal = items.stream()
                               .mapToDouble(OrderItem::subtotal)
                               .sum();
        for (Charge charge : extraCharges) {
            subtotal = charge.apply(subtotal);
        }
        return subtotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }
}
