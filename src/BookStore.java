import java.util.*;

public class BookStore {
    private String location;
    private double areaSize;
    private ArrayList<Book> books = new ArrayList<>();

    BookStore(){} //Default Constructor
    BookStore(String location, double areaSize){
            this.location = location;
            this.areaSize = areaSize;
    }
    BookStore(String location, double areaSize, ArrayList<Book> books){
            this.location = location;
            this.areaSize = areaSize;
            this.books = books;
    }

    public boolean addBook(Book book){
        return books.add(book);
    }

    public boolean removeBook(Book book){
        return books.remove(book);
    }

    private ListIterator<Book> getIterator(){
        ListIterator<Book> it = this.books.listIterator(books.size());
        return it;
    }

    public void getBooksReverse(){
        ListIterator<Book> it = getIterator();
        while (it.hasPrevious()){
             System.out.println(it.previous().toString());
        }
    }

    public Book getMostExpensiveBook(){
        ArrayList<Book> copyOfBooks = new ArrayList<>(books);
        Collections.sort(copyOfBooks,Book.byPriceAscending);
        return copyOfBooks.get(copyOfBooks.size()-1);
    }

    public void sortByPriceAscending(){
        Collections.sort(books, Book.byPriceAscending);
    }

    public void sortByNameDescending(){
        Collections.sort(books, Book.byNameDescending);
    }

    public void sortByNameAndPrice(){
        Collections.sort(books, Book.byTypeDescending.thenComparing(Book.byPriceDescending));
    }

    public Book returnLastBookByName(){
        ArrayList<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, Book.byNameDescending);
        return copy.get(copy.size()-1);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(double areaSize) {
        this.areaSize = areaSize;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
