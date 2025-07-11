package org.example.app.meal;



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
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {

        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");
        mealRepository.add(meal);

        //when
        mealRepository.delet(meal);

        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByExactName() {

        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByName("Pizza", true);

        //then
        assertThat(results.size(), is(1));


    }

    @Test
    void shouldBeAbleToFindMealByStartingLetters(){

        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");
        Meal meal1 = new Meal(20, "Pitta");
        mealRepository.add(meal);
        mealRepository.add(meal1);

        //when
        List<Meal> results = mealRepository.findByName("Pi", false);

        //then
        assertThat(results.size(), is(2));

    }


    @Test
    void shouldBeAbleToFindMealByPrice() {
        //given
        MealRepository mealRepository = new MealRepository();
        Meal meal = new Meal(20, "Pizza");
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByPrice(20);

        //then
        assertThat(results.size(), is(1));


    }



}
