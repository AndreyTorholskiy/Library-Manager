package ntu.dp.torholskyi.librarymanager.repository;

import ntu.dp.torholskyi.librarymanager.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
