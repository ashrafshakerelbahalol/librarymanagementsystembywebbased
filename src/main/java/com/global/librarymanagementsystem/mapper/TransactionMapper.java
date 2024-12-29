package com.global.librarymanagementsystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.global.librarymanagementsystem.entity.Transaction;

public class TransactionMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet rs, int rownum) throws SQLException {
        return new Transaction (rs.getInt("transaction_id")
        ,rs.getInt("book_id"),
        rs.getInt("user_id")
        ,rs.getDate("issue_date")
        ,rs.getDate("return_date"),
        rs.getDouble("fine_amount"));
    }

}
