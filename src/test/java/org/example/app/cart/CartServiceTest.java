package org.example.app.cart;

import org.example.app.order.Order;
import org.example.app.order.OrderStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

        Cart resultCart = cartService.processCart(cart);

        //then

        verify(cartHandler).sendToPrepare(cart);
        verify(cartHandler, times(1)).sendToPrepare(cart);


    }

    @Test
    void processCartShouldBeNotPropert() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandlerCart(cart)).willReturn(false);

        //when

        Cart resultCart = cartService.processCart(cart);

        //then

        verify(cartHandler, never()).sendToPrepare(cart);
        assertThat(resultCart.getOrders().get(0).getOrderStatus(), equalTo(OrderStatus.REJECTED));

    }

    @Test
    void processCartShouldBeNotPropertArgumentMatchers() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandlerCart(any(Cart.class))).willReturn(false);

        //when

        Cart resultCart = cartService.processCart(cart);

        //then

        verify(cartHandler, never()).sendToPrepare(any(Cart.class));
        assertThat(resultCart.getOrders().get(0).getOrderStatus(), equalTo(OrderStatus.REJECTED));

    }

    @Test
    void canHAndlerCartThrowException() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandlerCart(cart)).willThrow(IllegalStateException.class);

        //when
        //then

        assertThrows(IllegalStateException.class, () -> cartService.processCart(cart));

    }
}
