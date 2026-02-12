public class PaypalPayment implements PaymentMethod {
    private final String accountEmail;

    public PaypalPayment(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public void pay(double amount) {
        if (!accountEmail.contains("@")) {
            throw new IllegalStateException("Cuenta PayPal inválida");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Monto inválido para PayPal");
        }
        System.out.println("Procesando pago PayPal de " + amount + " para " + accountEmail);
    }
}
