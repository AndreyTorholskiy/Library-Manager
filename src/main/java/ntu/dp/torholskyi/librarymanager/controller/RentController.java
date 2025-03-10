package ntu.dp.torholskyi.librarymanager.controller;

import ntu.dp.torholskyi.librarymanager.model.Book;
import ntu.dp.torholskyi.librarymanager.model.Rent;
import ntu.dp.torholskyi.librarymanager.model.Reader;
import ntu.dp.torholskyi.librarymanager.repository.BookRepository;
import ntu.dp.torholskyi.librarymanager.repository.RentRepository;
import ntu.dp.torholskyi.librarymanager.repository.ReaderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    private final RentRepository rentRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    public RentController(RentRepository rentRepository, BookRepository bookRepository, ReaderRepository readerRepository) {
        this.rentRepository = rentRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    @GetMapping
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    @PostMapping("/rent")
    public ResponseEntity<Rent> rentBook(@RequestParam Long bookId, @RequestParam Long readerId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Reader reader = readerRepository.findById(readerId).orElse(null);

        if (book == null || reader == null || !book.isAvailable()) {
            return ResponseEntity.badRequest().build();
        }

        book.setAvailable(false);
        bookRepository.save(book);

        Rent rent = new Rent();
        rent.setBook(book);
        rent.setReader(reader);
        rent.setRentDate(LocalDate.now());
        return ResponseEntity.ok(rentRepository.save(rent));
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<Rent> returnBook(@PathVariable Long id) {
        return rentRepository.findById(id).map(rent -> {
            rent.setReturnDate(LocalDate.now());
            rent.getBook().setAvailable(true);
            bookRepository.save(rent.getBook());
            return ResponseEntity.ok(rentRepository.save(rent));
        }).orElse(ResponseEntity.notFound().build());
    }
}
