import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Administrator class contains Administrator model, view, controller class
 * It handles administrator menu , create account for user, view project 
 * , manange project and comment project
 */
public class Administrator extends User {

    /*
     * Class represents Administrator model to handle administrator info
     */
    public class AdministratorM extends UserM {

        /*Lim Wen Jie \
         * constructor
        */
        public AdministratorM(String userName, String password) {
            super(userName, password);

        }

    }

    /*
     * Class represents Administrator View which has administrator menu view, add
     * user view, comment view, manage project view and has implement viewboard
     */
    public class AdministratorV implements Viewboard {

        private JButton menuBtn1, menuBtn2, menuBtn3, menuBtn4, addUserBtn, cbutton, addButton, delButton;
        private TextField newuserName, newPw, comment;
        private String role;
        private TextField projidM, title, lecid, date, stuid;
        private JLabel validateLabel, label4, label2;
        private JComboBox<String> newrole, newSpc, filter, subfilter, projid, status, spcM;

        private JPanel panel3 = new JPanel();
        private JFrame frame1 = new JFrame();

        /*Lim Wen Jie 
        *
        * Build up of admistrator menu
        */
        public void menu() {

            JFrame frame = new JFrame();
            JPanel panel2 = new JPanel();

            frame.setTitle("Admistrator Menu");
            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(310, 290);

            panel2.setLayout(null);

            menuBtn1 = new JButton("Add account");
            menuBtn1.setBounds(80, 30, 140, 30);
            panel2.add(menuBtn1);

            menuBtn2 = new JButton("View project");
            menuBtn2.setBounds(80, 70, 140, 30);
            panel2.add(menuBtn2);

            menuBtn3 = new JButton("Leave comment");
            menuBtn3.setBounds(80, 110, 140, 30);
            panel2.add(menuBtn3);

            menuBtn4 = new JButton("Add/delete project");
            menuBtn4.setBounds(80, 150, 140, 30);
            panel2.add(menuBtn4);

            frame.setLocationRelativeTo(null);
            frame.add(panel2);
            frame.setVisible(true);

        }

        /*
         * Let the Admin controller class to handle it when menuBtn1 is clicked
         * Lim Wen Jie 
         */
        public void addMenuListener(ActionListener callAddUserListener) {

            menuBtn1.addActionListener(callAddUserListener);

        }

        /*Lim Wen Jie 
        * Let the Admin controller class to handle it when menuBtn2 is clicked
        */
        public void addMenu2Listener(ActionListener viewlistListener) {

            menuBtn2.addActionListener(viewlistListener);

        }

        /*Lim Wen Jie 
        *Let the Admin controller class to handle it when menuBtn3 is clicked
        */
        public void addMenu3Listener(ActionListener commentmenuListener) {

            menuBtn3.addActionListener(commentmenuListener);

        }

        /*Lim Wen Jie 
        * Let the Admin controller class to handle it when menuBtn4 is clicked
        */
        public void addMenu4Listener(ActionListener menu4Listener) {

            menuBtn4.addActionListener(menu4Listener);

        }

