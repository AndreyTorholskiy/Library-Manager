package ntu.dp.torholskyi.librarymanager.repository;

import ntu.dp.torholskyi.librarymanager.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByReaderId(Long readerId);
}