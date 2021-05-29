package com.a2r.mvnws.controller;

import com.a2r.mvnws.model.Bank;
import com.a2r.mvnws.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class BankController {

    private final BankService service;

    @Autowired
    public BankController(BankService service) {
        this.service = service;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKey(DuplicateKeyException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleElementNotFound(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public String index() {
        return "hello";
    }

    @PostMapping("/addbank")
    public void addBank(@RequestBody Bank bank) {
        service.addBank(bank);
    }

    @PatchMapping("/editbank")
    public void editBank(@RequestBody Bank bank){
        service.editBank(bank);
    }

    @GetMapping("/getAllBanks")
    public List<Bank> getAllBanks() {
        return service.getBanks();
    }

    @GetMapping("/{bankid}")
    public Bank getBankById(@PathVariable Long bankid) {
        return service.getBankById(bankid);
    }

    @DeleteMapping("/{bankid}")
    public void deleteBankById(@PathVariable Long bankid) {
        service.deleteBankById(bankid);
    }
}
