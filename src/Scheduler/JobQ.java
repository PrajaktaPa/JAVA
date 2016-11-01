/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Job;
import userInterface.MainJFrame;
import userInterface.meals.TrackMealJFrame;
/**
 *
 * @author Prajakta
 */
public class JobQ implements Job {

    public JobQ() {
        
    }
    
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        TrackMealJFrame frame = new TrackMealJFrame();
        JOptionPane.showMessageDialog(frame, "It's Time! Please track your Meal");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);
//    Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->{
//        System.out.println(frame.getLocation());
//    }, 0, 1000, TimeUnit.MILLISECONDS);
        // Say Hello to the World and display the date/time
        System.out.println("Job Done! - " + new Date());
    }
}
