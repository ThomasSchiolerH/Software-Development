package dtu.gui;
import dtu.employees.Developer;
import dtu.softwarehus.SoftwareHuset;

import javax.swing.*;
import java.awt.event.*;

//create CreateLoginForm class to create login form
//class extends JFrame to create a window where our component add
//class implements ActionListener to perform an action on button click
public class manageProjectPage {
    //initialize button, panel, label, and text field
    JButton b1;
    JPanel createProjectPanel;
    JLabel userLabel,userLabel2,userLabel3,userLabel4;
    JTextField startDate,endDate,projectManager,budget1;
    private JPanel panel1;
    private JCheckBox checkBox1;
    boolean managerCheckBox = false;
    boolean b;
    SoftwareHuset softwareHuset;
    Main parentWindow;
    Developer user;

    //calling constructor
    public manageProjectPage(SoftwareHuset softwareHuset, Main parentWindow) {
        this.softwareHuset = softwareHuset;
        this.parentWindow = parentWindow;
        initialize();
    }
    public void initialize(){
        createProjectPanel = new JPanel();
        parentWindow.addPanel(createProjectPanel);
        createProjectPanel.setLayout(null);


        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Change Start date");      //set label value for textField1
        userLabel.setBounds(25, 50, 193, 29);

        userLabel2 = new JLabel();
        userLabel2.setText("Change End date");
        userLabel2.setBounds(25, 100, 193, 29);

        userLabel3 = new JLabel();
        userLabel3.setText("Change Budget");
        userLabel3.setBounds(25, 150, 193, 29);

        userLabel4 = new JLabel();
        userLabel4.setText("Assign project manager");
        userLabel4.setBounds(25, 200, 193, 29);

        //create text field to get username from the user
        startDate = new JTextField(15); //set length of the text
        startDate.setBounds(250, 50, 193, 29);

        //create text field to get username from the user
        endDate = new JTextField(15);
        endDate.setBounds(250, 100, 193, 29);

        budget1 = new JTextField(15);
        budget1.setBounds(250, 150, 193, 29);
        //create submit button

        projectManager = new JTextField(15);
        projectManager.setBounds(250, 200, 193, 29);
        //create submit button
        b1 = new JButton("Save"); //set label to button
        b1.setBounds(150, 300, 193, 29);


        createProjectPanel.setLayout(null);
        createProjectPanel.add(startDate);    //set username label to panel
        createProjectPanel.add(endDate);   //set text field to panel
        createProjectPanel.add(projectManager);
        createProjectPanel.add(budget1);
        createProjectPanel.add(userLabel);
        createProjectPanel.add(userLabel2);
        createProjectPanel.add(userLabel3);
        createProjectPanel.add(userLabel4);
        createProjectPanel.add(b1);



        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startWeek = startDate.getText();        //get user entered username from the textField1
                String endWeek = endDate.getText();
                String budget = budget1.getText();
                String projectManager1 = projectManager.getText();
                String name = "New project";

                int project = SoftwareHuset.createProject(Integer.parseInt(startWeek),Integer.parseInt(endWeek),Integer.parseInt(budget));
                if(!projectManager1.isEmpty()) {
                    SoftwareHuset.assignPM(projectManager1, project);
                }

                // CreateLoginForm pmPage = new CreateLoginForm();
                //make page visible to the user

                setVisible(false);
                clear();
                parentWindow.setVisible(true);
                //pmPage.setLocationRelativeTo(null);
                // pmPage.setVisible(true);


            }
        });

    }
    public void setVisible(boolean visi){
        createProjectPanel.setVisible(visi);
    }
    public void clear() {
        startDate.setText("");
        endDate.setText("");
        projectManager.setText("");
        budget1.setText("");

    }
}