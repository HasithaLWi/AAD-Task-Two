package lk.ijse.TaskTwo.controller;

import lk.ijse.TaskTwo.constant.CommonResponse;
import lk.ijse.TaskTwo.constant.ResponseCode;
import lk.ijse.TaskTwo.dto.BookDTO;
import lk.ijse.TaskTwo.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public CommonResponse saveBook(@RequestBody BookDTO bookDTO) {
            BookDTO savedBook = bookService.saveBook(bookDTO);
            return new CommonResponse(ResponseCode.OPERATION_SUCCESS, savedBook, "Book saved successfully");
        }

        @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "update")
        public CommonResponse updateBook(@RequestBody BookDTO bookDTO) {
            BookDTO updatedBook = bookService.updateBook(bookDTO);
            return new CommonResponse(ResponseCode.OPERATION_SUCCESS, updatedBook, "Book updated successfully");
        }

}