        /*Lim Wen Jie 
         * Bulid up of AddAccount use case menu
        */
        public void addUser() {

            frame1.setTitle("Add User");

            panel3.setLayout(null);
            frame1.setSize(320, 250);

            JLabel label1 = new JLabel("Role: ");
            label1.setBounds(10, 20, 80, 20);

            JLabel label2 = new JLabel("ID: ");
            label2.setBounds(10, 50, 80, 20);

            JLabel label3 = new JLabel("Password: ");
            label3.setBounds(10, 80, 80, 20);

            String[] choice = { "Administrator", "Lecturer", "Student" };
            newrole = new JComboBox<String>(choice);
            newrole.setBounds(100, 20, 165, 20);
            newrole.setSelectedIndex(0);

            newuserName = new TextField();
            newuserName.setBounds(100, 50, 165, 20);

            newPw = new TextField();
            newPw.setBounds(100, 80, 165, 20);

            label4 = new JLabel("Specialization: ");
            label4.setBounds(10, 110, 90, 20);

            String[] spcChoice = { "software engineering", "data science", "game development", "cybersecurity" };
            newSpc = new JComboBox<String>(spcChoice);
            newSpc.setBounds(100, 110, 165, 20);

            addUserBtn = new JButton("Add");
            addUserBtn.setBounds(195, 135, 70, 20);

            validateLabel = new JLabel();
            validateLabel.setBounds(10, 145, 300, 50);

            panel3.add(label1);
            panel3.add(label2);
            panel3.add(label3);
            panel3.add(label4);
            panel3.add(newrole);
            panel3.add(newuserName);
            panel3.add(newPw);
            panel3.add(newSpc);
            panel3.add(addUserBtn);

            panel3.add(validateLabel);

            newSpc.setVisible(false);
            label4.setVisible(false);
            frame1.setLocationRelativeTo(null);
            frame1.add(panel3);
            frame1.setVisible(true);

        }

        /*Lim Wen Jie 
         * getter
        */
        public String getNewUserName() {

            return newuserName.getText();
        }

        /*Lim Wen Jie 
         * getter
        */
        public String getNewPw() {

            return newPw.getText();
        }

        /*Lim Wen Jie 
         * getter
        */
        public TextField getNewIDFld() {

            return newuserName;
        }

        /*Lim Wen Jie 
         * getter
        */
        public TextField getNewPwFld() {

            return newPw;
        }
        /*Lim Wen Jie 
         * getter
        */
        public String getNewRole() {
            return role;
        }

        /*Lim Wen Jie 
         * To  handle the choice of   admin
        */
        public void addChoiceListener(ActionListener selectChoiceListener) {

            newrole.addActionListener(selectChoiceListener);

        }

        /*Lim Wen Jie 
         * To handle choice of admin
        */
        public void addSpcListener(ActionListener selectSpcListener) {

            newSpc.addActionListener(selectSpcListener);

        }

        /*Lim Wen Jie 
         * To handle the "Add" button
        */
        public void addUserListener(ActionListener adduserListener) {

            addUserBtn.addActionListener(adduserListener);

        }

        /*
         * Receive error message from Admin controller class and display it
         * Lim Wen Jie 
         */
        public void displayErrorMessage(String errorMessage) {

            validateLabel.setText(errorMessage);
        }

        /*
         * Receive success message from Admin controller class and display it
         * Lim Wen Jie
         */
        public void displaySuccessMessage(String successsMessage) {
            validateLabel.setText(successsMessage);

        }

        /*Estellyn Hoo Weay 
         * Build of ViewProject use case  menu
        */
        public void adminViewProject() {

            JFrame frame = new JFrame("Administrator Viewboard");
            JPanel panel = new JPanel();
            panel.setLayout(null);
            String[] array = { "all", "specialization", "lecture ID", "active", "inactive", "assigned",
                    "unassigned",
                    "commented" };
            filter = new JComboBox<String>(array);
            filter.setBounds(350, 80, 120, 20);

            JLabel label = new JLabel("Please select that you wish to apply :");
            label.setBounds(100, 80, 250, 20);

            panel.add(label);
            panel.add(filter);
            frame.add(panel);
            frame.setLocation(500, 200);
            frame.setSize(550, 330);
            frame.setVisible(true);
        }

        /*Estellyn Hoo Weay 
         * To handle the choice  of admin
        */
        public void addFilterListener(ActionListener filterListener) {

            filter.addActionListener(filterListener);

        }

