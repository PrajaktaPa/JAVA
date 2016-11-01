/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.enterprise.Enterprise.EnterpriseType;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Prajakta
 */
public class PatientTrackerEnterprise extends Enterprise {
    public PatientTrackerEnterprise(String name) {
        super(name, EnterpriseType.PatientTracker);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
