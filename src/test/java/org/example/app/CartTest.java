package org.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {


    @Test
    @DisplayName("Process test 10000 ordesrs in 10ms")
    void simulateOrder() {

        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(10), cart::simulateOrder);
    }
    @Test
    void cartShouldNotBeEmptyAddingOrderToCart(){

        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf(//macher anyOf wystarczy jedna asercja aby warunek został spełniony
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));
        //then
        assertThat(cart.getOrders(), allOf(//macher allOf wystarczy jedna asercja nie spłeniona aby warunek został nie wykonany
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));
    }

}