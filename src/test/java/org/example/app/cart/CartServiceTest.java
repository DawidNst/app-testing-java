package org.example.app.cart;

import org.example.app.order.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CartServiceTest {

    @Test
    void processCartShouldBePropert() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandlerCart(cart)).willReturn(true);

        //when

        Cart  resultCart = cartService.processCart(cart);

        //then

        verify(cartHandler).sendToPrepare(cart);

    }
}