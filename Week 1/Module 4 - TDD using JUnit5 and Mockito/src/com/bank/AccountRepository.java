package com.bank;

public interface AccountRepository {
    double getBalance(long accountId);
    boolean updateBalance(long accountId, double newBalance);
}