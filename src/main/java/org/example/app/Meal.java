package org.example.app;

import java.util.Objects;

public class Meal {

    private int price;
    private int quantity;
    private String name;

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public Meal() {
    }

    public int getQuantity() {
        return quantity;
    }

    public Meal(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPrice(int discount) {

        if (discount > this.price) {
            throw new IllegalArgumentException("Cannot be higher the price");
        }

        return this.price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price && Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    int sumPrice() {
        return getPrice() * getQuantity();
    }

    public String getName() {
    return this.name;
    }
}
