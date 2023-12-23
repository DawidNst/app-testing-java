package org.example.app;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MealRepositoryTest {

    @Test
    void shouldBeAbleToAddMealToRepository() {

        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0),is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository(){

        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");
        mealRepository.add(meal);

        //when
        mealRepository.delet(meal);

        //then
        assertThat(mealRepository.getAllMeals(),not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByName() {

        //given
        Meal meal = new Meal(20 , "pizza");
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByName("Pizza");
    }


}
