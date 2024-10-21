import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to hold 3 mortgages
        Mortgage[] mortgages = new Mortgage[3];

        System.out.print("Enter the current prime interest rate: ");
        double primeRate = scanner.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("Enter the mortgage type (1 for Business, 2 for Personal): ");
            int type = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter the mortgage number: ");
            int mortgageNumber = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter the customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter the mortgage amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the mortgage term (1 for Short, 3 for Medium, 5 for Long): ");
            int term = scanner.nextInt();

            if (type == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, primeRate, term);
            } else if (type == 2) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, primeRate, term);
            } else {
                System.out.println("Invalid mortgage type.");
                i--;  // Invalid input, repeat the current loop iteration
                continue;
            }
        }

        System.out.println("\n--- Mortgage Details ---");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println();
        }

        scanner.close();
    }
}
