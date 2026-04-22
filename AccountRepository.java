package com.example.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Account;

@Repository
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create Account
    public void save(Account acc) {
        String sql = "INSERT INTO account(name, balance) VALUES(?, ?)";
        jdbcTemplate.update(sql, acc.getName(), acc.getBalance());
    }

    // Get Account by ID
    public Account findById(int id) {
        String sql = "SELECT * FROM account WHERE id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Account acc = new Account();
            acc.setId(rs.getInt("id"));
            acc.setName(rs.getString("name"));
            acc.setBalance(rs.getDouble("balance"));
            return acc;
        }, id);
    }

    // Update Balance
    public void updateBalance(int id, double balance) {
        String sql = "UPDATE account SET balance=? WHERE id=?";
        jdbcTemplate.update(sql, balance, id);
    }
}