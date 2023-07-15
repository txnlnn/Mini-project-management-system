import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.*;

import javax.security.auth.login.FailedLoginException;
import javax.swing.*;

/*
 * User class contains User model, view, controller class
 * It handles logins
 * 
 */
public class User {

    /*
     * Class represents user model which handle user info and aggregation
     * with Project class
     */
    public class UserM {

        private String userName;
        private String password;
        private Project project = new Project();

        /* Ho Xin Yong Cinee 
        * constructor
        */  
        UserM() {
        }

        /* Ho Xin Yong Cinee 
        * constructor
        */  
        public UserM(String userName, String password) {

            this.userName = userName;
            this.password = password;

        }

        /* Ho Xin Yong Cinee 
        *constructor
        */  
        public UserM(String userName) {

            this.userName = userName;

        }

        /* Ho Xin Yong Cinee 
        *getter
        */  
        public String getUserName() {
            return userName;
        }

        /* Ho Xin Yong Cinee 
        *getter
        */  
        public String getUserPw() {
            return password;
        }

        /* Ho Xin Yong Cinee 
        *getter
        */  
        public Project getProject() {

            return project;
        }

        /* Ho Xin Yong Cinee
        * to return a string representation of an object to  csv file
        */  
        public String toCSVString() {
            return userName + "," + password;
        }

    }

    /*
     * Class represents User view which has user login view
     */
    public class UserV {

        private TextField idLogin;
        private TextField pwLogin;
        private JLabel validateLabel;
        private JButton loginBtn;

        /* Ho Xin Yong Cinee 
        *  Build of Login use case menu for all actor
        */  
        public void loginview() {

            JFrame frame = new JFrame("Login");
            JPanel panel = new JPanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(310, 200);

            panel.setLayout(null);
            JLabel label1 = new JLabel("Username: ");
            label1.setBounds(20, 20, 80, 20);

            JLabel label2 = new JLabel("Password: ");
            label2.setBounds(20, 50, 80, 20);

            idLogin = new TextField(15);
            idLogin.setBounds(110, 20, 165, 20);

            pwLogin = new TextField(15);
            pwLogin.setBounds(110, 50, 165, 20);

            loginBtn = new JButton("Log in");
            loginBtn.setBounds(200, 85, 75, 20);

            validateLabel = new JLabel();
            validateLabel.setBounds(90, 60, 100, 50);

            panel.add(label1);
            panel.add(label2);
            panel.add(idLogin);
            panel.add(pwLogin);
            panel.add(loginBtn);
            panel.add(validateLabel);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
        /* Ho Xin Yong Cinee 
        *getter
        */  
        public TextField getIdLogin() {
            return idLogin;
        }

        /* Ho Xin Yong Cinee 
        *getter
        */  
        public TextField getPwLogin() {
            return pwLogin;
        }

        /* Ho Xin Yong Cinee 
        *getter
        */  
        public String getidlogin() {

            return idLogin.getText();
        }

        /* Ho Xin Yong Cinee 
        *getter
        */  
        public String getpwlogin() {

            return pwLogin.getText();
        }

        /*
         * Let the User controller class to handle it when loginBtn is clicked
         * Ho Xin Yong Cinee   
         */
        public void addLoginListener(ActionListener loginListener) {

            loginBtn.addActionListener(loginListener);

        }

        /*
         * Receive error message from User controller class and display it
         * Ho Xin Yong Cinee 
         */
        public void displayErrorMessage(String errorMessage) {

            validateLabel.setText(errorMessage);
        }

         /* Ho Xin Yong Cinee 
         * To display the success message
         * */ 
        public void displaySuccessMessage() {
            validateLabel.setText("");

        }

    }

    /*
     * Class represents User Controller to verify user identity
     */
    public class UserC {

        private UserM model;
        private UserV view;

