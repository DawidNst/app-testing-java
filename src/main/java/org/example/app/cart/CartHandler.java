package org.example.app.cart;

public interface CartHandler {

    boolean canHandlerCart( Cart cart);
    void sendToPrepare(Cart cart);

}
