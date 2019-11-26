package book;

public class Book {
    String name;
    String author;
    int price;
    String type;
    Boolean isBorrowed;

    public Book(String name, String author, int price, String type) {
        this.name = getName();
        this.author = getAuthor();
        this.price = getPrice();
        this.type = getType();
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }


}
