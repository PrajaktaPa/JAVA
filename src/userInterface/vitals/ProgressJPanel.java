/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.vitals;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.network.Network;
import business.organization.DoctorOrganization;
import business.organization.Organization;
import business.organization.OrganizationDirectory;
import business.organization.PatientOrganization;
import business.patient.Patient;
import business.person.Person;
import business.userAccount.UserAccount;
import calculations.Calculate;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Prajakta
 */
public class ProgressJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private UserAccount userAccount;
    private Patient patient;
    private Calculate calculate;
    List<Patient> sortedList;
    private EcoSystem business;
    List<UserAccount> sortedListDoctor;
    /**
     * Creates new form ProgressJPanel
     */
    public ProgressJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory,UserAccount account, EcoSystem business) {
        initComponents();
        setSize(1370, 725);
        this.userAccount = account;
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.patient = (Patient) userAccount.getPerson();
        
        populatePatientDetails();
        findTopThreePatient();
        findTopThreeDoctors();
    }

    public void populatePatientDetails(){
        calculate = Calculate.getInstance();
        txtExercise.setText(String.valueOf(calculate.calculateExerciseGrade(patient)));
        txtDiet.setText(String.valueOf(calculate.calculateMealGrade(patient)));
        txtMedication.setText(String.valueOf(calculate.calculateMedicationGrade(patient)));
        txtVitals.setText(String.valueOf(calculate.calculateVitalsGrade(patient)));
        
        float overAllGrade = calculate.calculateOverAllGrade(patient);
        
        //int value = Integer.parseInt(String.valueOf(overAllGrade));
        int value = Math.round(overAllGrade);
        progressBar.setValue(value);
    }
    
    public void findTopThreePatient(){
        calculate = Calculate.getInstance();
        sortedList = new ArrayList<Patient>();
        for(Organization organization : organizationDirectory.getOrganizationList()){
            if(organization instanceof PatientOrganization){
                for(Person person : organization.getPersonDirectory().getPersonList()){
                    if(person instanceof Patient){
                        Patient p = (Patient)person;
                        sortedList.add(p);
                        
                    }
                }
            }
        }
        Collections.sort(sortedList);
        
        if(sortedList.size() == 1){
        txtPatient1.setText(sortedList.get(0).getName());
        }
        else if(sortedList.size() == 2){
        txtPatient1.setText(sortedList.get(0).getName());
        txtPatient2.setText(sortedList.get(1).getName());
        }
        else if(sortedList.size() >= 3){
        txtPatient1.setText(sortedList.get(0).getName());
        txtPatient2.setText(sortedList.get(1).getName());
        txtPatient3.setText(sortedList.get(2).getName());
        }
    }
    
    public void findTopThreeDoctors(){
        calculate = Calculate.getInstance();
        sortedListDoctor = new ArrayList<UserAccount>();
        for(Network network : business.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise instanceof HospitalEnterprise){
        for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(organization instanceof DoctorOrganization){
                for(UserAccount user : organization.getUserAccountDirectory().getUserAccountList()){
                    sortedListDoctor.add(user);
                }
            }
        }
        }
    }
}
        Collections.sort(sortedListDoctor);
        if(sortedList.size() == 1){
        txtDoctor1.setText(sortedListDoctor.get(0).getPerson().getName());
        }
        else if(sortedList.size() == 2){
        txtDoctor1.setText(sortedListDoctor.get(0).getPerson().getName());
        txtDoctor2.setText(sortedListDoctor.get(1).getPerson().getName());
        }
        else if(sortedList.size() >= 3){
        txtDoctor1.setText(sortedListDoctor.get(0).getPerson().getName());
        txtDoctor2.setText(sortedListDoctor.get(1).getPerson().getName());
        txtDoctor3.setText(sortedListDoctor.get(2).getPerson().getName());
        }
//        txtDoctor1.setText(sortedListDoctor.get(0).getName());
//        txtDoctor2.setText(sortedListDoctor.get(1).getName());
//        txtDoctor3.setText(sortedListDoctor.get(2).getName());
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
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDiet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMedication = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtExercise = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtVitals = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPatient1 = new javax.swing.JTextField();
        txtPatient2 = new javax.swing.JTextField();
        txtPatient3 = new javax.swing.JTextField();
        progressBar = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDoctor1 = new javax.swing.JTextField();
        txtDoctor2 = new javax.swing.JTextField();
        txtDoctor3 = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();

        jLabel1.setText("Welcome");

        jLabel2.setText("<value>");

        jLabel3.setText("Progress Dashboard");

        jLabel4.setText("Your Ratings :-");

        jLabel5.setText("Diet");

        txtDiet.setEnabled(false);

        jLabel6.setText("Medication");

        txtMedication.setEnabled(false);

        jLabel7.setText("Exercise");

        txtExercise.setEnabled(false);

        jLabel8.setText("Vitals");

        txtVitals.setEnabled(false);

        jLabel9.setText("Top three Patients according to the Ratings :-");

        txtPatient1.setEnabled(false);

        txtPatient2.setEnabled(false);
        txtPatient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatient2ActionPerformed(evt);
            }
        });

        txtPatient3.setEnabled(false);

        progressBar.setStringPainted(true);

        jLabel10.setText("Your Overall Progress");

        jLabel11.setText("Top three Doctors :-");

        txtDoctor1.setEnabled(false);

        txtDoctor2.setEnabled(false);
        txtDoctor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctor2ActionPerformed(evt);
            }
        });

        txtDoctor3.setEnabled(false);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnStatistics.setText("Statistics");
        btnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtDoctor3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPatient1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txtPatient2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPatient3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiet, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMedication, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(txtVitals, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txtDoctor2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStatistics)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtExercise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtVitals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatient3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoctor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoctor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnStatistics))
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatient2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatient2ActionPerformed

    private void txtDoctor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctor2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsActionPerformed
        // TODO add your handling code here:
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Float.parseFloat(txtExercise.getText()), "", "Exercise Grade");
        dataset.setValue(Float.parseFloat(txtDiet.getText().toString()), "", "Diet Grade");
        dataset.setValue(Float.parseFloat(txtMedication.getText()), "", "Medication Grade");
        dataset.setValue(Float.parseFloat(txtVitals.getText()), "", "Vitals Grade");

        JFreeChart chart = ChartFactory.createLineChart3D("Patient's Progress Report", "Grade", "", dataset, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Line Chart to depict Patient's Progress", chart);
        frame.setVisible(true);
        frame.setSize(450,350);
    }//GEN-LAST:event_btnStatisticsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField txtDiet;
    private javax.swing.JTextField txtDoctor1;
    private javax.swing.JTextField txtDoctor2;
    private javax.swing.JTextField txtDoctor3;
    private javax.swing.JTextField txtExercise;
    private javax.swing.JTextField txtMedication;
    private javax.swing.JTextField txtPatient1;
    private javax.swing.JTextField txtPatient2;
    private javax.swing.JTextField txtPatient3;
    private javax.swing.JTextField txtVitals;
    // End of variables declaration//GEN-END:variables
}
