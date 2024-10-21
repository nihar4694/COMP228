// ScienceBook.java
public class ScienceBook extends Book {
    public ScienceBook(String title, String ISBN, String publisher, int year) {
        super(title, ISBN, publisher, year);
    }

    @Override
    public void setPrice(double price) {
        // Apply a 10% discount to the original price
        setBasePrice(price - (price * 0.10));
    }

    @Override
    public String getGenre() {
        return "Science";
    }
}
