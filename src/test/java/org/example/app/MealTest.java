package org.example.app;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountPrice() {

        //given
        Meal meal = new Meal(96);

        //when
        int discountedPrice = meal.getDiscountPrice(26);

        //then
        assertEquals(70, discountedPrice);//wartość oczekiwana, wartość faktyczna
        assertThat(discountedPrice).isEqualTo(70);
    }

    @Test
    void referencesToTheSameObject() {

        //given
        //when
        Meal meal = new Meal(15);
        Meal meal1 = meal;

        //then
        assertSame(meal, meal1);
        assertThat(meal).isSameAs(meal1);

    }

    @Test
    void referencesToDifrentObject() {

        //given
        //when
        Meal meal = new Meal(15);
        Meal meal1 = new Meal(19);

        //then
        assertNotSame(meal, meal1);
        assertThat(meal).isNotSameAs(meal1);

    }

    @Test
    void twoMealsEqualPriceAndName() {

        //given
        Meal meal = new Meal(15, "burger");
        Meal meal1 = new Meal(15, "burger");

        //then
        assertEquals(meal, meal1);
        assertThat(meal).isEqualTo(meal1);
    }

}