        /*Estellyn Hoo Weay
         * Build of ViewProject use case  menu only when apply filter  Specialization and  Lecturer ID
         */
        public void adminViewProject2(List<Project> projects, String choice) {

            JFrame frame = new JFrame("Administrator Viewboard");
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            JLabel label = new JLabel("Please select that you wish to apply :");
            label.setBounds(80, 80, 220, 20);

            subfilter = new JComboBox<String>();

            if (choice.equals("specialization")) {
                String[] SpecArr = { "data science", "cybersecurity", "software engineering", "game development" };
                subfilter = new JComboBox<String>(SpecArr);

            }

            else if (choice.equals("lecture ID")) {

                String[] LecArr = new String[projects.size()];
                for (int i = 0; i < projects.size(); i++) {
                    LecArr[i] = projects.get(i).getLecID();
                }

                subfilter = new JComboBox<String>(LecArr);

            }
            subfilter.setBounds(300, 80, 130, 20);
            panel1.add(label);
            panel1.add(subfilter);
            frame.add(panel1);
            frame.setLocation(500, 200);
            frame.setSize(550, 330);
            frame.setVisible(true);
        }

         /*Estellyn Hoo Weay 
          * To handle the choice of  admin
         */
        public void addShowList2Listener(ActionListener selectViewList2Listener) {

            subfilter.addActionListener(selectViewList2Listener);

        }

         /*Estellyn Hoo Weay 
          * To generate project list for ViewProject
         */
        @Override
        public void viewList(List<Project> list) {

            JFrame frame = new JFrame("Viewboard");
            frame.setSize(1600, 400);
            JPanel panel = new JPanel(new BorderLayout());

            int row = list.size();
            JTable table = new JTable(row + 1, 8);
            table.setValueAt("Project ID", 0, 0);
            table.setValueAt("Title", 0, 1);
            table.setValueAt("Lecturer ID", 0, 2);
            table.setValueAt("Specialization", 0, 3);
            table.setValueAt("Date", 0, 4);
            table.setValueAt("Student ID", 0, 5);
            table.setValueAt("Status", 0, 6);
            table.setValueAt("Comment", 0, 7);

            for (int i = 1; i <= list.size(); i++) {
                table.setValueAt(list.get(i - 1).getProjID(), i, 0);
                table.setValueAt(list.get(i - 1).getTitle(), i, 1);
                table.setValueAt(list.get(i - 1).getLecID(), i, 2);
                table.setValueAt(list.get(i - 1).getSpec(), i, 3);
                table.setValueAt(list.get(i - 1).getDate(), i, 4);
                table.setValueAt(list.get(i - 1).getStuID(), i, 5);
                table.setValueAt(list.get(i - 1).getStatus(), i, 6);
                table.setValueAt(list.get(i - 1).getComment(), i, 7);
            }

            panel.add(table);
            table.setEnabled(false);

            frame.add(panel);
            frame.setVisible(true);

        }

