public class CreditCardPayment implements PaymentMethod {
    private final String cardNumber;
    private final String holder;

    public CreditCardPayment(String cardNumber, String holder) {
        this.cardNumber = cardNumber;
        this.holder = holder;
    }

    @Override
    public void pay(double amount) {
        validate(amount);
        System.out.println("Cobrando " + amount + " a la tarjeta de " + holder);
    }

    private void validate(double amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("El monto mínimo con tarjeta es 1");
        }
        if (cardNumber.length() < 8) {
            throw new IllegalStateException("Tarjeta inválida");
        }
    }
}
