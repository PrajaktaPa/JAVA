/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.meals;

import business.meals.Meal;
import business.organization.OrganizationDirectory;
import business.patient.Patient;
import business.userAccount.UserAccount;
import calculations.Validations;
import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prajakta
 */
public class ViewMealsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private UserAccount userAccount;
    private Patient patient;
    private Vector foodList;
    Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
    double totalCalorieIntake=0;
    /**
     * Creates new form ViewMealsJPanel
     */
    public ViewMealsJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory,UserAccount account) {
        initComponents();
        setSize(1370, 725);
        this.userAccount = account;
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.patient = (Patient) userAccount.getPerson();
        foodList = new Vector(30);
        
        
        Date date = new Date();
        
        calendar.setTime(date);   // assigns calendar to given date 
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        int minute = calendar.get(Calendar.MINUTE);
        
        txtMealHour.setText(String.valueOf(hour)+":"+String.valueOf(minute));
        
        if(hour <9){
            radio1.setSelected(true);
        }
        else if(hour>9 && hour < 14){
            radio2.setSelected(true);
        }
        else if(hour>14 && hour <23){
            radio3.setSelected(true);
        }
        populateMealsTable();
    }

    public void populateMealsTable(){
        DefaultTableModel model = (DefaultTableModel) tblMeals.getModel();
         model.setRowCount(0);
         Calendar calendar1 = Calendar.getInstance();
         Calendar calendar2 = Calendar.getInstance();
         Date dateCurrent = new Date();
         calendar2.setTime(dateCurrent);
         calendar2.set(Calendar.HOUR, 0);
         calendar2.set(Calendar.MINUTE, 0);
         calendar2.set(Calendar.SECOND, 0);
         calendar2.set(Calendar.MILLISECOND, 0);
         calendar2.set(Calendar.AM_PM,0);
        for (Meal meals : patient.getMealDirectory().getMealList()){
            Date mealDate = meals.getMealTime();
            if(mealDate != null){
            calendar1.setTime(mealDate);
            }
            else{
                calendar1.setTime(new Date());
            }
            calendar1.set(Calendar.HOUR, 0);
            calendar1.set(Calendar.MINUTE, 0);
            calendar1.set(Calendar.SECOND, 0);
            calendar1.set(Calendar.MILLISECOND, 0);
            calendar1.set(Calendar.AM_PM,0);
            if(calendar1.compareTo(calendar2)==0){
            Object[] row = new Object[4];
            row[0] = meals;
            row[1] = meals.getMealTime();
            row[2] = meals.getCalorieIntake();
            model.addRow(row);
            }
        }
    }
    
    public void calculateCalorieIntake(){
        int size = list2.getModel().getSize();
            for(int i=0;i<size;i++){
                foodList.addElement(list2.getModel().getElementAt(i));
            }
        for(int i =0 ; i<foodList.size();i++){
            String a = foodList.elementAt(i).toString();
            
            if(a.equals("Cerels")){
                totalCalorieIntake = 80+totalCalorieIntake;
            }
            else if(a.equals("Eggs")){
                totalCalorieIntake = 150+totalCalorieIntake;
            }
            else if(a.equals("Bagel")){
                totalCalorieIntake = 350+totalCalorieIntake;
            }
            else if(a.equals("Bread")){
                totalCalorieIntake = 80+totalCalorieIntake;
            }
            else if(a.equals("Cheese")){
                totalCalorieIntake = 110+totalCalorieIntake;
            }
            else if(a.equals("Coffee")){
                totalCalorieIntake = 250+totalCalorieIntake;
            }
            else if(a.equals("Pickle")){
                totalCalorieIntake = 20+totalCalorieIntake;
            }
            else if(a.equals("Mayonnaise")){
                totalCalorieIntake = 100+totalCalorieIntake;
            }
            else if(a.equals("Yogurt")){
                totalCalorieIntake = 140+totalCalorieIntake;
            }
            else if(a.equals("Cerels")){
                totalCalorieIntake = 70+totalCalorieIntake;
            }
            else if(a.equals("Butter")){
                totalCalorieIntake = 200+totalCalorieIntake;
            }
            else if(a.equals("Peanut Butter")){
                totalCalorieIntake = 200+totalCalorieIntake;
            }
            else if(a.equals("Potatos")){
                totalCalorieIntake = 50+totalCalorieIntake;
            }
            else if(a.equals("Rice")){
                totalCalorieIntake = 180+totalCalorieIntake;
            }
            else if(a.equals("Wheat")){
                totalCalorieIntake = 400+totalCalorieIntake;
            }
            else if(a.equals("Juice")){
                totalCalorieIntake = 80+totalCalorieIntake;
            }
            else if(a.equals("Banana")){
                totalCalorieIntake = 100+totalCalorieIntake;
            }
            else if(a.equals("Lime")){
                totalCalorieIntake = 20+totalCalorieIntake;
            }
            else if(a.equals("Herbs")){
                totalCalorieIntake = 10+totalCalorieIntake;
            }
            else if(a.equals("Spices")){
                totalCalorieIntake = 20+totalCalorieIntake;
            }
            else if(a.equals("Lamb")){
                totalCalorieIntake = 300+totalCalorieIntake;
            }
            else if(a.equals("Beef")){
                totalCalorieIntake = 350+totalCalorieIntake;
            }
            else if(a.equals("Meat")){
                totalCalorieIntake = 250+totalCalorieIntake;
            }
            else if(a.equals("Nuts")){
                totalCalorieIntake = 30+totalCalorieIntake;
            }
            else if(a.equals("Noodles")){
                totalCalorieIntake = 200+totalCalorieIntake;
            }
            else if(a.equals("Pork")){
                totalCalorieIntake = 400+totalCalorieIntake;
            }
            else if(a.equals("Seafood")){
                totalCalorieIntake = 90+totalCalorieIntake;
            }
            else if(a.equals("Snacks")){
                totalCalorieIntake = 260+totalCalorieIntake;
            }
            else if(a.equals("Sugar")){
                totalCalorieIntake = 120+totalCalorieIntake;
            }
            else if(a.equals("Artichoke")){
                totalCalorieIntake = 60+totalCalorieIntake;
            }
            else if(a.equals("Vegetables")){
                totalCalorieIntake = 100+totalCalorieIntake;
            }
            else if(a.equals("Sprouts")){
                totalCalorieIntake = 40+totalCalorieIntake;
            }
            else if(a.equals("Tomato")){
                totalCalorieIntake = 40+totalCalorieIntake;
            }
        }
        txtCalorieIntake.setText(String.valueOf(totalCalorieIntake));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblMealTracker = new javax.swing.JLabel();
        lblMealType = new javax.swing.JLabel();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        radio3 = new javax.swing.JRadioButton();
        lblMealTime = new javax.swing.JLabel();
        txtMealHour = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList();
        btnFillRight = new javax.swing.JButton();
        btnFillLeft = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtCalorieIntake = new javax.swing.JTextField();
        lblCalorieIntake = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMeals = new javax.swing.JTable();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnMealHistory = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        lblMealTracker.setText("Meals Tracker");

        lblMealType.setText("Meal Type");

        buttonGroup1.add(radio1);
        radio1.setText("Breakfast");

        buttonGroup1.add(radio2);
        radio2.setText("Lunch");

        buttonGroup1.add(radio3);
        radio3.setText("Dinner");

        lblMealTime.setText("Meal Time :-");

        list1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Cerels", "Eggs", "Bagel", "Bread", "Cheese", "Coffee", "Pickle", "Mayonnaise", "Yogurt", "Cerels", "Butter", "Peanut Butter", "Potatos", "Rice", "Wheat", "Juice", "Banana", "Lime", "Herbs", "Spices", "Lamb", "Beef", "Meat", "Nuts", "Noodles", "Pork", "Seafood", "Snacks", "Sugar", "Artichoke", "Vegetables", "Sprouts", "Tomato" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(list1);

        btnFillRight.setText(">>");
        btnFillRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillRightActionPerformed(evt);
            }
        });

        btnFillLeft.setText("<<");
        btnFillLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillLeftActionPerformed(evt);
            }
        });

        list2.setModel(new DefaultListModel());
        list2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(list2);

        jLabel1.setText("Hour of the day");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblCalorieIntake.setText("Calorie Intake");

        tblMeals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Meal Type", "Meal Time", "Calorie Intake"
            }
        ));
        jScrollPane3.setViewportView(tblMeals);

        jLabel2.setText("Date");

        btnMealHistory.setText("View Meal History");
        btnMealHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMealHistoryActionPerformed(evt);
            }
        });

        jLabel3.setText("Welcome");

        jLabel4.setText("Diet Dashboard");

        jLabel5.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel5)
                                .addGap(289, 289, 289)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(199, 199, 199)
                                .addComponent(btnMealHistory)
                                .addGap(173, 173, 173)
                                .addComponent(btnSave))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMealTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblMealType)
                                                .addGap(18, 18, 18)
                                                .addComponent(radio1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radio2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radio3))
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(84, 84, 84)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMealHour, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCalorieIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lblCalorieIntake))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFillRight)
                                    .addComponent(btnFillLeft))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(547, 547, 547))))
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(lblMealTracker)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblMealTracker)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFillRight)
                                .addGap(61, 61, 61)
                                .addComponent(btnFillLeft)
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMealType)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(radio1)
                                        .addComponent(radio2)
                                        .addComponent(radio3)))
                                .addGap(18, 18, 18)
                                .addComponent(lblMealTime)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMealHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCalorieIntake)
                                    .addComponent(txtCalorieIntake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnMealHistory)
                    .addComponent(btnSave))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFillRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillRightActionPerformed
        // TODO add your handling code here:
        int [] i = new int[30];
        
        i = list1.getSelectedIndices();
        DefaultListModel model2 =  new DefaultListModel();
        DefaultListModel model1 =  new DefaultListModel();

        if(list1.getModel()!=null && list1.getModel().getSize()>0)
        {
          for(int x=0;x<list1.getModel().getSize();x++)
          {
              model1.addElement(list1.getModel().getElementAt(x));
          }
        }
        list1.setModel(model1);
        
        if(list2.getModel()!=null && list2.getModel().getSize()>0)
        {
          for(int x=0;x<list2.getModel().getSize();x++)
          {
              model2.addElement(list2.getModel().getElementAt(x));
          }
        }
        
        for (int pos:i)
        {
            model2.addElement(model1.getElementAt(pos));
            //model1.removeElementAt(pos);
        }
        int newpos = 0;
          for (int pos:i)
        {
            model1.removeElementAt(pos-newpos);
            newpos++;
        }
        list2.setModel(model2);
        totalCalorieIntake=0;
        foodList.removeAll(foodList);
        calculateCalorieIntake();
    }//GEN-LAST:event_btnFillRightActionPerformed

    private void btnFillLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillLeftActionPerformed
        // TODO add your handling code here:
         /*DefaultListModel model = (DefaultListModel)list1.getModel();
        DefaultListModel model2 = (DefaultListModel)list2.getModel();
        model.addElement(list2.getSelectedValue());
        model2.removeElement(list2.getSelectedValue());
       list1.setModel(model);*/
        
        int [] i = new int[30];
        
        i = list2.getSelectedIndices();
        DefaultListModel model2 =  new DefaultListModel();
        DefaultListModel model1 =  new DefaultListModel();

        if(list2.getModel()!=null && list2.getModel().getSize()>0)
        {
            int list1Size = list2.getModel().getSize();
          for(int x=0;x<list1Size;x++)
          {
              model1.addElement(list2.getModel().getElementAt(x));
          }
        }
        list2.setModel(model1);
        
        if(list1.getModel()!=null && list1.getModel().getSize()>0)
        {
          for(int x=0;x<list1.getModel().getSize();x++)
          {
              model2.addElement(list1.getModel().getElementAt(x));
          }
        }
        
        for (int pos:i)
        {
            model2.addElement(model1.getElementAt(pos));
            //model1.removeElementAt(pos);
        }
          for (int pos:i)
        {
            model1.removeElementAt(pos);
        }
        list1.setModel(model2);
        totalCalorieIntake=0;
        foodList.removeAll(foodList);
        calculateCalorieIntake();
    }//GEN-LAST:event_btnFillLeftActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Validations validateVitals = new Validations();
        Meal meal;
        String time = txtMealHour.getText();
        Date date = dateChooser.getDate();
        if(date==null)
        {
            JOptionPane.showMessageDialog(null,"Enter correct Date","",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(validateVitals.validateHoursMins(time)){
            cal.set(Calendar.HOUR_OF_DAY,Integer.valueOf(time.substring(0, time.indexOf(":"))));
            cal.set(Calendar.MINUTE,Integer.valueOf(time.substring(time.indexOf(":")+1)));
            meal = patient.getMealDirectory().addMeal();
            meal.setMealTime(cal.getTime());
        }
        else{
            JOptionPane.showMessageDialog(null,"Enter correct time (HH:mm)","",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String mealType;
        if(radio1.isSelected())
        {
            mealType = "Breafast";
            meal.setMealtype(mealType);
        }
        else if(radio2.isSelected())
        {
            mealType = "Lunch";
            meal.setMealtype(mealType);
        }
        else if(radio3.isSelected())
        {
            mealType = "Dinner";
            meal.setMealtype(mealType);
        }
        meal.setCalorieIntake(totalCalorieIntake);
        if(list2.equals(null) || txtCalorieIntake.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select food from the list provided","",  JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Meal saved Successfully", "Created Successfully", JOptionPane.INFORMATION_MESSAGE);
        list2.clearSelection();
        
        if(meal.getMealTime() != null){
        populateMealsTable();
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void list1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list1KeyPressed
        // TODO add your handling code here:
        calculateCalorieIntake();
    }//GEN-LAST:event_list1KeyPressed

    private void list2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list2KeyPressed
        // TODO add your handling code here:
        calculateCalorieIntake();
    }//GEN-LAST:event_list2KeyPressed

    private void btnMealHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMealHistoryActionPerformed
        // TODO add your handling code here:
        MealHistoryJPanel mealHistoryJPanel = new MealHistoryJPanel(userProcessContainer, organizationDirectory, userAccount);
        userProcessContainer.add("mealHistoryJPanel", mealHistoryJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMealHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFillLeft;
    private javax.swing.JButton btnFillRight;
    private javax.swing.JButton btnMealHistory;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCalorieIntake;
    private javax.swing.JLabel lblMealTime;
    private javax.swing.JLabel lblMealTracker;
    private javax.swing.JLabel lblMealType;
    private javax.swing.JList list1;
    private javax.swing.JList list2;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JRadioButton radio3;
    private javax.swing.JTable tblMeals;
    private javax.swing.JTextField txtCalorieIntake;
    private javax.swing.JTextField txtMealHour;
    // End of variables declaration//GEN-END:variables
}
