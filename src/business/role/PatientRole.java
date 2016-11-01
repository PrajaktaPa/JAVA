/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.PatientOrganization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.patient.PatientWorkAreaJPanel;

/**
 *
 * @author Prajakta
 */
public class PatientRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PatientWorkAreaJPanel(userProcessContainer, account, (PatientOrganization)organization, enterprise,business);
    }
    
    @Override
    public String toString() {
        return "PatientRole";
    }
}
