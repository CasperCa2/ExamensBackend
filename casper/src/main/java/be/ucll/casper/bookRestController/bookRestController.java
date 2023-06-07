package be.ucll.casper.bookRestController;

import java.util.Collections;
import java.util.List;
import be.ucll.casper.Book;
import be.ucll.casper.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:8080/", "http://localhost:5500/", "http:/localhost:3000",
        "http://127.0.0.1:5500/" })
@RestController
@RequestMapping("/api/book")
public class bookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getbooks() {
        return bookService.getBooks();
    }

    @GetMapping("/totalValue")
    public double getTotalValueOfCollection() {
        return bookService.getTotalValueOfCollection();
    }

    @GetMapping("/mostExpensive")
    public Book getMostExpensiveBook() {
        return bookService.getMostExpensiveBook();
    }

    @GetMapping("/search/priceMoreThen")
    public List<Book> priceMoreThen(@RequestParam("price") double price) {
        return bookService.getBooksWithPriceMoreThen(price);
    }

    @GetMapping("/search/title/{title}")
    public List<Book> getBookWithTitle(@PathVariable("title") String title) {
        return Collections.singletonList(bookService.getBookWithTitle(title));
    }

    @GetMapping("/search/inColor")
    public List<Book> getBooksInColor() {
        return bookService.getBooksInColor();
    }

}
