/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import java.util.Calendar;
import java.util.Date;
import org.quartz.CronScheduleBuilder;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
/**
 *
 * @author Prajakta
 */
public class SchedulerQ {
    SchedulerFactory sf;
    Scheduler sched;
    public void run() throws Exception {
        //Track Vitals every Hour
        JobDetail job4 = newJob(VitalJobQ.class).withIdentity("job4", "group4").build();
// Trigger the job to run on the next round minute
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY,14);
    cal.set(Calendar.MINUTE,21);
    Date runTime = cal.getTime();
     
        SimpleTriggerImpl trigger4 = new SimpleTriggerImpl("trigger4",
                                            "group4",
                                            runTime,
                                            null,
                                            18,
                                            60L * 1000L);

    //JOB1
     cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY,2);
    cal.set(Calendar.MINUTE,30);
     runTime = cal.getTime();
    System.out.println("------- Scheduling Job  -------------------");
// define the job and tie it to our HelloJob class
    JobDetail job = newJob(JobQ.class).withIdentity("job1", "group1").build();
// Trigger the job to run on the next round minute
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    //JOB2
    cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY,2);
    cal.set(Calendar.MINUTE,29);
    runTime = cal.getTime();
    System.out.println("------- Scheduling Job  -------------------");
    // define the job and tie it to our HelloJob class
    JobDetail job1 = newJob(JobQ.class).withIdentity("job2", "group2").build();
    // Trigger the job to run on the next round minute
    Trigger trigger1 = newTrigger().withIdentity("trigger2", "group2").startAt(runTime).build();
    
    //JOB3
    cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY,2);
    cal.set(Calendar.MINUTE,28);
    runTime = cal.getTime();
    
    System.out.println("------- Scheduling Job  -------------------");

    JobDetail job2 = newJob(JobQ.class).withIdentity("job3", "group3").build();

    Trigger trigger2 = newTrigger().withIdentity("trigger3", "group3").startAt(runTime).build();

    // Call to send mail
    JobDetail JobMail1 = newJob(MailJob.class).withIdentity("JobMail", "group1").build();
    Trigger triggerMail1 = newTrigger().withIdentity("triggerMail","group1").startAt(runTime).build();
    
//    JobDetail JobMail2 = newJob(MailJob.class).withIdentity("JobMail", "group1").build();
//    Trigger triggerMail2 = newTrigger().withIdentity("triggerMail","group1").startAt(runTime).build();
//    
//    JobDetail JobMail3 = newJob(MailJob.class).withIdentity("JobMail", "group1").build();
//    Trigger triggerMail3 = newTrigger().withIdentity("triggerMail","group1").startAt(runTime).build();
    
    // Tell quartz to schedule the job using our trigger
    if(new Date().compareTo(trigger.getStartTime()) < 0)
        sched.scheduleJob(job, trigger);
        sched.scheduleJob(JobMail1,triggerMail1);
    if(new Date().compareTo(trigger1.getStartTime()) < 0)
        sched.scheduleJob(job1, trigger1);
        //sched.scheduleJob(JobMail2,triggerMail2);
    if(new Date().compareTo(trigger2.getStartTime()) < 0)
        sched.scheduleJob(job2, trigger2);
        //sched.scheduleJob(JobMail3,triggerMail3);
    
    sched.scheduleJob(job4,trigger4);
    System.out.println(job.getKey() + " will run at: " + trigger.getStartTime());
    System.out.println(job1.getKey() + " will run at: " + trigger1.getStartTime());
    System.out.println(job2.getKey() + " will run at: " + trigger2.getStartTime());
    System.out.println(job4.getKey() + " will run at: " + trigger4.getStartTime());
    // Start up the scheduler (nothing can actually run until the
    // scheduler has been started)
    sched.start();

    System.out.println("------- Started Scheduler -----------------");
  }
  
    public void init()throws Exception
    {
       System.out.println("------- Initializing ----------------------");
       sf = new StdSchedulerFactory();
        sched = sf.getScheduler(); 
       System.out.println("------- Initialization Complete -----------");
    }
  public void shutdown()throws Exception
  {
       // shut down the scheduler
    System.out.println("------- Shutting Down ---------------------");
    sched.shutdown(true);
    System.out.println("------- Shutdown Complete -----------------");
  }
}
