package com.bank;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public boolean transfer(long sourceId, long destId, double amount) {
        if (amount <= 0) {
            return false;
        }
        double sourceBalance = repository.getBalance(sourceId);
        if (sourceBalance < amount) {
            return false;
        }
        double destBalance = repository.getBalance(destId);
        
        repository.updateBalance(sourceId, sourceBalance - amount);
        repository.updateBalance(destId, destBalance + amount);
        return true;
    }
}