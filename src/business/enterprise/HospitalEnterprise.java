/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Prajakta
 */
public class HospitalEnterprise extends Enterprise {
    public HospitalEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Hospital);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
