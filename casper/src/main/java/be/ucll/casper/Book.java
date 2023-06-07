package be.ucll.casper;

public class Book {
    private String title;
    private double price;
    private int numberInStock;
    private boolean inColor;

    public Book() {

    }

    public Book(String title, int numberInStock, double price, boolean inColor) {
        this.title = title;
        this.price = price;
        this.numberInStock = numberInStock;
        this.inColor = inColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceInDollar() {
        return price * 1.06;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public boolean isInColor() {
        return inColor;
    }

    public void setInColor(Boolean inColor) {
        this.inColor = inColor;
    }

    public String toString() {
        if (isInColor() == true) {
            return "The Hobbit costs €" + price + ". There are " + numberInStock
                    + " items present. The book is in color.";
        }
        return "The Hobbit costs €" + price + ". There are " + numberInStock
                + " items present. The book is not in color.";

    }

}
