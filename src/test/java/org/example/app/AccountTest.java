package org.example.app;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newCreatedAccountNotBeActive() {

        //given
        //when
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive(),equalTo(false));
        assertThat(newAccount.isActive(),is(false));

    }

    @Test
    void activatedAccountShouldActive() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(),is(true));
    }

    @Test
    void newCreatedAccountNotDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDelivery();

        //then
        assertNull(address);
        assertThat(address, nullValue());
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
        assertThat(defaultAddress, is(notNullValue()));

    }

}