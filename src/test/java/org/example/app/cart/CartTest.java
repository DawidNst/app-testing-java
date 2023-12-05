package org.example.app.cart;

import org.example.app.order.Order;
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
        assertTimeout(Duration.ofMillis(12), cart::simulateOrder);
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
        assertThat(cart.getOrders(), allOf(//macher allOf wystarczy jedna asercja nie spłeniona aby warunek został nie wykonany, jeśli nie zostaną spełnione dwa warunki wyświtli tylko jeden błąd
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll(//asercja aby została spełniona musza zostać wykonane wszyskie warunki, korzysta z wyrażenia lamda, jeśli nie zostaną spełnione warunki pokaże błąd każdego
                ()->assertThat(cart.getOrders(), notNullValue()),
                ()->assertThat(cart.getOrders(), hasSize(1)),
                ()->assertThat(cart.getOrders(), is(not(empty()))),
                ()->assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                ()->assertThat(cart.getOrders().get(0).getMeals(), empty())
        );
    }

}