/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.meals;

import business.medication.Medication;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prajakta
 */
public class MealDirectory {
    private List<Meal> mealList;

    public MealDirectory() {
        this.mealList = new ArrayList<>();
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public Meal addMeal() {
        Meal meal = new Meal();
        mealList.add(meal);
        return meal;
    }

    public void deleteMeal(Meal meal) {
        mealList.remove(meal);
    }
}
