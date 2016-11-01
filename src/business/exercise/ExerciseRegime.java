/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.exercise;

import java.util.Date;

/**
 *
 * @author Prajakta
 */
public class ExerciseRegime {
    private String exerciseType;
    private int heartRateWorkout;
    private int heartRateWalking;
    private float hoursSlept;
    private float hoursWalked;
    private float hoursWorkout;
    private Date dayOfExercise;

    public Date getDayOfExercise() {
        return dayOfExercise;
    }

    public void setDayOfExercise(Date dayOfExercise) {
        this.dayOfExercise = dayOfExercise;
    }
    
    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getHeartRateWorkout() {
        return heartRateWorkout;
    }

    public void setHeartRateWorkout(int heartRateWorkout) {
        this.heartRateWorkout = heartRateWorkout;
    }

    public int getHeartRateWalking() {
        return heartRateWalking;
    }

    public void setHeartRateWalking(int heartRateWalking) {
        this.heartRateWalking = heartRateWalking;
    }

    
    public float getHoursSlept() {
        return hoursSlept;
    }

    public void setHoursSlept(float hoursSlept) {
        this.hoursSlept = hoursSlept;
    }

    public float getHoursWalked() {
        return hoursWalked;
    }

    public void setHoursWalked(float hoursWalked) {
        this.hoursWalked = hoursWalked;
    }

    public float getHoursWorkout() {
        return hoursWorkout;
    }

    public void setHoursWorkout(float hoursWorkout) {
        this.hoursWorkout = hoursWorkout;
    }
    
    
}
