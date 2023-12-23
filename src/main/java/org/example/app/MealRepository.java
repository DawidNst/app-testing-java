package org.example.app;

import java.util.ArrayList;
import java.util.List;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delet(Meal meal) {
    }
}
