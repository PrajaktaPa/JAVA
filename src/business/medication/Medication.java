/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.medication;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Prajakta
 */
public class Medication {
    private int dosageMedicine;
    private String medicineName;
    private String medicineType;
    private boolean isInsulin;
    private int dosageInsulin;
    private LocalTime prescribedTime;
    private LocalTime medicineConsumedTime;
    private Date dateOfTracking;

    public Date getDateOfTracking() {
        return dateOfTracking;
    }

    public void setDateOfTracking(Date dateOfTracking) {
        this.dateOfTracking = dateOfTracking;
    }

    public LocalTime getPrescribedTime() {
        return prescribedTime;
    }

    public void setPrescribedTime(LocalTime prescribedTime) {
        this.prescribedTime = prescribedTime;
    }

    public LocalTime getMedicineConsumedTime() {
        return medicineConsumedTime;
    }

    public void setMedicineConsumedTime(LocalTime medicineConsumedTime) {
        this.medicineConsumedTime = medicineConsumedTime;
    }

    
    public int getDosageMedicine() {
        return dosageMedicine;
    }

    public void setDosageMedicine(int dosageMedicine) {
        this.dosageMedicine = dosageMedicine;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public boolean isIsInsulin() {
        return isInsulin;
    }

    public void setIsInsulin(boolean isInsulin) {
        this.isInsulin = isInsulin;
    }

    public int getDosageInsulin() {
        return dosageInsulin;
    }

    public void setDosageInsulin(int dosageInsulin) {
        this.dosageInsulin = dosageInsulin;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    @Override
    public String toString() {
        return medicineName;
    }
        
}
