package lk.ijse.TaskTwo.controller;

import lk.ijse.TaskTwo.constant.CommonResponse;
import lk.ijse.TaskTwo.constant.ResponseCode;
import lk.ijse.TaskTwo.dto.BorrowBookDTO;
import lk.ijse.TaskTwo.service.BookService;
import lk.ijse.TaskTwo.service.ManageBorrowService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book-borrow")
public class BookBorrowController {
    private ManageBorrowService manageBorrowService;

    public BookBorrowController(ManageBorrowService manageBorrowService) {
        this.manageBorrowService = manageBorrowService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse borrowBook(@RequestBody BorrowBookDTO borrowBookDTO) {
        manageBorrowService.borrowBook(borrowBookDTO);
        return new CommonResponse(ResponseCode.OPERATION_SUCCESS, "Book borrowed successfully");
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "return")
    public CommonResponse returnBook(@RequestBody BorrowBookDTO borrowBookDTO) {
        manageBorrowService.returnBook(borrowBookDTO);
        return new CommonResponse(ResponseCode.OPERATION_SUCCESS, "Book returned successfully");
    }
}
