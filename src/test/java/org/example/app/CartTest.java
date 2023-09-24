package org.example.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void simulateOrder() {

        //given
        Cart cart = new Cart();

        //when
        assertTimeout(Duration.ofMillis(10), cart::simulateOrder);
    }
}