        /*Estellyn Hoo Weay 
         * Build of CommentProject use case interface
        */
        public void adminComment(List<Project> projects) {

            cbutton = new JButton("Comment");

            JFrame frame = new JFrame("Administrator Comment Board");
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            JLabel label = new JLabel("Please select project ID :");
            label.setBounds(80, 80, 200, 20);

            String arr[] = new String[projects.size()];
            for (int i = 0; i < projects.size(); i++) {
                arr[i] = projects.get(i).getProjID();
            }
            projid = new JComboBox<>(arr);
            projid.setBounds(300, 80, 130, 20);

            // --------------

            label2 = new JLabel("Comment : ");
            label2.setBounds(80, 150, 80, 20);

            comment = new TextField();
            comment.setBounds(80, 200, 400, 30);
            comment.setText("-");

            cbutton.setBounds(80, 250, 100, 20);
            panel1.add(cbutton);
            panel1.add(label2);
            panel1.add(comment);
            frame.add(panel1);
            frame.setSize(550, 350);
            frame.setVisible(true);

            cbutton.setVisible(false);
            label2.setVisible(false);
            comment.setVisible(false);
            panel1.add(label);
            panel1.add(projid);
            frame.add(panel1);
            frame.setLocation(500, 200);
            frame.setSize(550, 330);
            frame.setVisible(true);
        }
        /*Estellyn Hoo Weay 
         * getter
        */
        public JComboBox<String> getComboProjectId() {
            return projid;
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public void selectCommentListener(ActionListener commentListener) {

            projid.addActionListener(commentListener);

        }
        /*Estellyn Hoo Weay 
         * To  handle the "Comment" button
        */
        public void addCommentListener(ActionListener commentListener) {

            cbutton.addActionListener(commentListener);

        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public TextField getCommentfld() {
            return comment;
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public String getComment() {
            return comment.getText();
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public JLabel getLabel2() {
            return label2;
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public JButton getCbutton() {
            return cbutton;
        }

        /*Estellyn Hoo Weay 
         * Build of ManageProject use case interface
        */
        public void AdminManagerProj() {

            JFrame frameManager = new JFrame("Administrator Project Management Board");
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);

            JLabel label1 = new JLabel("Project ID : ");
            label1.setBounds(100, 80, 100, 20);

            JLabel label2 = new JLabel("Title : ");
            label2.setBounds(100, 110, 100, 20);

            JLabel label3 = new JLabel("Lecturer ID : ");
            label3.setBounds(100, 140, 100, 20);

            JLabel label4 = new JLabel("Specialization : ");
            label4.setBounds(100, 170, 100, 20);

            JLabel label5 = new JLabel("Date : ");
            label5.setBounds(100, 200, 100, 20);

            JLabel label6 = new JLabel("Student ID : ");
            label6.setBounds(100, 230, 100, 20);

            JLabel label7 = new JLabel("Status : ");
            label7.setBounds(100, 260, 100, 20);

            JLabel label8 = new JLabel("Comment : ");
            label8.setBounds(100, 290, 100, 20);

            projidM = new TextField();
            projidM.setBounds(200, 80, 250, 20);
            projidM.setText("P");

            title = new TextField();
            title.setBounds(200, 110, 250, 20);
            title.setText("-");

            lecid = new TextField();
            lecid.setBounds(200, 140, 250, 20);
            lecid.setText("L");

            String[] spcChoice = { "software engineering", "data science", "game development", "cybersecurity" };
            spcM = new JComboBox<String>(spcChoice);
            spcM.setBounds(200, 170, 250, 20);

            date = new TextField();
            date.setBounds(200, 200, 250, 20);
            date.setText("-");

            stuid = new TextField();
            stuid.setBounds(200, 230, 250, 20);
            stuid.setText("-");
            stuid.setEnabled(false);

            int statusChoiceIndex = 0;

            String[] statusChoice = { "active", "inactive" };
            status = new JComboBox<String>(statusChoice);
            status.setSelectedIndex(statusChoiceIndex);
            status.setBounds(200, 260, 250, 20);

            comment = new TextField();
            comment.setBounds(200, 290, 250, 20);
            comment.setText("-");

            addButton = new JButton("Add");
            delButton = new JButton("Delete");

            addButton.setBounds(100, 350, 100, 30);
            delButton.setBounds(250, 350, 100, 30);

            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(label4);
            panel1.add(label5);
            panel1.add(label6);
            panel1.add(label7);
            panel1.add(label8);
            panel1.add(projidM);
            panel1.add(title);
            panel1.add(lecid);
            panel1.add(spcM);
            panel1.add(date);
            panel1.add(stuid);
            panel1.add(status);
            panel1.add(comment);
            panel1.add(addButton);
            panel1.add(delButton);

            frameManager.setSize(550, 500);
            frameManager.setLocation(500, 200);
            frameManager.add(panel1);
            frameManager.setVisible(true);

        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public String getProjidM() {
            return projidM.getText();
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public String getTitle() {
            return title.getText();
        }

        /*Estellyn Hoo Weay
         * getter
         */
        public String getLecid() {
            return lecid.getText();
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public String getDate() {
            return date.getText();
        }

        /*Estellyn Hoo Weay 
         * getter
        */
        public String getStuid() {
            return stuid.getText();
        }

        /*Estellyn Hoo Weay
         * To handle choice of admin
         */
        public void addStatusListener(ActionListener statusListener) {

            status.addActionListener(statusListener);

        }

        /*Estellyn Hoo Weay 
         * To handle choice of admin
        */
        public void addSpcMListener(ActionListener spcListener) {

            spcM.addActionListener(spcListener);

        }

        /*Estellyn Hoo Weay 
         * To handle "Add" button
        */
        public void addProjectListener(ActionListener projectListener) {

            addButton.addActionListener(projectListener);

        }

        /*Estellyn Hoo Weay 
         * To  handle "Delete"  button
        */
        public void deleteProjectListener(ActionListener deleteListener) {

            delButton.addActionListener(deleteListener);

        }

        /*Estellyn Hoo Weay */
        /*
         * Receive success or error message and diaplay in dialog
         */
        public void displayDialog(String message) {

            Frame frame = new Frame();
            JDialog dialog = new JDialog(frame, "");
            JPanel Panel = new JPanel();
            JLabel messagelabel = new JLabel(message);
            Panel.add(messagelabel);
            dialog.add(Panel);
            dialog.setSize(350, 100);
            dialog.setVisible(true);
            dialog.setResizable(false);
            dialog.setLocationRelativeTo(null);

        }

    }

    /*
     * Class represents Administrator Controller that have many listener
     * It call add user view and create account for user, view project,
     * manange project and comment project
     */

    public class AdministratorC {

        private AdministratorV view;
        private AdministratorM model;
        private String role, spc, filchoice, subchoice, commentchoice, status, spcM;

        /*
         * Administrator Controller links view and model, and it
         * will execute when menubutton is clicked
         * Lim Wen Jie 
         */
        public AdministratorC(AdministratorV view, AdministratorM model) {

            this.view = view;
            this.model = model;
            view.menu();
            view.addMenuListener(new CallAddUserListener());
            view.addMenu2Listener(new ViewlistListener());
            view.addMenu3Listener(new CommentMenuListener());
            view.addMenu4Listener(new AddDeleteProjectListener());

        }

        /*Lim Wen Jie 
         * constructor
        */
        public AdministratorC() {
        }

        
        /*
         * To call view to display add User view
         */
        /*Lim Wen Jie */
        private class CallAddUserListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                view.panel3.removeAll();
                view.panel3.repaint();
                view.panel3.revalidate();
                view.addUser();
                view.addChoiceListener(new SelectChoiceListener());
                view.addUserListener(new AddUserListener());

            }
        }

        /*
         * It will set the text according the role that have selected and call
         * add user listener when the add user button is clicked
         * 
         * If Administrator is selected, it set the text Field begin with A
         * If Lecturer is selected, it set the text Field begin with L
         * If Student is selected, it set the text Field begin with S
         * 
         * Lim Wen Jie 
         */
        private class SelectChoiceListener implements ActionListener {
            public void actionPerformed(ActionEvent ev) {

                JComboBox cb = (JComboBox) ev.getSource();
                role = (String) cb.getSelectedItem();
                view.label4.setVisible(false);
                view.newSpc.setVisible(false);

                if ("Administrator".equals(role)) {
                    view.getNewIDFld().setText("A");

                }

                else if ("Lecturer".equals(role)) {
                    view.getNewIDFld().setText("L");

                }

                else if ("Student".equals(role)) {
                    view.getNewIDFld().setText("S");
                    view.label4.setVisible(true);
                    view.newSpc.setVisible(true);
                    view.addSpcListener(new SelectSpcListener());

                }

                view.getNewIDFld().repaint();
                view.getNewIDFld().revalidate();

            }
        }

        /*Lim Wen Jie */
        /* get the selected specialization */
        private class SelectSpcListener implements ActionListener {
            public void actionPerformed(ActionEvent ev) {

                JComboBox cb = (JComboBox) ev.getSource();
                spc = (String) cb.getSelectedItem();

            }
        }

        /*
         * If the username entered by user already exists or the password/userName is
         * wrong, the system will call view to show error message.
         * Or else it will show success message and save into user.csv
         * 
         * specialization combo box default is Software Engineering if admin no choosed
         * Lim Wen Jie
         */
        private class AddUserListener implements ActionListener {
            public void actionPerformed(ActionEvent ev) {

                String id = view.getNewUserName();
                String pw = view.getNewPw();

                List<UserM> users = new ArrayList<UserM>();
                UserC userc = new UserC();
                if (role == null)
                    role = "Administrator";

                try {

                    users = userc.readUserFromFile();
                    for (int i = 0; i < users.size(); i++) {
                        if (id.equals(users.get(i).getUserName()))
                            throw new IllegalArgumentException("Username is already taken.");

                    }
                    if (id.isEmpty() || pw.isEmpty())
                        throw new IllegalStateException("Please complete all the required field");

                    users.add(new UserM(id, pw));
                    UserC.saveToFile(users);

                    if (role.equals("Student")) {

                        Student userstu = new Student();
                        Student.StudentC studentc = userstu.new StudentC();
                        if (spc == null) {
                            spc = "software engineering";
                        }
                        studentc.handlesave(id, pw, spc);

                    }

                    view.displaySuccessMessage(id + " is successful added");
                    view.validateLabel.revalidate();
                    view.validateLabel.repaint();

                } catch (IOException e) {
                    view.displayErrorMessage("Error: file does not exist");

                } catch (IllegalArgumentException e) {
                    view.displayErrorMessage("Username is already taken.");

                } catch (IllegalStateException e) {
                    view.displayErrorMessage(e.getMessage());
                }

            }
        }

         /*Estellyn Hoo Weay 
          * To get project lists detail  form csv file
         */
        public List<Project> getprojects() {
            List<Project> projects = new ArrayList<Project>();
            try {
                projects = model.getProject().readProjFromFile();
            } catch (IOException e1) {
                System.out.println("System error");
            }
            return projects;
        }

        
        /* 
         * When view list menu button is clicked , it will call
         * view to show menu view project
         */
        /*Estellyn Hoo Weay */
        private class ViewlistListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                view.adminViewProject();
                view.addFilterListener(new FilterListener());

            }
        }

        
        /*
         * It will call the specific view according to the choice
         */
        /*Estellyn Hoo Weay */
        private class FilterListener implements ActionListener {
            public void actionPerformed(ActionEvent ev) {

                JComboBox cb = (JComboBox) ev.getSource();
                filchoice = (String) cb.getSelectedItem();

                List<Project> projects = getprojects();
                List<Project> newlist = new ArrayList<Project>();

                switch (filchoice) {
                    case "all":
                        view.viewList(projects);
                        break;
                    case "specialization":
                        view.adminViewProject2(projects, filchoice);
                        view.addShowList2Listener(new ShowList2Listener());
                        break;
                    case "lecture ID":
                        List<Project> leclist = RemoveRepeatLec(projects);
                        view.adminViewProject2(leclist, filchoice);
                        view.addShowList2Listener(new ShowList2Listener());
                        break;
                    case "active":
                        for (int i = 0; i < projects.size(); i++) {
                            if (projects.get(i).getStatus().equals("active"))
                                newlist.add(projects.get(i));
                        }
                        view.viewList(newlist);
                        newlist.clear();
                        break;
                    case "inactive":
                        for (int i = 0; i < projects.size(); i++) {
                            if (projects.get(i).getStatus().equals("inactive"))
                                newlist.add(projects.get(i));
                        }
                        view.viewList(newlist);
                        newlist.clear();
                        break;
                    case "assigned":
                        for (int i = 0; i < projects.size(); i++) {
                            if (!projects.get(i).getStuID().equals("-"))
                                newlist.add(projects.get(i));
                        }
                        view.viewList(newlist);
                        newlist.clear();
                        break;
                    case "unassigned":
                        for (int i = 0; i < projects.size(); i++) {
                            if (projects.get(i).getStuID().equals("-"))
                                newlist.add(projects.get(i));
                        }
                        view.viewList(newlist);
                        newlist.clear();
                        break;
                    case "commented":
                        for (int i = 0; i < projects.size(); i++) {
                            if (!projects.get(i).getComment().equals("-"))
                                newlist.add(projects.get(i));
                        }
                        view.viewList(newlist);
                        newlist.clear();
                        break;

                }

            }

        }

        
        /*
         * When choose either lecturer id or specialization, it will show up 
         * menu for each
         */
        /*Estellyn Hoo Weay */
        private class ShowList2Listener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                List<Project> projects = getprojects();
                List<Project> list = new ArrayList<Project>();

                JComboBox cb = (JComboBox) e.getSource();
                subchoice = (String) cb.getSelectedItem();

                if (subchoice.equals("data science") || subchoice.equals("cybersecurity")
                        || subchoice.equals("software engineering") || subchoice.equals("game development")) {
                    for (int i = 0; i < projects.size(); i++) {
                        if (projects.get(i).getSpec().equals(subchoice))
                            list.add(projects.get(i));
                    }
                    view.viewList(list);
                    list.clear();
                } else {
                    for (int i = 0; i < projects.size(); i++) {
                        if (projects.get(i).getLecID().equals(subchoice))
                            list.add(projects.get(i));
                    }
                    view.viewList(list);
                    list.clear();
                }
                // --------------------------------

            }
        }

        
        /*
         * To call view to display comment menu view 
         */
        /*Estellyn Hoo Weay */
        private class CommentMenuListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                List<Project> projects = getprojects();
                view.adminComment(projects);

                view.selectCommentListener(new CommentActionListener());

            }
        }

        
        /*
         * After select the project, it will disable
         * the drop down list, and show the comment field
         */
        /*Estellyn Hoo Weay */
        private class CommentActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                commentchoice = (String) cb.getSelectedItem();

