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
import business.enterprise.PatientTrackerEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.PatientOrganization;
import business.patient.Patient;
import business.person.Person;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Prajakta
 */
public class MailJob implements Job {
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try{
        DB4OUtil dB4OUtil = DB4OUtil.getInstance();
         EcoSystem system = dB4OUtil.retrieveSystem();
        for (Network network : system.getNetworkList()) {
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
                                            System.out.println("Hi there1");
                                            SendGrid mailClient = new SendGrid("Prajakta", "prajakta19");
                                            //String carbonCopy="prajaktakpawar1990@gmail.com";
                                            SendGrid.Email email = new SendGrid.Email();
                                            String mailto ="prajaktakpawar1990@gmail.com";
                                            email.addTo(mailto);
                                           // email.addCc(carbonCopy);
                                            System.out.println("Hi there2");
                                            email.setFrom("prajaktakpawar1990@gmail.com");
                                            email.setSubject("Meal Reminder");
                                            email.setText("Please have your Meal!");

                                            try {
                                                System.out.println("Hi there3");
                                              SendGrid.Response response = mailClient.send(email);
                                              System.out.println(response.getMessage());
                                            }
                                            catch (SendGridException  e) {
                                              System.err.println(e);
                                            }
                                        }
                                    break;
                                }
                        }
                }
        }
      }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
