/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.employee.Employee;
import business.person.Person;
import business.role.SystemAdminRole;
import business.userAccount.UserAccount;

/**
 *
 * @author Prajakta
 */
public class ConfigureASystem {
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        //Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        Person person = system.getPersonDirectory().createPerson(Person.Type.Employee, "RRH");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
        return system;
    }
}
