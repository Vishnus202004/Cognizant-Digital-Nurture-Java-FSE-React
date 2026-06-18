package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    private AccountRepository repository;
    private AccountService service;

    @BeforeEach
    public void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    public void testTransferSuccessWithStubbing() {
        when(repository.getBalance(1L)).thenReturn(500.0);
        when(repository.getBalance(2L)).thenReturn(200.0);
        when(repository.updateBalance(anyLong(), anyDouble())).thenReturn(true);

        boolean result = service.transfer(1L, 2L, 150.0);

        assertTrue(result);
    }

    @Test
    public void testTransferVerifiesInteractions() {
        when(repository.getBalance(1L)).thenReturn(300.0);
        when(repository.getBalance(2L)).thenReturn(100.0);

        service.transfer(1L, 2L, 100.0);

        verify(repository).getBalance(1L);
        verify(repository).getBalance(2L);
        verify(repository).updateBalance(1L, 200.0);
        verify(repository).updateBalance(2L, 200.0);
    }
}