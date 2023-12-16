package org.example.app.cart;

public interface CartHandler {

    boolean canHandlerCart(Cart cart);

    void sendToPrepare(Cart cart);

    default boolean isDeliveryFree(Cart cart){
        return cart.getOrders().size()>2;
    }

}
