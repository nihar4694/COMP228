import javax.swing.*;
import java.util.Random;

public class Test {
    String[] questions = {
            "Which of the following Java program units defines a group of related objects?",
            "What does an instance variable describe?",
            "Which of the following statements is true in relation to the life of an instance variable?",
            "Which one of the following terms is correct for a Java class that creates object  of another class, then calls the object’s methods?",
            "How many significant digits does a double precision number have?"
    };

    String[][] options = {
            {"1. Java Method", "2. Java Default Constructor", "3. Java", "4. Java Class"},
            {"1. Properties of an Object", "2. Behaviour of an object", "3. Measurement of an object", "4. Height of an object."},
            {"1. Instance variables starts its life only after a method is called on an object, and lasts till the  method completes its execution.",
                    "2. Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution.",
                    "3. Instance variables exist even before methods are called on an object and lasts only till methods are called on an object.",
                    "4. Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution"},
            {"1. Driver class", "2. Subscriber class.", "3. Abstract class", "4. Concrete class"},
            {"1. 8", "2. 15", "3. 16", "4. 5"}
    };

    int[] correctAnswers = {4, 1, 4, 1, 2};

    Random randomObject = new Random();

    int correctCount = 0;
    int incorrectCount = 0;

    public void simulateQuestion() {
        for (int i = 0; i < questions.length; i++) {
            String questionWithOptions = questions[i] + "\n" + String.join("\n", options[i]);
            String answer = inputAnswer(questionWithOptions);
            checkAnswer(i + 1, Integer.parseInt(answer));
        }
        showResults();
    }

    public void checkAnswer(int questionNumber, int userAnswer) {
        if (userAnswer == correctAnswers[questionNumber - 1]) {
            correctCount++;
            JOptionPane.showMessageDialog(null, generateMessage(true)); // Correct answer, show positive message
        } else {
            incorrectCount++;
            JOptionPane.showMessageDialog(null, generateMessage(false)
                    + "\nCorrect answer: " + correctAnswers[questionNumber - 1]);
        }
    }

    String generateMessage(boolean correct) {
        int messageType = randomObject.nextInt(4);
        String message = "";
        switch (messageType) {
            case 0:
                message = correct ? "Excellent!" : "No. Please try again.";
                break;
            case 1:
                message = correct ? "Good!" : "Wrong. Try once more.";
                break;
            case 2:
                message = correct ? "Keep up the good work!" : "Don't give up!";
                break;
            case 3:
                message = correct ? "Nice work!" : "No. Keep trying.";
                break;
        }
        return message;
    }

    public String inputAnswer(String questionWithOptions) {
        String answer = "";
        do {
            answer = JOptionPane.showInputDialog(null, questionWithOptions + "\n\nEnter your answer (1-4):");
            if (answer == null || answer.equals("") || !answer.matches("[1-4]")) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 1 and 4.");
                answer = "";
            }
        } while (answer.equals(""));
        return answer;
    }

    private void showResults() {
        int totalQuestions = correctAnswers.length;
        double percentageCorrect = ((double) correctCount / totalQuestions) * 100;

        JOptionPane.showMessageDialog(null, "Test Finished!\n"
                + "Correct Answers: " + correctCount + "\n"
                + "Incorrect Answers: " + incorrectCount + "\n"
                + "Percentage: " + String.format("%.2f", percentageCorrect) + "%");
    }

}
