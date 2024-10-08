import javax.swing.JOptionPane;

public class LottoGame {

    public void playGame() {
        int userNumber = getUserNumber();
        boolean userWins = false;

        for (int i = 1; i <= 5; i++) {
            Lotto lotto = new Lotto();
            int sum = lotto.getSum();

            JOptionPane.showMessageDialog(null, "Lotto roll #" + i + ": Numbers = " +
                    lotto.getNumbers()[0] + ", " +
                    lotto.getNumbers()[1] + ", " +
                    lotto.getNumbers()[2] +
                    "\nSum = " + sum);

            if (sum == userNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win! The sum matches your number.");
                userWins = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No match! Try again.");
            }
        }

        if (!userWins) {
            JOptionPane.showMessageDialog(null, "Sorry, the computer wins. Better luck next time!");
        }
    }

    int getUserNumber() {
        int userNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(null, "Enter a number between 3 and 27:");
                userNumber = Integer.parseInt(input);
                if (userNumber >= 3 && userNumber <= 27) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number between 3 and 27.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
            }
        }

        return userNumber;
    }
}