                view.getComboProjectId().setEnabled(false);
                view.getCbutton().setVisible(true);
                view.getCommentfld().setVisible(true);
                view.getLabel2().setVisible(true);
                view.addCommentListener(new CommentButtonListener());

            }
        }

        
        /*
         * To validate the comment field
         * if the field is blank, it will notify user to add on -
         * or else it will save and display successful message
         * 
         */
        /*Estellyn Hoo Weay */
        private class CommentButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                List<Project> projects = getprojects();
                int i = 0;

                try {

                    if (view.getComment().isEmpty())
                        throw new IllegalArgumentException("If you want leave it blank, please add on -");

                    else {

                        i = getIndex(commentchoice, projects);

                        projects.get(i).setComment(view.getComment());

                        model.getProject().saveToProjFile(projects);

                        view.displayDialog("Comment was successfully updated");

                    }

                } catch (IOException e1) {
                    e1.printStackTrace();

                } catch (IllegalArgumentException e1) {
                    view.displayDialog(e1.getMessage());

                }

            }
        }

        
        /*
         * When add /delete menu button is clicked it will call view to show the
         * manange view
         */
        /*Estellyn Hoo Weay */
        private class AddDeleteProjectListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                view.AdminManagerProj();
                view.addSpcMListener(new SpcMListener());
                view.addStatusListener(new StatusListener());
                view.addProjectListener(new AddProjectListener());
                view.deleteProjectListener(new DeleteListener());

            }
        }

       
        /*
         * To get the selected specialization in manage project view
         */
         /*Estellyn Hoo Weay */
        private class SpcMListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                spcM = (String) cb.getSelectedItem();

            }
        }
        
        /*
         * To get the selected status in manage project view
         */
        /*Estellyn Hoo Weay */
        private class StatusListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                status = (String) cb.getSelectedItem();

            }
        }


        
        /*
         * validate add project field
         * if the field blank/ project name exist/ lec id no exist
         * it will show error message
         * or else it will show success message and save it
         */
        /*Estellyn Hoo Weay */
        private class AddProjectListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                boolean lecExist = false;
                List<Project> projects = getprojects();

                // check project exist
                try {
                    for (int i = 0; i < projects.size(); i++) {

                        if (view.getProjidM().equals(projects.get(i).getProjID()))
                            throw new IllegalArgumentException("Project Name already exist");

                    }

                    UserC userc = new UserC();
                    List<UserM> users = new ArrayList<UserM>();
                    users = userc.readUserFromFile();

                    // check if empty
                    if (view.getProjidM().isEmpty() || view.getProjidM().equals("-")
                            || view.getLecid().isEmpty() || view.getLecid().equals("-")
                            || view.getTitle().isEmpty() || view.getTitle().equals("-")
                            || view.getDate().isEmpty() || view.getDate().equals("-")) {
                        throw new IllegalStateException("Please complete all the required field, comment is optional");

                    }

                    else if (view.getComment().isEmpty())
                        throw new IllegalArgumentException("If you want leave it blank for comment, please add on -");

                    // check lecturer exist
                    for (int i = 0; i < users.size(); i++) {

                        if (view.getLecid().equals(users.get(i).getUserName()))
                            lecExist = true;

                    }

                    if (lecExist == false)
                        throw new IllegalArgumentException("Lec ID doesn't exist");

                    // if success
                    if (status == null)
                        status = "active";
                    if (spcM == null)
                        spcM = "software engineering";
                    projects.add(new Project(view.getProjidM(), view.getTitle(), view.getLecid(),
                            spcM, view.getDate(), view.getStuid(), status, view.getComment()));
                    model.getProject().saveToProjFile(projects);

                    view.displayDialog("Project successful added");

                } catch (IOException e1) {
                    e1.printStackTrace();

                } catch (IllegalStateException e2) {
                    view.displayDialog(e2.getMessage());

                } catch (IllegalArgumentException e3) {
                    view.displayDialog(e3.getMessage());

                }

            }
        }

        /*Estellyn Hoo Weay 
         * To get serial number for specific Projec ID
        */
        public int getIndex(String id, List<Project> list) {
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (id.equals(list.get(i).getProjID()))
                    index = i;
            }

            return index;
        }
        
        /*
         * validate delete project field
         * if the project doesnt exist show error message
         * or else delete it and show successful message
         */
        /*Estellyn Hoo Weay */
        private class DeleteListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                List<Project> projects = getprojects();

                int index = getIndex(view.getProjidM(), projects);

                try {
                    if (index == -1) {

                        throw new IllegalArgumentException("Project doesn't exist");
                    }

                    else {

                        projects.remove(index);

                        model.getProject().saveToProjFile(projects);

                        view.displayDialog("Project successful deleted");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();

                } catch (IllegalArgumentException e1) {
                    view.displayDialog(e1.getMessage());

                }
            }
        }

        
         /*Estellyn Hoo Weay 
          *Remove the same lecture id from project list
         */
        public List<Project> RemoveRepeatLec(List<Project> projects) {

            List<Project> newlist = new ArrayList<Project>();
            List<String> lecID = new ArrayList<String>();
            String lecid = projects.get(0).getLecID();
            lecID.add(lecid);
            newlist.add(projects.get(0));

            for (int i = 1; i < projects.size(); i++) {
                lecid = projects.get(i).getLecID();
                if (lecID.contains(lecid)) {
                    continue;
                }
                lecID.add(lecid);
                newlist.add(projects.get(i));
            }

            return newlist;
        }

    }
}
