/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.TrackerOrganization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Prajakta
 */
public class TrackerRole extends Role {
   @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
     return null; //  return new TrackerWorkAreaJPanel(userProcessContainer, account, (TrackerOrganization)organization, enterprise);
    } 
    
    @Override
    public String toString() {
        return "TrackerRole";
    }
}
