/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import business.employee.Employee;
import business.patient.Patient;
import business.person.Person.Type;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Prajakta
 */
public class PersonDirectory {
     private ArrayList<Person> personList;
    
    public PersonDirectory() {
        personList = new ArrayList<>();
        
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPerson(Type type,String name){
        Person person = null;
        if (type.getValue().equals(Type.Patient.getValue())){
            person = new Patient(name);
            personList.add(person);
        }
        else if (type.getValue().equals(Type.Employee.getValue())){
            person = new Employee(name);
            personList.add(person);
        }
//        else if (type.getValue().equals(Type.Doctor.getValue())){
//            person = new Employee(name);
//            personList.add(person);
//        }
        return person;
    }
    
    
}
