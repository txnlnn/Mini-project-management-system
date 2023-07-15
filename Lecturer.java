import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Lecturer class contains Lecturer model, view, controller class
 * It handles lecturer viewboard and edit function
 * 
 */
public class Lecturer extends User {

    /*
     * Class represents Lecturer model to handle Lecturer info
     */
    public class LecturerM extends UserM {

         /*Lee Tian Xin*/
        public LecturerM(String userName, String password) {
            super(userName, password);

        }

    }

    /*
     * Class represents Lecturer View which has Lecturer menu view, edit view and
     * implement viewboard
     */
    public class LecturerV implements Viewboard {

        private JButton menuBtn1, menuBtn2, change;
        private TextField projid, title, lecid, spec, date, stuid, comment;
        private JComboBox<String> projectID, status;
        private String statusIndex;

        /*Lee Tian Xin
         * Build of Lecturer use case Menu
        */
        public void menu() {
            JPanel panel1 = new JPanel(); // lecture main menu
            JFrame frame = new JFrame("Lecturer Menu");

            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            panel1.setLayout(null);

            menuBtn1 = new JButton("Edit project");
            menuBtn1.setBounds(100, 20, 110, 30);
            panel1.add(menuBtn1);
            menuBtn2 = new JButton("View project");
            menuBtn2.setBounds(100, 60, 110, 30);
            panel1.add(menuBtn2);

            frame.setLocationRelativeTo(null);
            frame.add(panel1);
            frame.setVisible(true);

        }

        /*
         * Lee Tian Xin
         * To let controller to handle it when menu button 1 is clicked
         */
        public void addEditBoardsListener(ActionListener callEditBoardsListener) {

            menuBtn1.addActionListener(callEditBoardsListener);

        }

         /*Lee Tian Xin
          * To let controller to handle it when menu button 2 is clicked
         */
        public void addViewBoardsListener(ActionListener callViewBoardsListener) {

            menuBtn2.addActionListener(callViewBoardsListener);

        }

        
        /*Lee Tian Xin
        *To generate project list for ViewProject 
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

        /*Lee Tian Xin
         * Build of EditProject use case interface
        */
        public void editProjMenu(List<Project> projects, List<Project> projectidlist) {

            JFrame frame = new JFrame("Project Editer");
            frame.setLocation(500, 200);
            frame.setSize(550, 400);
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);

            String[] array = new String[projectidlist.size()];
            for (int i = 0; i < projectidlist.size(); i++) {
                array[i] = projectidlist.get(i).getProjID();
            }

            JLabel label = new JLabel("Please select the project ID :");
            label.setBounds(80, 80, 220, 20);

            projectID = new JComboBox<String>(array);
            projectID.setBounds(300, 80, 130, 20);

            panel1.add(label);
            panel1.add(projectID);
            frame.add(panel1);
            frame.setVisible(true);

        }

        /*Lee Tian Xin
         * To handle choice of lecturer
        */
        public void addSelectProjEditListener(ActionListener selectProjEditListener) {

            projectID.addActionListener(selectProjEditListener);

        }

        /*Lee Tian Xin
         * Build of EditeProject interface  when lecturer apply the project ID
        */
        public void projEditor(List<Project> projects, int index) {

            JFrame frame = new JFrame("Editboard");
            JPanel panel2 = new JPanel();

            panel2.setLayout(null);
            frame.setLocation(500, 200);

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

            // textfield
            projid = new TextField();
            projid.setBounds(200, 80, 250, 20);
            projid.setText(projects.get(index).getProjID());
            projid.setEditable(false);

            title = new TextField();
            title.setBounds(200, 110, 250, 20);
            title.setText(projects.get(index).getTitle());

            lecid = new TextField();
            lecid.setBounds(200, 140, 250, 20);
            lecid.setText(projects.get(index).getLecID());
            lecid.setEditable(false);

            spec = new TextField();
            spec.setBounds(200, 170, 250, 20);
            spec.setText(projects.get(index).getSpec());
            spec.setEditable(false);

            date = new TextField();
            date.setBounds(200, 200, 250, 20);
            date.setText(projects.get(index).getDate());

            stuid = new TextField();
            stuid.setBounds(200, 230, 250, 20);
            stuid.setText(projects.get(index).getStuID());

            int statusChoiceIndex = 0;
            statusIndex = projects.get(index).getStatus();
            if (statusIndex.equals("active"))
                statusChoiceIndex = 0;
            else
                statusChoiceIndex = 1;

            String[] statusChoice = { "active", "inactive" };
            status = new JComboBox<String>(statusChoice);
            status.setSelectedIndex(statusChoiceIndex);
            status.setBounds(200, 260, 250, 20);

            comment = new TextField();
            comment.setBounds(200, 290, 250, 20);
            comment.setText(projects.get(index).getComment());
            comment.setEditable(false);

            change = new JButton("Change");
            change.setBounds(350, 310, 100, 30);

            panel2.add(label1);
            panel2.add(label2);
            panel2.add(label3);
            panel2.add(label4);
            panel2.add(label5);
            panel2.add(label6);
            panel2.add(label7);
            panel2.add(label8);
            panel2.add(projid);
            panel2.add(title);
            panel2.add(lecid);
            panel2.add(spec);
            panel2.add(date);
            panel2.add(stuid);
            panel2.add(status);
            panel2.add(comment);
            panel2.add(change);

            frame.setSize(550, 500);
            frame.add(panel2);
            frame.setVisible(true);

        }

         /*Lee Tian Xin
          * getter
         */
        public String getTitle() {
            return title.getText();
        }

         /*Lee Tian Xin
          * getter
         */
        public String getDate() {
            return date.getText();
        }

