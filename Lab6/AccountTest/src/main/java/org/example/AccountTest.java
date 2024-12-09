import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.00);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, 200, true)); // Deposit
        transactions.add(new Transaction(account, 1600, false)); // Withdraw
        transactions.add(new Transaction(account, 500, true)); // Deposit
        transactions.add(new Transaction(account, 300, false)); // Withdraw
        transactions.add(new Transaction(account, 50, true)); // Deposit

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}