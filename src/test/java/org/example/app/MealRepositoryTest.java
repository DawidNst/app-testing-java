package org.example.app;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MealRepositoryTest {

    @Test
    void shouldBeAbelToAddMealToRepository() {

        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0),is(meal));
    }
}
