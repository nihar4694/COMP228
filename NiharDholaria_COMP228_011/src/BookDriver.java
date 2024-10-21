// BookDriver.java
import javax.swing.*;

public class BookDriver {
    public static void main(String[] args) {
        // Get user input for Science Book
        String sciTitle = JOptionPane.showInputDialog("Enter the title of the Science Book:");
        String sciISBN = JOptionPane.showInputDialog("Enter the ISBN of the Science Book:");
        String sciPublisher = JOptionPane.showInputDialog("Enter the publisher of the Science Book:");
        int sciYear = Integer.parseInt(JOptionPane.showInputDialog("Enter the year of the Science Book:"));
        double sciPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the original price of the Science Book:"));

        ScienceBook scienceBook = new ScienceBook(sciTitle, sciISBN, sciPublisher, sciYear);
        scienceBook.setPrice(sciPrice);  // Apply discount

        // Get user input for Children Book
        String childTitle = JOptionPane.showInputDialog("Enter the title of the Children Book:");
        String childISBN = JOptionPane.showInputDialog("Enter the ISBN of the Children Book:");
        String childPublisher = JOptionPane.showInputDialog("Enter the publisher of the Children Book:");
        int childYear = Integer.parseInt(JOptionPane.showInputDialog("Enter the year of the Children Book:"));
        double childPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the Children Book:"));

        ChildrenBook childrenBook = new ChildrenBook(childTitle, childISBN, childPublisher, childYear);
        childrenBook.setPrice(childPrice);  // Set fixed price

        // Display book details
        JOptionPane.showMessageDialog(null, "Science Book:\n" + scienceBook.toString() +
                "\nGenre: " + scienceBook.getGenre());

        JOptionPane.showMessageDialog(null, "Children Book:\n" + childrenBook.toString() +
                "\nGenre: " + childrenBook.getGenre());
    }
}
