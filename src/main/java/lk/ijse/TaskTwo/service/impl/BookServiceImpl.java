package lk.ijse.TaskTwo.service.impl;

import lk.ijse.TaskTwo.dto.BookDTO;
import lk.ijse.TaskTwo.entity.Book;
import lk.ijse.TaskTwo.enumaration.BookStatus;
import lk.ijse.TaskTwo.repository.BookRepository;
import lk.ijse.TaskTwo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setStatus(BookStatus.AVAILABLE);

        Book savedBook = bookRepository.save(book);

        BookDTO savedBookDTO = new BookDTO();
        savedBookDTO.setId(savedBook.getId());
        savedBookDTO.setName(savedBook.getName());
        savedBookDTO.setAuthor(savedBook.getAuthor());
        savedBookDTO.setStatus(savedBook.getStatus());
        return savedBookDTO;
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(bookDTO.getId());
        if (!optionalBook.isPresent()) {
            throw new RuntimeException("Book not found with id: " + bookDTO.getId());
        }

        Book book = optionalBook.get();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setStatus(bookDTO.getStatus());

        Book updatedBook = bookRepository.save(book);

        BookDTO updatedBookDTO = new BookDTO();
        updatedBookDTO.setId(updatedBook.getId());
        updatedBookDTO.setName(updatedBook.getName());
        updatedBookDTO.setAuthor(updatedBook.getAuthor());
        updatedBookDTO.setStatus(updatedBook.getStatus());

        return updatedBookDTO;
    }
}
