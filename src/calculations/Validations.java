package calculations;


import business.patient.vitalSigns.VitalSigns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prajakta
 */
public class Validations {
    //Validating if the entered value contains only alphabets.
    public boolean validateString(String value) {

        Pattern pattern = Pattern.compile("^[a-zA-Z]*$", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(value);
        boolean isValidString = matcher.matches();
        return isValidString;
    }

    //Validating if the entered value is alphanumeric.
    public boolean validateAlphaNumeric(String value) {

        Pattern pattern = Pattern.compile("^[a-z0-9A-Z]*$", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(value);
        boolean isValidAlphaNumeric = matcher.matches();
        return isValidAlphaNumeric;
    }
    
    public boolean validateHoursMins(String value){
        Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]$", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(value);
        boolean isValidHoursMins = matcher.matches();
        return isValidHoursMins;
    }
    private String vitalStatus;

    // Displays whether a vital sign is normal or abnormal
    public String vitalStatus(int age, VitalSigns vitalSign) {
        int respiratoryRate = vitalSign.getRespiratoryRate();
        int heartRate = vitalSign.getHeartRate();
        int fastingBloodSugar = vitalSign.getFastingBloodSugar();
        int afterMealBloodSugar = vitalSign.getAfterMealBloodSugar();
        int weight = vitalSign.getWeight();
        float vision = vitalSign.getVisionRate();
        int eGFR = vitalSign.getEGFR();
        int albumin = vitalSign.getAlbumin();
        int cholesterol = vitalSign.getCholesterol();
        
        if(age == 0){
            if (weight>=0 && weight <=5){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(fastingBloodSugar>=0 && fastingBloodSugar<=30){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(afterMealBloodSugar >=0 && afterMealBloodSugar<=30){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(heartRate >= 0 && heartRate <= 30){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(vision >= 0.125 && vision<=0.25){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(eGFR>=0 && eGFR<=29){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(albumin >=0 && albumin <=1.4){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Abnormal";
            }
            if(cholesterol >=0 && cholesterol<=80){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
        }
        else if(age >= 1 && age <=15){
            if (weight>=10 && weight <=30){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Under Weight";
            }
            if(fastingBloodSugar>=31 && fastingBloodSugar<=50){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(afterMealBloodSugar >=31 && afterMealBloodSugar<=50){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(heartRate >= 31 && heartRate <= 60){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(vision >= 0.26 && vision<=0.62){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(eGFR>=30 && eGFR<=59){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(albumin >=1.5 && albumin <=3){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(cholesterol >=81 && cholesterol<=100){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Low";
            }
        }
        else if(age >= 16 && age <=35){
            if (weight>=25 && weight <=60){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Under Weight";
            }
            if(fastingBloodSugar>=51 && fastingBloodSugar<=99){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(afterMealBloodSugar >=51 && afterMealBloodSugar<=140){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(heartRate >= 60 && heartRate <= 100){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(vision >= 0.63 && vision<=1.6){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(eGFR>=60 && eGFR<=200){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(albumin >=3 && albumin <=6){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(cholesterol >=101 && cholesterol<=200){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Low";
            }
        }
        else if(age >= 36 && age <=65){
            if (weight>=60 && weight <=80){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Under Weight";
            }
            if(fastingBloodSugar>=70 && fastingBloodSugar<=100){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(afterMealBloodSugar >=70 && afterMealBloodSugar<=150){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(heartRate >= 60 && heartRate <= 100){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(vision >= 0.63 && vision<=1.6){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(eGFR>=60 && eGFR<=100){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(albumin >=3.5 && albumin <=5.5){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(cholesterol >=181 && cholesterol<=250){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Low";
            }
        }
        else if(age >= 66 && age <=150){
            if (weight>=60 && weight <=150){
                vitalStatus = "Normal";
            }
            else {
                vitalStatus = "Under Weight";
            }
            if(fastingBloodSugar>=70 && fastingBloodSugar<=100){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(afterMealBloodSugar >=70 && afterMealBloodSugar<=150){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(heartRate >= 60 && heartRate <= 110){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(vision >= 0.8 && vision<=1.6){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(eGFR>=30 && eGFR<=70){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(albumin >=3 && albumin <=6){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Abnormal";
            }
            if(cholesterol >=180 && cholesterol<=250){
                vitalStatus = "Normal";
            }
            else{
                vitalStatus = "Low";
            }
        }
        
        return vitalStatus;
    }
    
}
