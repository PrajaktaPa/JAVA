/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.exercise;

import IOT.Sensor;
import business.exercise.ExerciseRegime;
import business.medication.Medication;
import business.organization.OrganizationDirectory;
import business.patient.Patient;
import business.patient.vitalSigns.VitalSigns;
import business.userAccount.UserAccount;
import calculations.Calculate;
import java.awt.CardLayout;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Prajakta
 */
public class ManageExerciseJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private UserAccount userAccount;
    private Patient patient;
    private Calculate calculate;
    private Sensor sensor;
    /**
     * Creates new form ManageExerciseJPanel
     */
    public ManageExerciseJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory,UserAccount account) {
        initComponents();
        setSize(1370, 725);
        this.userAccount = account;
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.patient = (Patient) userAccount.getPerson();
        calculate = Calculate.getInstance();
        
        sensor = new Sensor(patient);
//        txtWorkout.setText("11");
//        txtCalories.setText("12");
//        txtSleep.setText("13");
//        txtWalk.setText("14");
        
      
        populateFields();
    }

    public void populateFields(){
       ExerciseRegime exercise =   sensor.recordExercise();
         double cal1=0,cal2=0;
        double weight=0;
        int heartRateWalking=0,hearRateWorkout=0;
        float workOutHours=0,walkingHours=0;
        Map.Entry<Date,VitalSigns> lastEntry = patient.getVitalSignHistory().getVitalSignMap().lastEntry();
        workOutHours = exercise.getHoursWorkout();
        walkingHours = exercise.getHoursWalked();
        heartRateWalking = exercise.getHeartRateWalking();
        hearRateWorkout = exercise.getHeartRateWorkout();
        txtSleep.setText(String.valueOf(exercise.getHoursSlept()));
        txtWalk.setText(String.valueOf(walkingHours));
        txtWorkout.setText(String.valueOf(workOutHours));
        dateChooser.setDate(exercise.getDayOfExercise());
        String gender = patient.getGender();
        if(gender.equals("Male")){
           
            cal1 = patient.getExerciseRegimeHistory().caloriesBurnt(calculate.findAge(patient),lastEntry.getValue().getWeight(), heartRateWalking, hearRateWorkout, workOutHours, gender,walkingHours);
            txtCalories.setText(String.valueOf(cal1));
        }
        else if(gender.equals("Female")){
            cal2 = patient.getExerciseRegimeHistory().caloriesBurnt(calculate.findAge(patient),weight, heartRateWalking,hearRateWorkout, workOutHours, gender,walkingHours);
            txtCalories.setText(String.valueOf(cal2));
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSleep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtWalk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCalories = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblWorkout = new javax.swing.JLabel();
        txtWorkout = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        lblDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("Exercise Tracker");

        jLabel2.setText("Number of hours slept");

        jLabel3.setText("Number of hours walked");

        jLabel4.setText("Calories burnt");

        txtCalories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaloriesActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblWorkout.setText("Workout Regime (in hours)");

        lblDate.setText("Day of Exercise");

        jLabel5.setText("Welcome");

        jLabel6.setText("Exercise Dashboard");

        jLabel7.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblWorkout)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(lblDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSearch))
                    .addComponent(dateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(txtCalories, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWorkout, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWalk, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSleep))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtWalk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWorkout)
                    .addComponent(txtWorkout, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCalories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSearch))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCaloriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaloriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaloriesActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblWorkout;
    private javax.swing.JTextField txtCalories;
    private javax.swing.JTextField txtSleep;
    private javax.swing.JTextField txtWalk;
    private javax.swing.JTextField txtWorkout;
    // End of variables declaration//GEN-END:variables
}
