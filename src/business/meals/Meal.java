/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.meals;

import java.util.Date;

/**
 *
 * @author Prajakta
 */
public class Meal {
    private String mealtype;
    private Date mealTime;
    private double calorieIntake;

    public String getMealtype() {
        return mealtype;
    }

    public void setMealtype(String mealtype) {
        this.mealtype = mealtype;
    }

    public Date getMealTime() {
        return mealTime;
    }

    public void setMealTime(Date mealTime) {
        this.mealTime = mealTime;
    }

    public double getCalorieIntake() {
        return calorieIntake;
    }

    public void setCalorieIntake(double calorieIntake) {
        this.calorieIntake = calorieIntake;
    }

    @Override
    public String toString() {
        return mealtype;
    }
    

}
