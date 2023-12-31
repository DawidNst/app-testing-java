package org.example.app.cart;

import org.example.app.meal.Meal;
import org.example.app.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    void clearCart() {
        this.orders.clear();
    }

    public List<Order> getOrders() {
        return orders;
    }

    void simulateOrder() {
        for (int i = 0; i < 10000; i++) {
            Meal meal = new Meal(i % 39, "Burger" + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
        System.out.println("Cart size" + orders.size());
        clearCart();

    }
}
