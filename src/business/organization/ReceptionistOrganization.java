/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.ReceptionistRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Prajakta
 */
public class ReceptionistOrganization extends Organization {

    public ReceptionistOrganization() {
        super(Organization.Type.Receptionist.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ReceptionistRole());
        return roles;
   
    }

    @Override
    public String toString() {
        return "Receptionist";
    }
    
    
}
