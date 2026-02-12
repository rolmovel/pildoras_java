public class BankAccountData {
    public String iban;
    public double balance;
    public double limit;
    public boolean frozen;
    public String[] audit = new String[100];
    public int auditIndex;

    public void deposit(double amount) {
        balance += amount;
        audit[auditIndex++] = "DEP " + amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        audit[auditIndex++] = "WIT " + amount;
    }

    public void toggleFreeze() {
        frozen = !frozen;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }
}
