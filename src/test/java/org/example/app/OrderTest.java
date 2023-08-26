package org.example.app;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class OrderTest {

    @Test
    void testAssertArrayEquals(){

        //given
        int[] ints = {0,1,2,3};
        int[] ints1 = {0,1,2,3};

        //then
        assertArrayEquals(ints, ints1);
    }

    @Test
    void mealListNotByEmptyAfterCreationOrder(){

        //given
        Order order = new Order();

        //then
        assertThat(order.getMeals().isEmpty());

    }

    @Test
    void addingMealToOrderSize(){

        //given
        Meal meal = new Meal(25,"Pizza");
        Order order = new Order();

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals().size());


    }
}
