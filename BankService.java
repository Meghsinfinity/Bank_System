package com.example.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;

@Service
public class BankService {

    @Autowired
    private AccountRepository repo;

    public Account createAccount(Account acc) {
        repo.save(acc);
        return acc;
    }

    public Account getAccount(int id) {
        return repo.findById(id);
    }

    // ⭐ MAIN TRANSACTION METHOD
    @Transactional
    public void transferMoney(int from, int to, double amount) {

        Account sender = repo.findById(from);
        Account receiver = repo.findById(to);

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance!");
        }

        // Deduct
        repo.updateBalance(from, sender.getBalance() - amount);

        // Simulate failure
        if (amount > 10000) {
            throw new RuntimeException("Transaction failed!");
        }

        // Add
        repo.updateBalance(to, receiver.getBalance() + amount);
    }
}