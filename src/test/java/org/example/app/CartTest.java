package org.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {


    @Test
    @DisplayName("Process test 10000 ordesrs in 10ms")
    void simulateOrder() {

        //given
        Cart cart = new Cart();

        //when
        assertTimeout(Duration.ofMillis(10), cart::simulateOrder);
    }
}