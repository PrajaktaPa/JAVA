/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.exercise;

import business.person.Person;
import calculations.Calculate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prajakta
 */
public class ExerciseRegimeHistory {
    private List<ExerciseRegime> exerciseList;
    private Calculate calculate;
    private Person person;

    public ExerciseRegimeHistory() {
        this.exerciseList = new ArrayList<>();
    }

    public List<ExerciseRegime> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<ExerciseRegime> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public ExerciseRegime addExerciseRegime() {
        ExerciseRegime exercise = new ExerciseRegime();
        exerciseList.add(exercise);
        return exercise;
    }

    public void deleteExerciseRegime(ExerciseRegime exercise) {
        exerciseList.remove(exercise);
    }
    
    //int age = calculate.findAge(person);
    
    public double caloriesBurnt(int age, double weight,int heartRateWalking, int heartRateWorkout, float hoursWorkout,String gender,float hoursWalked){
        double totalCaloriesBurnt,caloriesBurntInWorkout,caloriesBurntInWalking;
        if(gender.equals("Male")){
            caloriesBurntInWorkout = (((age * 0.2017) - (weight * 0.09036) + (heartRateWorkout * 0.6309) - 55.0969) * hoursWorkout) /4.184;
            caloriesBurntInWalking = (((age * 0.2017) - (weight * 0.09036) + (heartRateWalking * 0.6309) - 55.0969) * hoursWalked) /4.184;
            totalCaloriesBurnt = caloriesBurntInWorkout+caloriesBurntInWalking;
        }
        else{
            caloriesBurntInWorkout = (((age * 0.074) - (weight * 0.05741) + (heartRateWorkout * 0.4472) - 20.4022) * hoursWorkout) /4.184;
            caloriesBurntInWalking = (((age * 0.2017) - (weight * 0.09036) + (heartRateWalking * 0.6309) - 55.0969) * hoursWalked) /4.184;
            totalCaloriesBurnt = caloriesBurntInWorkout+caloriesBurntInWalking;
        }
        return totalCaloriesBurnt;
    }
}
