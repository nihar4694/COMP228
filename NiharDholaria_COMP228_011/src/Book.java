// Book.java
public abstract class Book {
    private String title;
    private String ISBN;
    private String publisher;
    private double price;
    private int year;

    // Constructor
    public Book(String title, String ISBN, String publisher, int year) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.year = year;
    }

    // Getters
    public String getTitle() { return title; }
    public String getISBN() { return ISBN; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setYear(int year) { this.year = year; }

    // Abstract methods
    public abstract void setPrice(double price);
    public abstract String getGenre();

    // toString method to display book information
    @Override
    public String toString() {
        return "Title: " + title + "\nISBN: " + ISBN + "\nPublisher: " + publisher +
                "\nYear: " + year + "\nPrice: $" + price;
    }

    // Setter for price (used by subclasses)
    protected void setBasePrice(double price) {
        this.price = price;
    }
}
