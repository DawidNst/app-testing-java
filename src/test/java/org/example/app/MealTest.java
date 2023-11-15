package org.example.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.time.chrono.ThaiBuddhistEra;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
    }

    @Test
    void referencesToTheSameObject() {

        //given
        //when
        Meal meal = new Meal(15);
        Meal meal1 = meal;

        //then
        assertSame(meal, meal1);

    }

    @Test
    void referencesToDifrentObject() {

        //given
        //when
        Meal meal = new Meal(15);
        Meal meal1 = new Meal(19);

        //then
        assertNotSame(meal, meal1);

    }

    @Test
    void twoMealsEqualPriceAndName() {

        //given
        Meal meal = new Meal(15, "burger");
        Meal meal1 = new Meal(15, "burger");

        //then
        assertEquals(meal, meal1);
    }

    @Test
    void exceptionShouldBeThrowIfHigherPrice(){

        //given
        Meal meal = new Meal( 9, "Soup");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountPrice(45));
    }

    @ParameterizedTest
    @ValueSource(ints = {10 , 20, 40, 60})
    void mealPricesBeLowerThan20(int price) {

        assertThat(price, lessThan(70));
    }

    @ParameterizedTest
    @MethodSource("createMealsNameAndPrice")
    void shouldHaveCorrectNameAndprice(String name , int price){
        assertThat(name , containsString("burger" ));
        assertThat(price , greaterThanOrEqualTo(20 ));

    }

    private static Stream<Arguments> createMealsNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger" , 20),
                Arguments.of("Cheeseburger" , 25)
        );
    }

    @ParameterizedTest
    @MethodSource("creatCakeNames")
    void shouldCorrectCreatNameCake(String name){
        assertThat(name , notNullValue());
        assertThat(name, endsWith("cake"));

    }
    private static Stream<String> creatCakeNames() {
        List<String> cakeNames = Arrays.asList("Fruitcake", "Brownicake", "Blackonecake");
        return cakeNames.stream();
    }
}