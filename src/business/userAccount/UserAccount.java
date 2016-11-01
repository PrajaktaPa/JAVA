/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.userAccount;

import business.person.Person;
import business.role.Role;
import business.workQueue.WorkQueue;

/**
 *
 * @author Prajakta
 */
public class UserAccount implements Comparable<UserAccount>{
    private String username;
    private String password;
    //private Employee employee;
    private Person person;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
        
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    
    public Person getPerson() {
        return person;
    }

    /*public void setEmployee(Employee employee) {
    this.employee = employee;
    }
    public Employee getEmployee() {
    return employee;
    }*/
    public void setPerson(Person person) {    
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

   

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }

    @Override
    public int compareTo(UserAccount o) {
        if(this.getWorkQueue().getWorkRequestList().size() > o.getWorkQueue().getWorkRequestList().size()){
            return 1;
        }
        else if(this.getWorkQueue().getWorkRequestList().size() < o.getWorkQueue().getWorkRequestList().size()){
            return -1;
        }
        else if(this.getWorkQueue().getWorkRequestList().size() == o.getWorkQueue().getWorkRequestList().size()){
            return 0;
        }
        return 0;
    }
        
}
