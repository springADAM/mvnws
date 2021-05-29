package com.a2r.mvnws.service;

import com.a2r.mvnws.model.Bank;
import com.a2r.mvnws.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankService {

    private final BankRepository bankRepository;
    @Autowired
    public BankService(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

    public void addBank(Bank bank) throws DuplicateKeyException{
        if(!bankRepository.existsById(bank.getNbanque())) {
            bankRepository.save(bank);
        }
        else throw new DuplicateKeyException("Element already Exists");
    }

    public Bank getBankById(Long bankid) {
        return bankRepository.findById(bankid).orElseThrow(() -> new NoSuchElementException("Element not found"));
    }

    public void deleteBankById(Long bankid) {
        bankRepository.deleteById(bankid);
    }

    public void editBank(Bank bank) {
        if(bankRepository.existsById(bank.getNbanque()))
        bankRepository.saveAndFlush(bank);
        else throw new NoSuchElementException("Element not found");
    }
}
