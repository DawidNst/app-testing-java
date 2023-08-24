package org.example.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newCreatedAccountNotBeActive(){

        //given
        //when
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
    }

    @Test
    void activatedAccountShouldActive() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
    }

    @Test
    void newCreatedAccountNotDeliveryAddressSet(){

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDelivery();

        //then
        assertNull(address);
    }


}