        /*
         * User Controller links view and model, and it
         * will execute when loginbutton is clicked
         */
         /* Ho Xin Yong Cinee */ 
        public UserC(UserV view, UserM model) {

            this.view = view;
            this.model = model;
            view.loginview();
            view.addLoginListener(new LoginListener());
        }
        /* Ho Xin Yong Cinee 
        *  constructor
        */ 
        public UserC() {
        }

        /*
         * To verify user identity
         * If userName first char is A, it will calls Administrator's menu
         * If userName first char is L, it will calls Lecturer's menu
         * If userName first char is S, it will calls Student's menu
         * 
         *  Ho Xin Yong Cinee  
         */
        public class LoginListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                String id = view.getidlogin();
                String pw = view.getpwlogin();

                Boolean login = false;

                List<UserM> users = new ArrayList<UserM>();
                try {
                    users = readUserFromFile();

                    for (int i = 0; i < users.size(); i++) {
                        if (id.equals(users.get(i).getUserName()) && pw.equals(users.get(i).getUserPw())) {
                            String role = id.substring(0, 1);
                            if (role.equals("A")) { // A means Administrator

                                Administrator admin = new Administrator();
                                Administrator.AdministratorM adminm = admin.new AdministratorM(id, pw);
                                Administrator.AdministratorV adminview = admin.new AdministratorV();
                                Administrator.AdministratorC adminc = admin.new AdministratorC(adminview, adminm);
                                view.displaySuccessMessage();

                            } else if (role.equals("L")) { // L means Lecturer

                                Lecturer lecturer = new Lecturer();
                                Lecturer.LecturerM lecturerm = lecturer.new LecturerM(id, pw);
                                Lecturer.LecturerV lecturerview = lecturer.new LecturerV();
                                Lecturer.LecturerC lecturerc = lecturer.new LecturerC(lecturerview, lecturerm);
                                view.displaySuccessMessage();

                            } else if (role.equals("S")) { // S means Student
                                Student student = new Student();

                                String spc = "";
                                List<Student.StudentM> students = new ArrayList<>();
                                Student.StudentC studentc = student.new StudentC();

                                students = studentc.readStudentFromFile();

                                for (int t = 0; t < students.size(); t++) {
                                    if (id.equals(students.get(t).getUserName()))
                                        spc = students.get(t).getSpec();

                                }

                                Student.StudentM stum = student.new StudentM(id, pw, spc);
                                Student.StudentV stuv = student.new StudentV();
                                Student.StudentC stuc = student.new StudentC(stuv, stum);
                               
                                view.displaySuccessMessage();

                            } else {
                                throw new FailedLoginException("Please Try Again");

                            }

                            login = true;

                        }

                    }
                    if (!login) {
                        throw new FailedLoginException("Please Try Again");

                    }

                } catch (IOException e1) {

                    view.displayErrorMessage("System error");

                } catch (FailedLoginException e2) {
                    view.displayErrorMessage(e2.getMessage());

                } finally {
                    view.getIdLogin().setText(null);
                    view.getPwLogin().setText(null);
                }

            }
        }

        /**
         * Reads the user list into a list of lines and writes to the User.csv
         * file
         * 
         * Ho Xin Yong Cinee
         */
        public static void saveToFile(List<UserM> list) throws IOException {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list.size(); i++)
                sb.append(list.get(i).toCSVString() + "\n");

            Files.write(Paths.get("User.csv"), sb.toString().getBytes());
        }

        /**
         * Reads the list of users from a User.csv file, which contains the
         * userName and password of users into a list of lines.
         * Splits a line by comma and adds the userName and password into a list.
         * Returns the list containing the userName and password of users.
         * 
         * Ho Xin Yong Cinee
         */
        public List<UserM> readUserFromFile() throws IOException {
            List<UserM> users = new ArrayList<UserM>();

            List<String> lines;

            lines = Files.readAllLines(Paths.get("User.csv"));
            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");
                // items[0] is id, items[1] is pw
                users.add(new UserM(items[0], items[1]));
            }

            return users;

        }

    }

}