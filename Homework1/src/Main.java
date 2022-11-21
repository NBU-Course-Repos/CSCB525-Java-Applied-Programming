import java.lang.System;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        BookStore bookStore = new BookStore("Slaveikov", 143);
        bookStore.addBook(new Book("The Witcher", BigDecimal.valueOf(20),BookType.NOVEL));
        bookStore.addBook(new Book("C++ Primer", BigDecimal.valueOf(40),BookType.NOVEL));
        bookStore.addBook(new Book("The Shining", BigDecimal.valueOf(19.99),BookType.NOVEL));
        System.out.println(bookStore.getMostExpensiveBook()); //
    }
}
