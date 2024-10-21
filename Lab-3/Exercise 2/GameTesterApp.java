import java.util.Scanner;

public class GameTesterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input to choose the type of game tester
        System.out.println("Enter the name of the game tester: ");
        String name = scanner.nextLine();

        System.out.println("Choose the type of game tester, Enter number (1: Full-time, 2: Part-time): ");
        int choice = scanner.nextInt();

        GameTester gameTester;

        if (choice == 1) {
            // Create full-time game tester
            gameTester = new FullTimeGameTester(name);
        } else if (choice == 2) {
            // Create part-time game tester
            System.out.println("Enter the number of hours worked by the part-time tester: ");
            int hours = scanner.nextInt();
            gameTester = new PartTimeGameTester(name, hours);
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        // Display the tester's information
        System.out.println("Game Tester Name: " + gameTester.getName());
        System.out.println("Full-time: " + gameTester.isFullTime());
        System.out.println("Salary: $" + gameTester.determineSalary());

        scanner.close();
    }
}
