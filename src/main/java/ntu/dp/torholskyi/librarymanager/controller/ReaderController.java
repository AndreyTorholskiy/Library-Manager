package ntu.dp.torholskyi.librarymanager.controller;

import ntu.dp.torholskyi.librarymanager.model.Reader;
import ntu.dp.torholskyi.librarymanager.repository.ReaderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {
    private final ReaderRepository readerRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable Long id) {
        return readerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable Long id, @RequestBody Reader readerDetails) {
        return readerRepository.findById(id).map(reader -> {
            reader.setName(readerDetails.getName());
            reader.setEmail(readerDetails.getEmail());
            return ResponseEntity.ok(readerRepository.save(reader));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReader(@PathVariable Long id) {
        return readerRepository.findById(id).map(reader -> {
            readerRepository.delete(reader);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
