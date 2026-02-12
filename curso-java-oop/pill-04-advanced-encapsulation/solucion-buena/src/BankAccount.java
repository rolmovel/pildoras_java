public class BankAccount {
    private final String iban;
    private final double dailyLimit;
    private final AuditTrail auditTrail;
    private double balance;
    private boolean frozen;
    private double withdrawnToday;

    public BankAccount(String iban, double dailyLimit, AuditTrail auditTrail) {
        if (dailyLimit <= 0) {
            throw new IllegalArgumentException("Daily limit must be positive");
        }
        this.iban = iban;
        this.dailyLimit = dailyLimit;
        this.auditTrail = auditTrail;
        this.balance = 0;
        this.frozen = false;
        this.withdrawnToday = 0;
        auditTrail.record("Cuenta creada: " + iban);
    }

    public void deposit(double amount) {
        ensureActive();
        ensurePositive(amount);
        balance += amount;
        auditTrail.record("Depósito de " + amount + " en " + iban);
    }

    public void withdraw(double amount) {
        ensureActive();
        ensurePositive(amount);
        if (amount > balance) {
            throw new IllegalStateException("Fondos insuficientes");
        }
        if (withdrawnToday + amount > dailyLimit) {
            throw new IllegalStateException("Límite diario excedido");
        }
        balance -= amount;
        withdrawnToday += amount;
        auditTrail.record("Retiro de " + amount + " en " + iban);
    }

    public void freeze() {
        frozen = true;
        auditTrail.record("Cuenta congelada: " + iban);
    }

    public void unfreeze() {
        frozen = false;
        auditTrail.record("Cuenta desbloqueada: " + iban);
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    private void ensureActive() {
        if (frozen) {
            throw new IllegalStateException("Cuenta congelada");
        }
    }

    private void ensurePositive(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
    }
}
