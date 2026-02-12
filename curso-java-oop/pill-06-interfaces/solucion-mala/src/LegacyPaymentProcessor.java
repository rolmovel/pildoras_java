public class LegacyPaymentProcessor {
    public String paymentType;
    public String cardNumber;
    public String cardHolder;
    public String paypalEmail;

    public void setCardData(String number, String holder) {
        this.cardNumber = number;
        this.cardHolder = holder;
    }

    public void setPaypalData(String email) {
        this.paypalEmail = email;
    }

    public void process(double amount, String type) {
        if ("CARD".equals(type)) {
            System.out.println("Cobrando con tarjeta " + cardNumber + " por " + amount);
        } else if ("PAYPAL".equals(type)) {
            System.out.println("Cobrando con PayPal " + paypalEmail + " por " + amount);
        } else {
            throw new IllegalArgumentException("Tipo no soportado");
        }
    }
}
