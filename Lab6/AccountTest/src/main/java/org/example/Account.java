public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0.0) {
            this.balance = initialBalance;
        }
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Current balance: " + balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient funds. Current balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}