         /*Lee Tian Xin
          * getter
         */
        public String getStuid() {
            return stuid.getText();
        }

         /*Lee Tian Xin
          * getter
         */
        public String getSpec() {
            return spec.getText();
        }

         /*Lee Tian Xin
          * To handle the choice of lecturer
         */
        public void addStatusListener(ActionListener statusListener) {

            status.addActionListener(statusListener);

        }

         /*Lee Tian Xin
          * To handle "Change" button
         */
        public void addChangeListener(ActionListener changeListener) {

            change.addActionListener(changeListener);

        }

        /*Lee Tian Xin
         * Bulid of dialog
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
     * Class represents Lecturer Controller and it handles
     * Viewboard listener and edit listener
     */

    public class LecturerC {

        private LecturerV view;
        private LecturerM model;
        private String selectedID, status;

        /*
         * Lecturer Controller links view and model, and it
         * will execute when menubutton is clicked
         * Lee Tian Xin
         */
        public LecturerC(LecturerV view, LecturerM model) {

            this.view = view;
            this.model = model;
            view.menu();
            view.addEditBoardsListener(new EditBoardsListener());
            view.addViewBoardsListener(new ViewBoardsListener());

        }

        /*
         * To call view to display viewboard
         * 
         * Lee Tian Xin
         */
        private class ViewBoardsListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                List<Project> viewprojects = getprojects();

                view.viewList(viewprojects);

            }
        }

        /*
         * To filter the projects that is no belongs to lecturer and 
         * it call view to display edit menu view
         * Lee Tian Xin
         */
        private class EditBoardsListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                List<Project> oriprojects = getprojects();
                List<Project> editprojects = getprojects();

                for (int i = editprojects.size() - 1; i >= 0; i--) {
                    if (!(model.getUserName().equals(editprojects.get(i).getLecID())))
                        editprojects.remove(i);

                }

                view.editProjMenu(oriprojects, editprojects);
                view.addSelectProjEditListener(new SelectProjEditListener());

            }
        }

        /*
         * When select the specific project, it will call view to display edit
         * view according the project that selected
         * Lee Tian Xin
         */
        private class SelectProjEditListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                List<Project> selectprojects = getprojects();

                for (int i = selectprojects.size() - 1; i >= 0; i--) {
                    if (!(model.getUserName().equals(selectprojects.get(i).getLecID())))
                        selectprojects.remove(i);

                }

                JComboBox project_id = (JComboBox) e.getSource();
                selectedID = (String) project_id.getSelectedItem();
                int index = getIndex(selectedID, selectprojects);
                view.projEditor(selectprojects, index);
                view.addStatusListener(new StatusListener());
                view.addChangeListener(new ChangeListener());

            }
        }

        /*
         * To get the selected status
         * Lee Tian Xin
         */
        private class StatusListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                status = (String) cb.getSelectedItem();

            }
        }

        /*
         * Validate the changed field
         * if textfield blank or validate student id fail, it will show the error
         * message or else it will save into file and display confirmation message
         * 
         * Lee Tian Xin
         */
        private class ChangeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                List<Project> oriprojects = getprojects();
                boolean flag = true;

                try {
                    if (view.getTitle().isEmpty() || view.getDate().isEmpty() || view.getStuid().isEmpty()) {
                        throw new IllegalStateException("TextField cannot be blank");

                    } else {
                        int index = getIndex(selectedID, oriprojects);

                        if (!(view.getStuid().equals("-"))) {
                            flag = checkStudentID();
                        }
                        if (flag == true) {

                            oriprojects.get(index).setTitle(view.getTitle());
                            oriprojects.get(index).setDate(view.getDate());
                            oriprojects.get(index).setStuID(view.getStuid());
                            if (status == null)
                                status = view.statusIndex;
                            oriprojects.get(index).setStatus(status);
                            view.displayDialog("The changes has been saved");
                            model.getProject().saveToProjFile(oriprojects);
                        }
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();

                } catch (IllegalStateException e2) {
                    view.displayDialog(e2.getMessage());

                }

            }
        }

         /*Lee Tian Xin
          *Checking if the  lecturer apply same student ID  to different project
          *It will give error message  to lecturer
         */
        public boolean checkStudentID() {
            List<Project> projects = getprojects();

            String studentMessage = "";
            Student userstu = new Student();
            Student.StudentC studentc = userstu.new StudentC();
            boolean flag = true;

            try {

                studentMessage = studentc.checkStudentIdentity(view.getStuid(), view.getSpec());

                if (!(studentMessage.isEmpty() == true))
                    throw new IllegalArgumentException(studentMessage);

                for (int i = 0; i < projects.size(); i++) {

                    if (view.getStuid().equals(projects.get(i).getStuID())
                            && !(selectedID.equals(projects.get(i).getProjID()))) {
                        throw new IllegalArgumentException(
                                "Error: Student only can assigned to one project");
                    }

                }

            } catch (IOException e2) {

                flag = false;
                e2.printStackTrace();

            } catch (IllegalArgumentException e3) {

                flag = false;
                view.displayDialog(e3.getMessage());
            }

            return flag;

        }

        /*Lee Tian Xin
         * To get serial number of that specific project
        */
        public int getIndex(String id, List<Project> list) {
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (id.equals(list.get(i).getProjID()))
                    index = i;
            }

            return index;
        }

         /*Lee Tian Xin
          * To get project lists details from csv file
         */
        public List<Project> getprojects() {

            List<Project> projects = new ArrayList<Project>();
            try {
                projects = model.getProject().readProjFromFile();

            } catch (IOException e1) {

                view.displayDialog("System error");
            }
            return projects;
        }

    }
}
