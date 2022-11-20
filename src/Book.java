import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;

enum BookType {NOVEL, COLLECTION_OF_POEMS,SHORT_STORIES}

public class Book implements Comparable<Book> {
    private String name;
    private BigDecimal price;
    BookType bookType;

    Book(String name, BigDecimal price, BookType bookType){
        this.name = name;
        this.price = price;
        this.bookType = bookType;
    }

    public static Comparator<Book> byPriceAscending = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.price.compareTo(o2.price);
        }
    };

    public static Comparator<Book> byPriceDescending = new Comparator<Book>() {
        @Override
        public int compare(Book o2, Book o1) {
            return o1.price.compareTo(o2.price);
        }
    };

    public static Comparator<Book> byTypeDescending = new Comparator<Book>() {
        @Override
        public int compare(Book o2, Book o1) {
            return o1.bookType.compareTo(o2.bookType);
        }
    };

    public static Comparator<Book> byNameDescending = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o2.name.compareTo(o1.name);
        }
    };


    Book(){} //Default Constructor

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", bookType=" + bookType +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        return this.name.compareTo(book.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
