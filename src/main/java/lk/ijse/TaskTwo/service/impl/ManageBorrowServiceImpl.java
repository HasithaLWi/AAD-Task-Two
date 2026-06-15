package lk.ijse.TaskTwo.service.impl;

import lk.ijse.TaskTwo.dto.BorrowBookDTO;
import lk.ijse.TaskTwo.entity.Book;
import lk.ijse.TaskTwo.entity.Recode;
import lk.ijse.TaskTwo.entity.Student;
import lk.ijse.TaskTwo.enumaration.BookStatus;
import lk.ijse.TaskTwo.enumaration.StudentStatus;
import lk.ijse.TaskTwo.repository.BookRepository;
import lk.ijse.TaskTwo.repository.RecordRepository;
import lk.ijse.TaskTwo.repository.StudentRepository;
import lk.ijse.TaskTwo.service.ManageBorrowService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManageBorrowServiceImpl implements ManageBorrowService {

    private StudentRepository studentRepository;
    private RecordRepository recordRepository;
    private BookRepository bookRepository;

    public ManageBorrowServiceImpl(StudentRepository studentRepository, RecordRepository recordRepository, BookRepository bookRepository) {
        this.studentRepository = studentRepository;
        this.recordRepository = recordRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void borrowBook(BorrowBookDTO borrowBookDTO) {

        Optional<Student> optionalStudent = studentRepository.findById(borrowBookDTO.getStudentId());
        if (!optionalStudent.isPresent() || optionalStudent.get().getStatus().equals(StudentStatus.INACTIVE)) {
            throw new RuntimeException("Student not found with id: " + borrowBookDTO.getStudentId());
        }
        Optional<Book> optionalBook = bookRepository.findById(borrowBookDTO.getBookId());
        if (!optionalBook.isPresent() || optionalBook.get().getStatus().equals(BookStatus.BORROWED)) {
            throw new RuntimeException("Book not found or already borrowed with id: " + borrowBookDTO.getBookId());
        }

        Book book = optionalBook.get();
        book.setStatus(BookStatus.BORROWED);
        Book savedBook = bookRepository.save(book);


        Recode recode = new Recode();
        recode.setStudent(optionalStudent.get());
        recode.setBook(savedBook);

        Recode savedRecode = recordRepository.save(recode);









    }

    @Override
    public void returnBook(BorrowBookDTO borrowBookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(borrowBookDTO.getBookId());
        if (!optionalBook.isPresent()) {
            throw new RuntimeException("Book not found or already returned with id: " + borrowBookDTO.getBookId());
        }

        Book book = optionalBook.get();
        book.setStatus(BookStatus.AVAILABLE);
        Book savedBook = bookRepository.save(book);

    }

    @Override
    public void updateRecode(BorrowBookDTO borrowBookDTO) {


    }
}
