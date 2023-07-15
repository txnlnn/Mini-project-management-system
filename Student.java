import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;

/*
 * Student class contains Student model, view, controller class
 * It handles student menu, viewboard
 *     
 */
public class Student extends User {

    /*
     * Class represents Student model to handle Student info
     * 
     */
    public class StudentM extends UserM {

        private String specialization;

        /*Michelle Yong Ting Ting 
         * constructor
        */
        public StudentM(String userName, String password, String specialization) {
            super(userName, password);
            this.specialization = specialization;

        }

        /*Michelle Yong Ting Ting 
         * constructor
        */
        public StudentM(String userName, String specialization) {
            super(userName);
            this.specialization = specialization;

        }

        /*Michelle Yong Ting Ting 
         * constructor
        */
        public StudentM() {
        }

        /*Michelle Yong Ting Ting 
         * getter
        */
        public String getSpec() {

            return specialization;
        }

        @Override
        /*Michelle Yong Ting Ting 
         * to return a string representation of an object
        */
        public String toString() {

            return getUserName() + " " + getSpec();
        }

        /*Michelle Yong Ting Ting 
         * to return a string representation of an object to  csv file
        */
        public String toCSVString() {

            return getUserName() + "," + getSpec();
        }

    }

    /*
     * Class represents Student view that has implement viewboard
     */
    public class StudentV implements Viewboard {

       
       

        /*
         * Student viewlist only display project id, title, lecid, date and comment
         */
         /*Michelle Yong Ting Ting */
         @Override
        public void viewList(List<Project> list) {

            JFrame frame = new JFrame("Viewboard");
            JPanel panel = new JPanel(new BorderLayout());

            if (list.size() == 0) {
                JDialog dialog = new JDialog(frame, "Error!");
                JPanel errorPanel = new JPanel();
                JLabel errorMessage = new JLabel("No projects available");
                errorPanel.add(errorMessage);
                dialog.add(errorPanel);
                dialog.setSize(350, 100);
                dialog.setVisible(true);
                dialog.setResizable(false);

            }

            int row = list.size();
            JTable table = new JTable(row + 1, 5);
            table.setValueAt("Project ID", 0, 0);
            table.setValueAt("Title", 0, 1);
            table.setValueAt("Lecturer ID", 0, 2);
            table.setValueAt("Date", 0, 3);
            table.setValueAt("Comment", 0, 4);

            for (int i = 1; i <= list.size(); i++) {
                table.setValueAt(list.get(i - 1).getProjID(), i, 0);
                table.setValueAt(list.get(i - 1).getTitle(), i, 1);
                table.setValueAt(list.get(i - 1).getLecID(), i, 2);
                table.setValueAt(list.get(i - 1).getDate(), i, 3);
                table.setValueAt(list.get(i - 1).getComment(), i, 4);
            }

            panel.add(table);
            table.setEnabled(false);
            frame.add(panel);
            frame.setVisible(true);

            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 400);

        }

    }

    /*
     * Class represents Student Controller 
     */
    public class StudentC {

        private StudentV view;
        private StudentM model;

        /*Michelle Yong Ting Ting 
         * constructor
        */
        public StudentC(StudentV view, StudentM model) {

            this.view = view;
            this.model = model;
            viewListC();

        }

        /*Michelle Yong Ting Ting 
         * constructor
        */
        public StudentC() {

        }

        /*
         * Retrieve project and it will filter that the projects are
         * the same specialization according the student, activate and unassigned
         * and call view to display it
         */
         /*Michelle Yong Ting Ting */
        public void viewListC() {

            List<Project> projects = new ArrayList<Project>();
            try {
                projects = model.getProject().readProjFromFile();
            } catch (IOException e1) {
                System.out.println("System error");

            }
            for (int i = projects.size() - 1; i >= 0; i--) {
                if (!(model.getSpec().equals(projects.get(i).getSpec())))
                    projects.remove(i);
                else if (projects.get(i).getStatus().equals("deactivate"))
                    projects.remove(i);
                else if (!(projects.get(i).getStuID().equals("-")))
                    projects.remove(i);

            }

            view.viewList(projects);

        }

        /*
         * read the file, then add the student to list and save to file
         */
        /*Michelle Yong Ting Ting */
        public void handlesave(String id, String pw, String spec) throws IOException {

            List<StudentM> students = readStudentFromFile();
            students.add(new StudentM(id, pw, spec));
            StudentC.saveStudentToFile(students);
        }

      
        /* 
         * check student if the student exist and stu specialization
         */
        /*Michelle Yong Ting Ting */
        public String checkStudentIdentity(String stu, String spec) throws IOException {

            List<StudentM> students = readStudentFromFile();
            boolean stuExist = false;
            String errormessage = "";
            int index = 0;

            for (int i = 0; i < students.size(); i++) {

                if (stu.equals(students.get(i).getUserName())) {
                    stuExist = true;
                    index = i;
                }

            }

            if (stuExist == false)
                errormessage = "Stu ID doesn't exist";

            if (!(spec.equals(students.get(index).getSpec())))
                errormessage = "Student's specialization must be same to Project ";

            return errormessage;

        }

        /*
         * Reads the student list into a list of lines and writes to the Student.csv file 
         * /
        /*Michelle Yong Ting Ting */
        public static void saveStudentToFile(List<StudentM> list) throws IOException {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list.size(); i++)
                sb.append(list.get(i).toCSVString() + "\n");

            Files.write(Paths.get("Student.csv"), sb.toString().getBytes());
        }

        /*
         * Reads the list of projects from a Student.csv file
         * /
        /*Michelle Yong Ting Ting */
        public List<StudentM> readStudentFromFile() throws IOException {
            List<StudentM> students = new ArrayList<StudentM>();

            List<String> lines;

            lines = Files.readAllLines(Paths.get("Student.csv"));
            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");
                // items[0] is id, item[1] is specialization
                students.add(new StudentM(items[0], items[1]));
            }

            return students;

        }

    }
}