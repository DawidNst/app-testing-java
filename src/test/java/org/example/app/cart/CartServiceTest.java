package org.example.app.cart;

import org.example.app.order.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    @Test
    void processCartShouldBePropert() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);



        //when

        //then
    }
}