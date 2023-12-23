package org.example.app.meal;

import org.example.app.meal.Meal;
import org.example.app.order.Order;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;


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
    void exceptionShouldBeThrowIfHigherPrice() {

        //given
        Meal meal = new Meal(9, "Soup");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountPrice(45));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 40, 60})
    void mealPricesBeLowerThan20(int price) {

        assertThat(price, lessThan(70));
    }

    @ParameterizedTest
    @MethodSource("createMealsNameAndPrice")
    void shouldHaveCorrectNameAndprice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(20));

    }

    private static Stream<Arguments> createMealsNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 20),
                Arguments.of("Cheeseburger", 25)
        );
    }

    @ParameterizedTest
    @MethodSource("creatCakeNames")
    void shouldCorrectCreatNameCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWithIgnoringCase("cake"));

    }

    private static Stream<String> creatCakeNames() {
        List<String> cakeNames = Arrays.asList("Fruitcake", "Brownicake", "Blackonecake");
        return cakeNames.stream();

    }

    @TestFactory
    Collection<DynamicTest> calculateMealPrices() {

        Order order = new Order();
        order.addMealToOrder(new Meal(15, 5, "Burger"));
        order.addMealToOrder(new Meal(30, 2, "Pizza"));
        order.addMealToOrder(new Meal(8, 4, "Fries"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < order.getMeals().size(); i++) {
            int price = order.getMeals().get(i).getPrice();
            int quantity = order.getMeals().get(i).getQuantity();

            Executable executable = () -> {
                assertThat(calculatePrice(price, quantity), lessThan(76));
            };
            String name = "Test name" + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    @Test
    void testMealSumPrice() {

        //given
        Meal meal = mock(Meal.class);

        given(meal.getPrice()).willReturn(20);
        given(meal.getQuantity()).willReturn(50);//mock zwraca domyslną wartośc czyli 0
        given(meal.sumPrice()).willCallRealMethod();//metoda wywołana na mocku, zwraca faktyczną wartość

        //when
       int result = meal.sumPrice();

       //then
        assertThat(result, equalTo(1000));

    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void testMealSumPriceSpy() {

        //given
        Meal meal = spy(Meal.class);

        given(meal.getPrice()).willReturn(20);
        given(meal.getQuantity()).willReturn(50);//mock zwraca domyslną wartośc czyli 0

        //when
        int result = meal.sumPrice();

        //then
        then(meal).should().getPrice();
        then(meal).should().getQuantity();
        assertThat(result, equalTo(1000));

    }

    private int calculatePrice(int price, int quantity) {

        return price * quantity;
    }
}