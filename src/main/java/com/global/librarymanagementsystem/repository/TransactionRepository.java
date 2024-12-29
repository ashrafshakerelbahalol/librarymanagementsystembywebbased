package com.global.librarymanagementsystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.global.librarymanagementsystem.entity.Transaction;
import com.global.librarymanagementsystem.mapper.TransactionMapper;
@Repository
public class TransactionRepository {
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Transaction> findAll() {
        return jdbcTemplate.query("SELECT transaction_id,book_id,user_id,issue_date,"
       +" return_date,fine_amount FROM transaction", new TransactionMapper());
    }

    public int addTransaction(Transaction transaction) {
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("book_id",transaction.getBookId());
        mapSqlParameterSource.addValue("user_id",transaction.getUserId());
        mapSqlParameterSource.addValue("issue_date",transaction.getIssueDate());

        return namedParameterJdbcTemplate.update("INSERT INTO transaction (book_id,user_id,issue_date)"
        + "VALUES (:book_id,:user_id,:issue_date)",mapSqlParameterSource);
    }

    public  Transaction findById(Integer id) {
       return namedParameterJdbcTemplate.queryForObject("SELECT id ,name, salary FROM employee where id=:id",
       new MapSqlParameterSource("id",id) ,new TransactionMapper());
    }

    public int updateTransaction(Transaction transaction) {
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("return_date",transaction.getReturnDate());
        mapSqlParameterSource.addValue("fine_amount",transaction.getFineAmount());
        mapSqlParameterSource.addValue("transaction_id",transaction.getTransactionId());
        return namedParameterJdbcTemplate.update("UPDATE  transaction set return_date=:return_date,fine_amount=:fine_amount"
        + " where transaction_id=:transaction_id; ",mapSqlParameterSource);
    }

}
