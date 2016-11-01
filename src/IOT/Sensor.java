/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOT;

import business.exercise.ExerciseRegime;
import business.patient.Patient;
import business.patient.vitalSigns.VitalSigns;
import calculations.Calculate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Prajakta
 */
public class Sensor {
    private Patient patient;
    int randomInt1,randomInt2,randomInt3,randomInt4,randomInt5,randomInt6=0;
    private List<VitalSigns> vitalsList;
    VitalSigns vitalSigns;
    Calculate calculate;
    int age = 0;
    float exerciseGrade = 0, mealGrade = 0, medicationGrade=0, vitalSignGrade=0;
    Random randomGenerator = new Random();
    
    public Sensor(Patient patient) {
        this.patient = patient;
        vitalsList = new ArrayList<>();
        vitalSigns = new VitalSigns();
    }
    
    public VitalSigns recordVitals(){
        System.out.println("hi praju");
              calculate = Calculate.getInstance();
              age = calculate.findAge(patient);
              exerciseGrade = calculate.calculateExerciseGrade(patient);
              mealGrade = calculate.calculateMealGrade(patient);
              medicationGrade = calculate.calculateMedicationGrade(patient);
              float gradeAvg = ((exerciseGrade + mealGrade + medicationGrade)/3)*100;
              if(calculate.findAge(patient) == 0){
                if(gradeAvg <=25){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(2));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(40));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(40));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(30));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(5));
                    vitalSigns.seteGFR(randomGenerator.nextInt(20));
        
                    }
                
                if(gradeAvg >=25 && gradeAvg <=50){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(2));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(50));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(50));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(30));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(5));
                    vitalSigns.seteGFR(randomGenerator.nextInt(20));
        
                    }
                
                if(gradeAvg >=50 && gradeAvg <=75){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(2));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(70));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(70));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(30));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(5));
                    vitalSigns.seteGFR(randomGenerator.nextInt(25));
        
                    }
                  
                  
                if(gradeAvg >=75 ){

                      vitalSigns = patient.getVitalSignHistory().addVitalSign();
                      vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(30));
                      vitalSigns.setAlbumin(randomGenerator.nextInt(2));
                      vitalSigns.setBloodPressure(randomGenerator.nextInt(70));
                      vitalSigns.setCholesterol(randomGenerator.nextInt(80));
                      vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(30));
                      vitalSigns.setHeartRate(randomGenerator.nextInt(30));
                      vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                      vitalSigns.setVisionRate(randomGenerator.nextFloat());
                      vitalSigns.setWeight(randomGenerator.nextInt(5));
                      vitalSigns.seteGFR(randomGenerator.nextInt(30));
        
                      }
              }
              
              else if(age>=1 && age<=15){
                if(gradeAvg <= 25){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(2));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(50));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(50));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(40));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(25));
                    vitalSigns.seteGFR(randomGenerator.nextInt(45));
        
                    }
                
                if(gradeAvg >=25 && gradeAvg <=50){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(35));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(2));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(55));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(55));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(35));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(45));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(30));
                    vitalSigns.seteGFR(randomGenerator.nextInt(50));
        
                    }
                
                if(gradeAvg >=50 && gradeAvg <=75){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(50));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(3));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(100));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(150));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(50));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(60));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(30));
                    vitalSigns.seteGFR(randomGenerator.nextInt(60));
        
                    }
                  
                  
                if(gradeAvg>=75){

                      vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(50));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(3));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(100));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(150));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(50));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(60));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(30));
                    vitalSigns.seteGFR(randomGenerator.nextInt(60));
        
                      }
              }
              
              else if(age>=16 && age<=35){
                if(gradeAvg<=25){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(110));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(5));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(100));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(100));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(30));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(90));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(65));
                    vitalSigns.seteGFR(randomGenerator.nextInt(180));
        
                    }
                
                if(gradeAvg >=25 && gradeAvg <=50){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(115));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(5));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(110));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(110));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(40));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(100));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(75));
                    vitalSigns.seteGFR(randomGenerator.nextInt(190));
        
                    }
                
                if(gradeAvg >=50 && gradeAvg <=75){
                    
                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(125));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(5));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(110));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(150));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(80));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(100));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(75));
                    vitalSigns.seteGFR(randomGenerator.nextInt(190));
        
                    }
                  
                  
                if(gradeAvg >=75){

                    vitalSigns = patient.getVitalSignHistory().addVitalSign();
                    vitalSigns.setAfterMealBloodSugar(randomGenerator.nextInt(140));
                    vitalSigns.setAlbumin(randomGenerator.nextInt(5));
                    vitalSigns.setBloodPressure(randomGenerator.nextInt(120));
                    vitalSigns.setCholesterol(randomGenerator.nextInt(200));
                    vitalSigns.setFastingBloodSugar(randomGenerator.nextInt(100));
                    vitalSigns.setHeartRate(randomGenerator.nextInt(100));
                    vitalSigns.setRespiratoryRate(randomGenerator.nextInt(20));
                    vitalSigns.setVisionRate(randomGenerator.nextFloat());
                    vitalSigns.setWeight(randomGenerator.nextInt(75));
                    vitalSigns.seteGFR(randomGenerator.nextInt(200));
               }
              }
          if(vitalSigns.getWeight() == 0){
              vitalSigns.setWeight(2);
          }
           return vitalSigns;   
    }
    
    public ExerciseRegime recordExercise(){
          calculate = Calculate.getInstance();
              age = calculate.findAge(patient);
              vitalSignGrade = calculate.calculateVitalsGrade(patient);
              mealGrade = calculate.calculateMealGrade(patient);
              medicationGrade = calculate.calculateMedicationGrade(patient);
              float averageGrade = ((vitalSignGrade + mealGrade + medicationGrade)/3)*100;
              ExerciseRegime exercise = patient.getExerciseRegimeHistory().addExerciseRegime();
              if(calculate.findAge(patient) == 0){
                    exerciseGrade = 1;
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(4);
                    exercise.setHoursWalked(1);
                    exercise.setHoursWorkout(1);
                    exercise.setHeartRateWalking(40);
                    exercise.setHeartRateWorkout(60);
                }
              else if(age>=1 && age<=15){
                if(averageGrade <=25){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(5));
                    exercise.setHoursWalked(randomGenerator.nextInt(2));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(40));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(70));
                    
                }
                if(averageGrade >=25 && averageGrade <=50){
                    
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(5));
                    exercise.setHoursWalked(randomGenerator.nextInt(2));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(45));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(70));
                    
                }
                if(averageGrade >=50 && averageGrade <=75){
                    
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(5));
                    exercise.setHoursWalked(randomGenerator.nextInt(2));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(50));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(75));
                    
                }
                if(averageGrade >=75){
                    
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(5));
                    exercise.setHoursWalked(randomGenerator.nextInt(2));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(60));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(80));
                    
                }
              }
              else if(age>=16 && age<=35){
                if(averageGrade <=25){
                    
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(5));
                    exercise.setHoursWalked(randomGenerator.nextInt(2));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(60));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(80));
                }
                if(averageGrade >=25 && averageGrade <=50){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(7));
                    exercise.setHoursWalked(randomGenerator.nextInt(6));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                    
                }
                if(averageGrade >=50 && averageGrade <=75){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(8));
                    exercise.setHoursWalked(randomGenerator.nextInt(6));
                    exercise.setHoursWorkout(randomGenerator.nextInt(2));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                    
                }
                if(averageGrade >=75){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(7));
                    exercise.setHoursWalked(randomGenerator.nextInt(6));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                }
        }
              else if(age>=36 && age<=65){
                if(averageGrade <=25){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(7));
                    exercise.setHoursWalked(randomGenerator.nextInt(5));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                }
                if(averageGrade >=25 && averageGrade <=50){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(8));
                    exercise.setHoursWalked(randomGenerator.nextInt(6));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(120));
                }
                if(averageGrade >=50 && averageGrade <=75){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(8));
                    exercise.setHoursWalked(randomGenerator.nextInt(6));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                    
                }
                if(averageGrade >=75){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(8));
                    exercise.setHoursWalked(randomGenerator.nextInt(6));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                    
                }
        }
              else if(age>=66 && age<=150){
                if(averageGrade <=25){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(7));
                    exercise.setHoursWalked(randomGenerator.nextInt(5));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(100));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(120));
                }
                if(averageGrade >=25 && averageGrade <=50){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(7));
                    exercise.setHoursWalked(randomGenerator.nextInt(5));
                    exercise.setHoursWorkout(randomGenerator.nextInt(1));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(100));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(120));
                }
                if(averageGrade >=50 && averageGrade <=75){
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(8));
                    exercise.setHoursWalked(randomGenerator.nextInt(5));
                    exercise.setHoursWorkout(randomGenerator.nextInt(2));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                    
                }
                if(averageGrade >=75){
                    
                    exercise.setDayOfExercise(new Date());
                    exercise.setHoursSlept(randomGenerator.nextInt(8));
                    exercise.setHoursWalked(randomGenerator.nextInt(5));
                    exercise.setHoursWorkout(randomGenerator.nextInt(2));
                    exercise.setHeartRateWalking(randomGenerator.nextInt(110));
                    exercise.setHeartRateWorkout(randomGenerator.nextInt(130));
                    
                }
        }
        return exercise;
    } 
    
}