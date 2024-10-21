import java.util.Scanner;

public class InsuranceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to hold Insurance objects
        Insurance[] insurances = new Insurance[2];

        // Loop to get user input and create objects
        for (int i = 0; i < insurances.length; i++) {
            System.out.println("Enter the type of insurance (Health or Life): ");
            String type = scanner.nextLine();

            System.out.println("Enter the monthly fee for " + type + " insurance: ");
            double fee = scanner.nextDouble();
            scanner.nextLine();

            if (type.equalsIgnoreCase("Health")) {
                insurances[i] = new Health();
            } else if (type.equalsIgnoreCase("Life")) {
                insurances[i] = new Life();
            } else {
                System.out.println("Invalid insurance type.");
                i--;
                continue;
            }

            insurances[i].setInsuranceCost(fee);
        }

        // Display information for each insurance in the array
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
            System.out.println();
        }

        scanner.close();
    }
}
