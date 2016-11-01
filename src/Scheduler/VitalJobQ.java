/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import IOT.Sensor;
import business.DB4OUtil.DB4OUtil;
import business.EcoSystem;
import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.enterprise.PatientTrackerEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.PatientOrganization;
import business.patient.Patient;
import business.person.Person;
import static business.person.Person.Type.Patient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Prajakta
 */
public class VitalJobQ implements Job{

    public VitalJobQ() {
    }
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        DB4OUtil dB4OUtil = DB4OUtil.getInstance();
        EcoSystem system = dB4OUtil.retrieveSystem();         
        Sensor sensor;
        System.out.println("here");
        for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if(enterprise instanceof PatientTrackerEnterprise)
                    {
                        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                        {
                                if(org instanceof PatientOrganization)
                                {
                                    for(Person person : org.getPersonDirectory().getPersonList())
                                        if(person instanceof Patient)
                                        {
                                            sensor = new Sensor((Patient)person);
                                            sensor.recordVitals();
                                        }
                                    break;
                                }
                        }
                }
        }
      }
    }
    
}
