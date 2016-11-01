/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

import IOT.Sensor;
import business.exercise.ExerciseRegime;
import business.meals.Meal;
import business.medication.Medication;
import business.patient.Patient;
import business.patient.vitalSigns.VitalSigns;
import business.person.Person;
import business.prescription.Prescription;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Prajakta
 */
public class Calculate {
   public static Calculate calculate;
    float ideal=0,notIdeal=0,count=0;
    float grade=0,overAllGrade=0;
    int age=0;
    float hoursWorkout=0,hoursWalked=0;
    int heartRateWalk=0,heartRateRun=0;
    double caloriesBurnt=0,weight =0;
    String gender = "";
    //private List<Meal> mealList;
    Sensor sensor;
    Date date;

    public static Calculate getInstance(){
        if(calculate == null){
            calculate = new Calculate();
        }
        return calculate;
    }
    
    private Calculate()
    {
        
    }
    
    public int findAge(Person person){
        
        Date dob = person.getDateOfBirth();
        Calendar dobcalen = Calendar.getInstance();
        dobcalen.setTime(dob);
        Calendar today = Calendar.getInstance();  
        age = today.get(Calendar.YEAR) - dobcalen.get(Calendar.YEAR);  
        if (today.get(Calendar.MONTH) < dobcalen.get(Calendar.MONTH)) {
          age--;  
        } else if (today.get(Calendar.MONTH) == dobcalen.get(Calendar.MONTH)
            && today.get(Calendar.DAY_OF_MONTH) < dobcalen.get(Calendar.DAY_OF_MONTH)) {
          age--;  
        }
        return age;
    }
    
    public float calculateMedicationGrade(Patient patient){
        int prescribedTime =0;
        int consumedTime = 23;
        for(Map.Entry<Date,Prescription> medicationMap : patient.getMedicationHistory().getPrescriptionMap().entrySet()){
            for(Medication medication : medicationMap.getValue().getMedicationList()){
                count++;
                if(medication!=null && medication.getPrescribedTime()!=null)
                    prescribedTime = medication.getPrescribedTime().getHour();
                
                if(medication!=null && medication.getMedicineConsumedTime()!=null)
                        consumedTime = medication.getMedicineConsumedTime().getHour();
                
                if(consumedTime > (prescribedTime+1) || consumedTime < (prescribedTime-1)){
                    notIdeal++;
                }
                else{
                    ideal++;
                }    
            }
            
        }
            if(count == 0){
            return 1;
            }
            else{
            grade = (ideal/count)*100;
            return grade;
            }
    }
    
