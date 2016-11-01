/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.doctor;

import business.employee.Employee;

/**
 *
 * @author Prajakta
 */
public class Doctor extends Employee implements Comparable<Doctor>{

    public Doctor(String name) {
        super(name);
    }

    @Override
    public int compareTo(Doctor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
