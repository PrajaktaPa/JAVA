/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.administration;

import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.enterprise.PatientTrackerEnterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userInterface.patient.ManagePatientJPanel;
import userInterface.person.ManagePersonJPanel;

/**
 *
 * @author Prajakta
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Enterprise enterprise;
    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public AdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        setSize(1375, 750);
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        lblEntValue.setText(enterprise.getName());
        
        if(enterprise instanceof PatientTrackerEnterprise){
            btnManageEmp.setEnabled(false);
        }
        else if(enterprise instanceof HospitalEnterprise){
            btnManagePatient.setEnabled(false);
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

        lblEnt = new javax.swing.JLabel();
        lblEntValue = new javax.swing.JLabel();
        btnManageOrg = new javax.swing.JButton();
        btnManageEmp = new javax.swing.JButton();
        btnManageUser = new javax.swing.JButton();
        btnManagePatient = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();

        lblEnt.setText("Enterprise");

        lblEntValue.setText("<value>");

        btnManageOrg.setText("Manage Organization");
        btnManageOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrgActionPerformed(evt);
            }
        });

        btnManageEmp.setText("Manage Employee");
        btnManageEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmpActionPerformed(evt);
            }
        });

        btnManageUser.setText("Manage User");
        btnManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUserActionPerformed(evt);
            }
        });

        btnManagePatient.setText("Manage Patient");
        btnManagePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePatientActionPerformed(evt);
            }
        });

        jLabel5.setText("Welcome");

        jLabel6.setText("Enterprise Dashboard");

        jLabel7.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnManageEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnManageOrg)
                                    .addComponent(btnManagePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEnt)
                                        .addGap(44, 44, 44)
                                        .addComponent(lblEntValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEntValue)
                    .addComponent(lblEnt))
                .addGap(18, 18, 18)
                .addComponent(btnManageOrg)
                .addGap(34, 34, 34)
                .addComponent(btnManageEmp)
                .addGap(33, 33, 33)
                .addComponent(btnManagePatient)
                .addGap(31, 31, 31)
                .addComponent(btnManageUser)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUserActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageUserActionPerformed

    private void btnManageEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmpActionPerformed
        // TODO add your handling code here:
        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),enterprise);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnManageEmpActionPerformed

    private void btnManageOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrgActionPerformed
        // TODO add your handling code here:
        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),enterprise);
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageOrgActionPerformed

    private void btnManagePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePatientActionPerformed
        // TODO add your handling code here:
        ManagePatientJPanel managePatientJPanel = new ManagePatientJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("managePatientJPanel", managePatientJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManagePatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageEmp;
    private javax.swing.JButton btnManageOrg;
    private javax.swing.JButton btnManagePatient;
    private javax.swing.JButton btnManageUser;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEnt;
    private javax.swing.JLabel lblEntValue;
    // End of variables declaration//GEN-END:variables
}
