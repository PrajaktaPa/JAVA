/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.vitalSigns;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Prajakta
 */
public class VitalSigns {
    private int fastingBloodSugar;
    private int afterMealBloodSugar;
    private float visionRate;
    private int cholesterol;
    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private int weight;
    private int eGFR;
    private int albumin;
    

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFastingBloodSugar() {
        return fastingBloodSugar;
    }

    public void setFastingBloodSugar(int fastingBloodSugar) {
        this.fastingBloodSugar = fastingBloodSugar;
    }

    public int getAfterMealBloodSugar() {
        return afterMealBloodSugar;
    }

    public void setAfterMealBloodSugar(int afterMealBloodSugar) {
        this.afterMealBloodSugar = afterMealBloodSugar;
    }

    public float getVisionRate() {
        return visionRate;
    }

    public void setVisionRate(float visionRate) {
        this.visionRate = visionRate;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getEGFR() {
        return eGFR;
    }

    public void seteGFR(int eGFR) {
        this.eGFR = eGFR;
    }

    public int getAlbumin() {
        return albumin;
    }

    public void setAlbumin(int albumin) {
        this.albumin = albumin;
    }

    
    
    @Override
    public String toString() {
        String datePattern = "MM/dd/yyyy hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        Date date = new Date();
        return (sdf.format(date));
    }
    
}
