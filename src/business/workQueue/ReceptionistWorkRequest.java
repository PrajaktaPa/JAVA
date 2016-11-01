/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.patient.Patient;

/**
 *
 * @author Prajakta
 */
public class ReceptionistWorkRequest extends WorkRequest  {
    private String appointmentResult;
    private Patient patient;
    private String appointmentReason;

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }
   
    public String getAppointmentResult() {
        return appointmentResult;
    }

    public void setAppointmentResult(String appointmentResult) {
        this.appointmentResult = appointmentResult;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "";
    }

    
}
