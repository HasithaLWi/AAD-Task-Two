package lk.ijse.TaskTwo.service;

import lk.ijse.TaskTwo.dto.BorrowBookDTO;

public interface ManageBorrowService{

    void borrowBook(BorrowBookDTO borrowBookDTO);

    void returnBook(BorrowBookDTO borrowBookDTO);

     void updateRecode(BorrowBookDTO borrowBookDTO);

}
