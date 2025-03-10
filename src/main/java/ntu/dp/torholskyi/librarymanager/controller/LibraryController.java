package ntu.dp.torholskyi.librarymanager.controller;

import ntu.dp.torholskyi.librarymanager.model.Book;
import ntu.dp.torholskyi.librarymanager.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibraryController {

    private final BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index"; // Повертаємо шаблон index.html
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam String title, @RequestParam String author) {
        Book book = new Book(title, author);
        bookRepository.save(book);
        return "redirect:/"; // Після додавання книги повертаємось на головну сторінку
    }
}
