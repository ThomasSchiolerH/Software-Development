package dtu.gui;
import dtu.project.Activity;
import dtu.project.Project;
import dtu.softwarehus.SoftwareHuset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

// lavet af Victor Larsen-Saldeen

public class CreateActivityPage {
    JButton saveBtn;
    JPanel createProjectPanel;
    JLabel startDateLabel, endDateLabel, budgetLabel, projectLabel, activityNameLabel, estTimeLabel;
    JTextField startDateTxtField, endDateTxtField, estTimeTxtField, projectTxtField, nameTxtField, budgetTxtField;
    SoftwareHuset softwareHuset;
    Main parentWindow;
    JComboBox<Month> monthSelStart, monthSelFin;
    JComboBox<Integer> yearSelStart, yearSelFin,startDate,endDate;
    String originWindow;
    int year,dates;
    private JFrame frame;

    public CreateActivityPage(SoftwareHuset softwareHuset, Main parentWindow) {
        this.softwareHuset = softwareHuset;
        this.parentWindow = parentWindow;
        initialize();
    }
    public void initialize(){
     createPage();

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                clear();
                if (originWindow.equals("ProjectManagerPage")){
                    ProjectManagerPage.setVisible(true);
                }else{
                    DeveloperPage.setVisible(true);
                }

            }
        });
        btnBack.setBounds(21, 350, 59, 29);
        createProjectPanel.add(btnBack);

        //adding labels to screen
        addLabelsToScreen();

        //adding textfields to screen
        addTextFieldsToScreen();

        //create save button
        saveBtn = new JButton("Save"); //set label to button
        saveBtn.setBounds(150, 350, 193, 29);
        createProjectPanel.add(saveBtn);

        saveBtn.addActionListener(e -> {
            /* gamle
            //date intervals
            GregorianCalendar startDate = new GregorianCalendar(yearSelStart.getItemAt(yearSelStart.getSelectedIndex()),
                    monthSelStart.getSelectedIndex(),Integer.parseInt(startDateTxtField.getText()));

            GregorianCalendar endDate = new GregorianCalendar(yearSelFin.getItemAt(yearSelFin.getSelectedIndex()),
                    monthSelFin.getSelectedIndex(),Integer.parseInt(endDateTxtField.getText()));

            //making activity
            Activity newActivity = new Activity(nameTxtField.getText(), Integer.parseInt(estTimeTxtField.getText()));
            newActivity.setDateInterval(startDate, endDate);
            newActivity.setBudget(Integer.parseInt(budgetTxtField.getText()));

            //adding to project
            Project projectToAddTo = SoftwareHuset.projects.get(Integer.parseInt(projectTxtField.getText()));
            projectToAddTo.addActivity(newActivity);*/
            String projectID = projectTxtField.getText();
            String actName = nameTxtField.getText();
            String budget = budgetTxtField.getText();
            String estimatedTime = estTimeTxtField.getText();
            String timeUsed = "0.0";

            String startYear = String.valueOf(yearSelStart.getItemAt(yearSelStart.getSelectedIndex()));
            String startMonth = String.valueOf(monthSelStart.getSelectedIndex());
            String startDay = startDateTxtField.getText();

            String endYear = String.valueOf(yearSelFin.getItemAt(yearSelFin.getSelectedIndex()));
            String endMonth = String.valueOf(monthSelFin.getSelectedIndex());
            String endDay = endDateTxtField.getText();


            String[] activityValues = new String[] {projectID, actName, startYear, startMonth, startDay,
                endYear,endMonth, endDay, estimatedTime, timeUsed, budget};

            Project projectToAddTo = SoftwareHuset.projects.get(Integer.parseInt(projectTxtField.getText()));

            SoftwareHuset.addProjectActivities(projectToAddTo, activityValues);

        setVisible(false);
        clear();
        DeveloperPage.setVisible(true);

        });

    }
    private void createPage() {
        createProjectPanel = new JPanel();
        parentWindow.addPanel(createProjectPanel);
        createProjectPanel .setLayout(null);
        createProjectPanel .setBorder(BorderFactory.createTitledBorder("Create activity page"));
    }
    
    public void setVisible(boolean visi){
        createProjectPanel.setVisible(visi);
    }

    public void setOriginWindow(String window){
        originWindow = window;
    }

    private void clear() {
        nameTxtField.setText("");
        startDate.setSelectedIndex(0);
        endDate.setSelectedIndex(0);
        projectTxtField.setText("");
        estTimeTxtField.setText("");
        budgetTxtField.setText("");
        monthSelStart.setSelectedIndex(0);
        monthSelFin.setSelectedIndex(0);
        yearSelStart.setSelectedItem(year);
        yearSelFin.setSelectedItem(year);
    }

    private void addLabelsToScreen(){
        activityNameLabel = new JLabel();
        activityNameLabel.setText("Activity name");
        activityNameLabel.setBounds(25, 50, 193, 29);

        startDateLabel = new JLabel();
        startDateLabel.setText("Activity start date");
        startDateLabel.setBounds(25, 100, 193, 29);

        endDateLabel = new JLabel();
        endDateLabel.setText("Activity end date");
        endDateLabel.setBounds(25, 150, 193, 29);

        estTimeLabel = new JLabel();
        estTimeLabel.setText("Estimated time");
        estTimeLabel.setBounds(25, 200, 193, 29);

        budgetLabel = new JLabel();
        budgetLabel.setText("Budget");
        budgetLabel.setBounds(25, 250, 193, 29);

        projectLabel = new JLabel();
        projectLabel.setText("Assign to project");
        projectLabel.setBounds(25, 300, 193, 29);

        createProjectPanel.add(startDateLabel);
        createProjectPanel.add(endDateLabel);
        createProjectPanel.add(budgetLabel);
        createProjectPanel.add(projectLabel);
        createProjectPanel.add(activityNameLabel);
        createProjectPanel.add(estTimeLabel);
    }
    private Vector getDates() {
        dates = 1;
        Vector d = new Vector();
        for (int i = dates; i <= 31; i++) {
            d.add(i);
        }
        return d;
    }

    private void addTextFieldsToScreen(){
        Vector v = getYears();

        nameTxtField = new JTextField(15);
        nameTxtField.setBounds(250, 50, 193, 29);

        startDate= new JComboBox<Integer>(getDates());
        startDate.setSelectedItem(dates);
        startDate.setBounds(200, 100, 45, 29);

        monthSelStart = new JComboBox<>(Month.values());
        monthSelStart.setBounds(250,100,110,29);

        yearSelStart = new JComboBox<Integer>(v);
        yearSelStart.setSelectedItem(year);
        yearSelStart.setBounds(355,100,90,29);

        endDate = new JComboBox<Integer>(getDates());
        endDate.setSelectedItem(dates);
        endDate.setBounds(200, 150, 45, 29);


        monthSelFin = new JComboBox<>(Month.values());
        monthSelFin.setBounds(250,150,110,29);

        yearSelFin = new JComboBox<Integer>(v);
        yearSelFin.setSelectedItem(year);
        yearSelFin.setBounds(355,150,90,29);

        estTimeTxtField = new JTextField(15);
        estTimeTxtField.setBounds(250, 200, 193, 29);

        budgetTxtField = new JTextField(15);
        budgetTxtField.setBounds(250, 250, 193, 29);

        projectTxtField = new JTextField(15);
        projectTxtField.setBounds(250, 300, 193, 29);

        createProjectPanel.add(startDate);
        createProjectPanel.add(endDate);
        createProjectPanel.add(projectTxtField);
        createProjectPanel.add(estTimeTxtField);
        createProjectPanel.add(nameTxtField);
        createProjectPanel.add(budgetTxtField);
        createProjectPanel.add(monthSelStart);
        createProjectPanel.add(yearSelStart);
        createProjectPanel.add(yearSelFin);
        createProjectPanel.add(monthSelFin);
    }

    private Vector getYears() {
        Calendar now = Calendar.getInstance();
        year = now.get(Calendar.YEAR);
        Vector v = new Vector();
        for (int i = year; i <= 2030; i++) {
            v.add(i);
        }
        return v;
    }





}