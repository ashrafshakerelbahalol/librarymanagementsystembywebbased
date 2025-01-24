package com.global.librarymanagementsystem.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;



public class Transaction {
    @Id
    @Column("transaction_id")
    private Integer transactionId;
    @Column("book_id")
    private Integer bookId;
    @Column("user_id")
    private Integer userId;
    @Column("issue_date")
    private Date issueDate;
    @Column("return_date")
    private Date returnDate;
    @Column("fine_amount")
    private Double fineAmount;
    public Integer getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Double getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }
    public Transaction() {
    }
    public Transaction(int transactionId, int bookId, int userId, Date issueDate, Date returnDate,
            double fineAmount) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

   

}
