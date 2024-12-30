package com.global.librarymanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.global.librarymanagementsystem.entity.Transaction;
import com.global.librarymanagementsystem.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/findalltransaction")
    public List<Transaction> findallTransactions() {
        return transactionService.findallTransactions();
    }
    @GetMapping("/findbyid/{id}")
    public Transaction findById(@PathVariable int id) {
        return transactionService.findaById(id);
    }
    @PostMapping("/addtransaction")
    public int addTransaction (@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction) ;
    }

    @PutMapping("/addreturndateandfine/{id}")
    public int addReturnDateAndFine(@PathVariable int id) {
        return transactionService.addReturnDateAndFine(id) ;
    }
    

    
    

}
