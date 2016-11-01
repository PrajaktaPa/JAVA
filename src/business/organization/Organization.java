/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.person.PersonDirectory;
import business.role.Role;
import business.userAccount.UserAccountDirectory;
import business.workQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Prajakta
 */
public abstract class Organization {
  
    private String name;
    private WorkQueue workQueue;
    //private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    //private PatientDirectory patientDirectory;
    private PersonDirectory personDirectory;
    public enum Type{
        Admin("Admin Organization"), Patient("Patient Organization"),Receptionist("Receptionist Organization"), Tracker("Tracker Organization"), Doctor("Doctor Organization"),Lab("Lab Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        //employeeDirectory = new EmployeeDirectory();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    /*public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }*/
    
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
}
