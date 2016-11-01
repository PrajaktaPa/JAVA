/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.prescription;

import business.medication.Medication;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Prajakta
 */
public class Prescription {

    private List<Medication> medicationList;
    
    public Prescription() {
        medicationList = new ArrayList<Medication>();
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }
    
    public Medication addMedication() {
        Medication medication = new Medication();
        medicationList.add(medication);
        return medication;
    }
}
