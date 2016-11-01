/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.medication;

import business.prescription.Prescription;
import java.util.Date;
import java.util.TreeMap;

/**
 *
 * @author Prajakta
 */
public class MedicationHistory {
    
    private TreeMap<Date, Prescription> prescriptionMap;
    
    public MedicationHistory() {
        this.prescriptionMap = new TreeMap<Date, Prescription>();
    }

    public TreeMap<Date, Prescription> getPrescriptionMap() {
        return prescriptionMap;
    }

    public void setPrescriptionMap(TreeMap<Date, Prescription> prescriptionMap) {
        this.prescriptionMap = prescriptionMap;
    }
    
    
    public Prescription addPrescription() {
        Date currentDate = new Date();
        Prescription prescription = new Prescription();
        prescriptionMap.put(currentDate,prescription);
        return prescription;
    }
    
    public Prescription addPrescription(Date date) {
        Prescription prescription = new Prescription();
        prescriptionMap.put(date,prescription);
        return prescription;
    }
    
//    private List<Medication> medicationList;
//
//    public MedicationHistory() {
//        this.medicationList = new ArrayList<>();
//    }
//
//    public List<Medication> getMedicationList() {
//        return medicationList;
//    }
//
//    public void setMedicationList(List<Medication> medicationList) {
//        this.medicationList = medicationList;
//    }
//
//    public Medication addMedication() {
//        Medication medication = new Medication();
//        medicationList.add(medication);
//        return medication;
//    }
//
//    public void deleteMedication(Medication medication) {
//        medicationList.remove(medication);
//    }
}
