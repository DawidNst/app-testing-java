package org.example.app.cart;

import org.example.app.order.Order;
import org.example.app.order.OrderStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService cartService;
    @Mock
    private CartHandler cartHandler;

    @Test
    void processCartShouldBePropert() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

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

        given(cartHandler.canHandlerCart(cart)).willThrow(IllegalStateException.class);

        //when
        //then

        assertThrows(IllegalStateException.class, () -> cartService.processCart(cart));

    }

    @Test
    void processCartShouldBePropertArgumentCaptor() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        ArgumentCaptor<Cart> argumentCaptor = ArgumentCaptor.forClass(Cart.class);

        given(cartHandler.canHandlerCart(cart)).willReturn(true);

        //when

        Cart resultCart = cartService.processCart(cart);

        //then


        then(cartHandler).should().sendToPrepare(cart);
        verify(cartHandler).sendToPrepare(argumentCaptor.capture());
        verify(cartHandler).sendToPrepare(cart);
        verify(cartHandler, times(1)).sendToPrepare(cart);
    }


    @Test
    void shouldDoNothingWhenProcessCart() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);
        given(cartHandler.canHandlerCart(cart)).willReturn(true);

        doNothing().when(cartHandler).sendToPrepare(cart);
        willDoNothing().given(cartHandler).sendToPrepare(cart);
        willDoNothing().willDoNothing().willThrow(IllegalStateException.class).given(cartHandler).sendToPrepare(cart);

        //when

        Cart resultCart = cartService.processCart(cart);

        //then

        verify(cartHandler).sendToPrepare(cart);
        verify(cartHandler, times(1)).sendToPrepare(cart);
    }

    @Test
    void shouldAnswerWhenProcessCart() {

        //given

        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        doAnswer(invocationOnMock -> {
            Cart argumentCart = invocationOnMock.getArgument(0);
            argumentCart.clearCart();
            return true;
        }).when(cartHandler).canHandlerCart(cart);

        //when

        Cart resultCart = cartService.processCart(cart);

        //then

        then(cartHandler).should().sendToPrepare(cart);
        assertThat(resultCart.getOrders().size(), equalTo(0));

    }

    @Test
    void deliveryShouldBeFree() {

        //given
        Cart cart = new Cart();
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());

        CartHandler cartHandler = mock(CartHandler.class);//test nie przechodzi , nadal jest mockiem"cartHandler"
        given(cartHandler.isDeliveryFree(cart)).willCallRealMethod();//wykorzystanie metody call real method

        //when

        boolean isDeliveryFree = cartHandler.isDeliveryFree(cart);

        //then

        assertTrue(isDeliveryFree);

    }
}