    public float calculateExerciseGrade(Patient patient){
        age=findAge(patient);
        Date key;
        for(ExerciseRegime exerciseRegime : patient.getExerciseRegimeHistory().getExerciseList()){
            
            hoursWorkout = exerciseRegime.getHoursWorkout();
            gender = patient.getGender();
            hoursWalked = exerciseRegime.getHoursWalked();
            count++;
            heartRateWalk = exerciseRegime.getHeartRateWalking();
            heartRateRun = exerciseRegime.getHeartRateWorkout();
           if(exerciseRegime.getDayOfExercise() == null){
             key = patient.getVitalSignHistory().getVitalSignMap().lowerKey(new Date());   
            }
           else{
            key = patient.getVitalSignHistory().getVitalSignMap().lowerKey(exerciseRegime.getDayOfExercise());
           }
           
           if(key == null){
               key = patient.getVitalSignHistory().getVitalSignMap().higherKey(exerciseRegime.getDayOfExercise());
           }
           else{
               JOptionPane.showMessageDialog(null,"Calories Burnt cannot be calculated. No exercise history found ","",JOptionPane.WARNING_MESSAGE);
               return 50;
           }
            VitalSigns vitals =patient.getVitalSignHistory().getVitalSignMap().get(key);
        //for(Map.Entry<Date,VitalSigns> vitals : patient.getVitalSignHistory().getVitalSignMap().entrySet()){
            if(vitals == null){
                weight = 1;
            }
            else{
            weight = vitals.getWeight();
            }
//            heartRate = vitals.getHeartRate();
            
        //}
        caloriesBurnt = patient.getExerciseRegimeHistory().caloriesBurnt(age, weight, heartRateWalk, heartRateRun, hoursWorkout, gender, hoursWalked);
        
        if(weight>=0 && weight<=20){
            if(caloriesBurnt>1600){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(weight>=21 && weight<=50){
            if(caloriesBurnt>2050){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(weight>=51 && weight<=100){
            if(caloriesBurnt>2700){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(weight>=101 && weight<=200){
            if(caloriesBurnt>2700){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
    }
        if(count == 0){
            return 1;
        }
        else{
        grade = (ideal/count)*100;
        return grade;
        }
}
    
    
    public float calculateMealGrade(Patient patient){
     for(Meal meal : patient.getMealDirectory().getMealList()){
            double calorieIntake = meal.getCalorieIntake();
            count++;
            if(weight>=0 && weight<=20){
            if(calorieIntake<1600){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(weight>=21 && weight<=50){
            if(calorieIntake<2050){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(weight>=51 && weight<=100){
            if(calorieIntake<2700){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(weight>=101 && weight<=200){
            if(calorieIntake<2700){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
         }
     if(count == 0){
            return 1;
        }
        else{
     grade = (ideal/count)*100;
        return grade;
     }
     }   
    
    public float calculateVitalsGrade(Patient patient){
        for(Map.Entry<Date,VitalSigns> vitalSignMap : patient.getVitalSignHistory().getVitalSignMap().entrySet()){
            //sensor = new Sensor(patient);
            //VitalSigns vitalSigns = sensor.recordVitals();
            VitalSigns vitalSigns = vitalSignMap.getValue();
            count++;
            int age = findAge(patient);
            int afterMealBloodSugar = vitalSigns.getAfterMealBloodSugar();
            int albumin = vitalSigns.getAlbumin();
            int bloodPressure = vitalSigns.getBloodPressure();
            int cholesterol = vitalSigns.getCholesterol();
            int eGFR = vitalSigns.getEGFR();
            int fastingBloodSugar = vitalSigns.getFastingBloodSugar();
            int heartRate = vitalSigns.getHeartRate();
            int respiratoryRate = vitalSigns.getRespiratoryRate();
            float vision = vitalSigns.getVisionRate();
            int weight = vitalSigns.getWeight();
            
            if(age == 0){
            if (weight>=0 && weight <=5){
                ideal++;
            }
            else {
                notIdeal++;
            }
            if(fastingBloodSugar>=0 && fastingBloodSugar<=30
               && afterMealBloodSugar >=0 && afterMealBloodSugar<=30
               && heartRate >= 0 && heartRate <= 30
               && vision >= 0.125 && vision<=0.25
               && eGFR>=0 && eGFR<=29
               && albumin >=0 && albumin <=1.4
               && cholesterol >=0 && cholesterol<=80){
                ideal++;
            }
            else{
                notIdeal++;
            }
            
        }
        else if(age >= 1 && age <=15){
            if (weight>=10 && weight <=30){
                ideal++;
            }
            else {
                notIdeal++;
            }
            if(fastingBloodSugar>=31 && fastingBloodSugar<=50
               && afterMealBloodSugar >=31 && afterMealBloodSugar<=50
               && heartRate >= 31 && heartRate <= 60
               && vision >= 0.26 && vision<=0.62
               && eGFR>=30 && eGFR<=59
               && albumin >=1.5 && albumin <=3
               && cholesterol >=81 && cholesterol<=100){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(age >= 16 && age <=35){
            if (weight>=25 && weight <=75){
               ideal++;
            }
            else {
                notIdeal++;
            }
            if(fastingBloodSugar>=51 && fastingBloodSugar<=99
               && afterMealBloodSugar >=51 && afterMealBloodSugar<=140
               && heartRate >= 60 && heartRate <= 100
               && vision >= 0.63 && vision<=1.6
               && eGFR>=60 && eGFR<=200
               && albumin >=3 && albumin <=6
               && cholesterol >=101 && cholesterol<=200){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(age >= 36 && age <=65){
            if (weight>=60 && weight <=90){
               ideal++;
            }
            else {
                notIdeal++;
            }
            if(fastingBloodSugar>=70 && fastingBloodSugar<=100
               && afterMealBloodSugar >=70 && afterMealBloodSugar<=150
               && heartRate >= 60 && heartRate <= 100
               && vision >= 0.63 && vision<=1.6
               && eGFR>=60 && eGFR<=100
               && albumin >=3.5 && albumin <=5.5
               && cholesterol >=181 && cholesterol<=250){
               ideal++;
            }
            else{
                notIdeal++;
            }
        }
        else if(age >= 66 && age <=150){
            if (weight>=60 && weight <=150){
                ideal++;
            }
            else {
                notIdeal++;
            }
            if(fastingBloodSugar>=70 && fastingBloodSugar<=100
               && afterMealBloodSugar >=70 && afterMealBloodSugar<=150
               && heartRate >= 60 && heartRate <= 110
               && vision >= 0.8 && vision<=1.6
               && eGFR>=30 && eGFR<=70
               && albumin >=3 && albumin <=6
               && cholesterol >=180 && cholesterol<=250){
                ideal++;
            }
            else{
                notIdeal++;
            }
        }
        }
        if(count == 0){
            return 1;
        }
        else{
        grade = (ideal/count)*100;
        return grade;
        }
    }
    
    public float calculateOverAllGrade(Patient patient){
        overAllGrade = (calculateExerciseGrade(patient) + calculateMealGrade(patient)+
                              calculateMedicationGrade(patient) + calculateVitalsGrade(patient))/4;
        return overAllGrade;
    }
}
