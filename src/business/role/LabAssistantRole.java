/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.Lab.LabAssistantWorkAreaJPanel;

/**
 *
 * @author Prajakta
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization, business);
    }

    @Override
    public String toString() {
        return "LabAssistantRole";
    }
    
}
