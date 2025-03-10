package ntu.dp.torholskyi.librarymanager.repository;

import ntu.dp.torholskyi.librarymanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
