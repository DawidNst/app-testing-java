package org.example.app.order;

import org.example.app.meal.Meal;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class OrderTest {

    private Order order;
    @BeforeEach
    void initializerOrder (){
        System.out.println("Inside method @BeforeEach");
        order = new Order();
    }

    @AfterEach
    void clenIUp(){
        System.out.println("Inside method @AfterEach");
        order.cancel();
    }
    @Test
    void testAssertArrayEquals() {

        //given
        int[] ints = {0, 1, 2, 3};
        int[] ints1 = {0, 1, 2, 3};

        //then
        assertArrayEquals(ints, ints1);
    }

    @Test
    void mealListNotByEmptyAfterCreationOrder() {


        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        MatcherAssert.assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderSize() {

        //given
        Meal meal = new Meal(25, "Pizza");
        Meal meal2 = new Meal(10, "Sandwich");

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));
        assertThat(order.getMeals().get(0).getPrice(), equalTo(25));
    }

    @Test
    void removingMealFromOrder() {

        //given
        Meal meal = new Meal(15, "Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));//sprawdza czy w podanej kolekcji nie występuje podany element
    }

    @Test
    void mealsShouldBeCorrectOrderAfterAddingOrder() {

        //given
        Meal meal = new Meal(15, "Burger");
        Meal meal1 = new Meal(9, "Pizza");

        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal1);

        //then
        assertThat(order.getMeals().get(0),is(meal));
        assertThat(order.getMeals().get(1),is(meal1));//metoda przyjmuje różne kolejność kolekcji

    }

    @Test
    void testIfTwoMealList(){

        //given
        Meal meal = new Meal(15, "Burger");
        Meal meal1 = new Meal(9, "Pizza");
        Meal meal2 = new Meal(26, "TripleBurger");

        //when
        List<Meal> meals = asList(meal,meal1);
        List<Meal> meals1 = asList(meal,meal1);

        //
        assertThat(meals, is(meals1));//metoda porównuje czy kolekcje są sobie równe
    }
}
