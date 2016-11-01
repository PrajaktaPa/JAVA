/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.PatientRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Prajakta
 */
public class PatientOrganization extends Organization {
    public PatientOrganization() {
        super(Organization.Type.Patient.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PatientRole());
        return roles;
    }
}
