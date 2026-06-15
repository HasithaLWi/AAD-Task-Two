package lk.ijse.TaskTwo.service;

import lk.ijse.TaskTwo.dto.BookDTO;

public interface BookService {
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
}
