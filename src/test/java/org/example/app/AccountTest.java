package org.example.app;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newCreatedAccountNotBeActive() {

        //given
        //when
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive()).isFalse();


    }

    @Test
    void activatedAccountShouldActive() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newCreatedAccountNotDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDelivery();

        //then
        assertNull(address);
        assertThat(address).isNull();
    }

    @Test
    void defaultDeliveryAddressNotBeNull() {

        //given
        Address address = new Address("mlynowa", "14");
        Account account = new Account();
        account.setDefaultDelivery(address);

        //when
        Account defaultAddress = account;

        //then
        assertNotNull(defaultAddress);
        assertThat(defaultAddress).isNotNull();

    }

}