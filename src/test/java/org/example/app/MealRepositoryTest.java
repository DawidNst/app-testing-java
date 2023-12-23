package org.example.app;

import org.junit.jupiter.api.Test;

public class MealRepositoryTest {

    @Test
    void shouldBeAbelToAddMealToRepository() {

        //given

        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20,"Pizza");

        //when

        mealRepository.add(meal);
    }
}
