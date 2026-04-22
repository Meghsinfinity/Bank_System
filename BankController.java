package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bank.model.Account;
import com.example.bank.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService service;

    @PostMapping("/create")
    public Account create(@RequestBody Account acc) {
        return service.createAccount(acc);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable int id) {
        return service.getAccount(id);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam int from,
                           @RequestParam int to,
                           @RequestParam double amount) {
        try {
            service.transferMoney(from, to, amount);
            return "Transfer Successful";
        } catch (Exception e) {
            return "Transaction failed!";
        }
    }
}