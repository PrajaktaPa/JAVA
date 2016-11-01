/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import calculations.Calculate;
import java.util.Date;


/**
 *
 * @author Prajakta
 */
public abstract class Person {
    private String name;
    private String userName;
    private String lname;
    private String address;
    private int personID;
    private static int counter;
    private Date dateOfBirth;
    private String emaidId;
    private int areaCode;
    private long phoneNumber;
    private String gender;
    
    
    public enum Type{
        Employee("Employee"), Patient("Patient"),Receptionist("Receptionist");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Person(String userName) {
        this.userName = userName;
        personID = counter;
        ++counter;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getPersonID() {
        return personID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmaidId() {
        return emaidId;
    }

    public void setEmaidId(String emaidId) {
        this.emaidId = emaidId;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    @Override
    public String toString() {
        return userName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.personID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.personID != other.personID) {
            return false;
        }
        return true;
    }
    
}