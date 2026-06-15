package lk.ijse.TaskTwo.repository;

import lk.ijse.TaskTwo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
