package org.example.app.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    MealRepository mealRepository;
    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delet(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> findByName(String mealName, boolean exactMatch) {

        if (exactMatch) {

            return meals.stream()
                    .filter(meal -> meal.getName().equals(mealName))
                    .collect(Collectors.toList());

        } else {
            return meals.stream()
                    .filter(meal -> meal.getName().startsWith(mealName))
                    .collect(Collectors.toList());
        }
    }
        public List<Meal> findByPrice ( int price){
            return meals.stream()
                    .filter(meal -> meal.getPrice() == price)
                    .collect(Collectors.toList());
        }
    }

