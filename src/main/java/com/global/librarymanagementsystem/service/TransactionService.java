package com.global.librarymanagementsystem.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.global.librarymanagementsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.librarymanagementsystem.entity.Transaction;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findallTransactions() {
        return transactionRepository.findAll();
    }

    public int addTransaction(Transaction transaction) {
        Transaction currentTransaction = new Transaction();
        currentTransaction.setBookId(transaction.getBookId());
        currentTransaction.setUserId(transaction.getUserId());
        LocalDate localDate = LocalDate.now();
        Date sqlDate = Date.valueOf(localDate);
        currentTransaction.setIssueDate(sqlDate);
        return transactionRepository.addTransaction(currentTransaction);
    }
   @Transactional
    public int addReturnDateAndFine(Transaction transaction) {
        Transaction currentTransaction = transactionRepository.findById(transaction.getTransactionId());
        currentTransaction.setBookId(transaction.getBookId());
        currentTransaction.setUserId(transaction.getUserId());
        LocalDate localDate = LocalDate.now();
        Date sqlDate = Date.valueOf(localDate);
        currentTransaction.setReturnDate(sqlDate);
        currentTransaction.setIssueDate(transaction.getIssueDate());
        long diffInMillies = Math.abs(transaction.getIssueDate().getTime() - transaction.getReturnDate().getTime());
        long daysDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (daysDiff > 15)
            currentTransaction.setFineAmount(daysDiff * 5.0);
        else
            currentTransaction.setFineAmount(0.0);

        return transactionRepository.updateTransaction(currentTransaction);
    }

    public Transaction findaById(int id) {
       return transactionRepository.findById(id);
    }

}
