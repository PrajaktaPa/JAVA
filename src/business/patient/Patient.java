/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient;

import business.exercise.ExerciseRegimeHistory;
import business.meals.MealDirectory;
import business.medication.Medication;
import business.medication.MedicationHistory;
import business.patient.vitalSigns.VitalSignHistory;
import business.person.Person;
import business.prescription.Prescription;
import calculations.Calculate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prajakta
 */
public class Patient extends Person implements Comparable<Patient>{
    //private String name;
    //private String address;
    private VitalSignHistory vitalSignHistory;
    private MealDirectory mealDirectory;
    private MedicationHistory medicationHistory;
    private ExerciseRegimeHistory exerciseRegimeHistory;
    private Prescription prescription;
    private Calculate calculate;

    public Patient(String name) {
        super(name);
        vitalSignHistory = new VitalSignHistory();
        mealDirectory = new MealDirectory();
        medicationHistory = new MedicationHistory();
        exerciseRegimeHistory = new ExerciseRegimeHistory();
        prescription = new Prescription();
    }

    
    public MealDirectory getMealDirectory() {
        return mealDirectory;
    }

    public void setMealDirectory(MealDirectory mealDirectory) {
        this.mealDirectory = mealDirectory;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public MedicationHistory getMedicationHistory() {
        return medicationHistory;
    }

    public void setMedicationHistory(MedicationHistory medicationHistory) {
        this.medicationHistory = medicationHistory;
    }

    public ExerciseRegimeHistory getExerciseRegimeHistory() {
        return exerciseRegimeHistory;
    }

    public void setExerciseRegimeHistory(ExerciseRegimeHistory exerciseRegimeHistory) {
        this.exerciseRegimeHistory = exerciseRegimeHistory;
    }

    @Override
    public int compareTo(Patient p) {
        calculate = Calculate.getInstance();
        Float grade1 = calculate.calculateOverAllGrade(p);
        Float grade2 = calculate.calculateOverAllGrade(this);
        
        return grade2.compareTo(grade1);
    }
    
}
