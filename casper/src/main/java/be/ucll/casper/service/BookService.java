package be.ucll.casper.service;

// import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.ucll.casper.Book;

@Service
public class BookService {
    private List<Book> bookRepository = new ArrayList<>();

    public BookService() {
        Book book1 = new Book("Harry potter", 5, 20.07, true);
        Book book2 = new Book("DaVinci Code", 4, 22.56, false);
        Book book3 = new Book("De vliegeraar", 4, 18.99, false);
        Book book4 = new Book("Divergent 1", 8, 20.45, false);
        bookRepository.add(book4);
        bookRepository.add(book1);
        bookRepository.add(book3);
        bookRepository.add(book2);
    }

    public List<Book> getBooks() {
        return bookRepository;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        for (Book checkbook : bookRepository) {
            if (book.getTitle().equals(checkbook.getTitle())) {
                return false;
            }
        }
        return bookRepository.add(book);
    }

    public double getTotalValueOfCollection() {
        double result = 0;

        for (Book book : bookRepository) {
            result += book.getPrice() * book.getNumberInStock();

        }
        return result;
    }

    public Book getMostExpensiveBook() {
        Book mostExpensive = null;
        if (bookRepository.size() > 0) {
            mostExpensive = bookRepository.get(0);
            for (Book book : bookRepository) {
                if (book.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = book;
                }
            }
            return mostExpensive;
        }
        return null;
    }

    public List<Book> getBooksWithPriceMoreThen(double price) {
        List<Book> booksWithPriceMoreThen = new ArrayList<>();
        for (Book book : bookRepository) {
            if (book.getPrice() > price) {
                booksWithPriceMoreThen.add(book);
            }
        }
        return booksWithPriceMoreThen;
    }

    public Book getBookWithTitle(String title) {
        for (Book book : bookRepository) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooksInColor() {
        List<Book> BooksInColor = new ArrayList<>();
        for (Book book : bookRepository) {
            if (book.isInColor() == true) {
                BooksInColor.add(book);
            }
        }
        return BooksInColor;
    }

    public Book removeBook(Book book) {
        for (Book book_var : bookRepository) {
            if (book_var.equals(book)) {
                Book removed_book = book;
                bookRepository.remove(book);
                return removed_book;
            }
        }
        return null;
    }

    public Book removeBookWithTitle(String title) {
        for (Book book : bookRepository) {

            if (book.getTitle().equals(title)) {
                Book removed_book = book;
                bookRepository.remove(book);
                return removed_book;
            }
        }
        return null;
    }

}
