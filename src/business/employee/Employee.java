/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

import business.person.Person;

/**
 *
 * @author Prajakta
 */
public class Employee extends Person {
    //private String name;
    //private int id;
    private static int count = 1;

    public enum Type{
        Doctor("Doctor"),Tracker("Tracker"),Receptionist("Receptionist");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public Employee(String name) {
        super(name);
        //id = count;
        //count++;
    }

    /*public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }*/

   
}
