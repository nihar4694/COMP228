public class Transaction implements Runnable {
    private final Account account;
    private final double amount;
    private final boolean isDeposit;

    public Transaction(Account account, double amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}