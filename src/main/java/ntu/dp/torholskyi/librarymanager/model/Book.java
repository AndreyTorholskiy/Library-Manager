package ntu.dp.torholskyi.librarymanager.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String author;

    private String genre;

    @Column(name = "available", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean available = true;
}
