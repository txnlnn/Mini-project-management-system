import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 *  Projects class contains project attribute
 */
public class Project {

    private String projID;
    private String title;
    private String lecID;
    private String spec;
    private String date;
    private String stuID;
    private String status;
    private String comment;

    /* Lim Wen Jie 
     * constructor
    */
    Project() {

    }

    /* Lim Wen Jie 
     * construtor
    */
    Project(String projID, String title, String lecID, String spec, String date, String stuID, String status,
            String comment) {
        this.projID = projID;
        this.title = title;
        this.lecID = lecID;
        this.spec = spec;
        this.date = date;
        this.stuID = stuID;
        this.status = status;
        this.comment = comment;
    }

    /* Lim Wen Jie 
     * getter
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /* Lim Wen Jie 
     * getter
    */
    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    /* Lim Wen Jie 
     * getter
    */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /* Lim Wen Jie 
     * getter
    */
    public void setDate(String date) {
        this.date = date;
    }

    /* Lim Wen Jie 
     * getter
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /* Lim Wen Jie 
     * getter
    */
    public String getProjID() {
        return projID;
    }

    /* Lim Wen Jie 
     * getter
    */
    public String getTitle() {
        return title;
    }

    /* Lim Wen Jie 
     * getter
    */
    public String getLecID() {
        return lecID;
    }

    /* Lim Wen Jie
     * getter
     */
    public String getSpec() {
        return spec;
    }

    /* Lim Wen Jie 
     * getter
    */
    public String getDate() {
        return date;
    }

    /* Lim Wen Jie 
     * getter
    */
    public String getStuID() {
        return stuID;
    }

    /* Lim Wen Jie
     * getter
     */
    public String getStatus() {
        return status;
    }

    /* Lim Wen Jie */
    public String getComment() {
        return comment;
    }

    /* Lim Wen Jie 
     * to return a string representation of an object
    */
    public String toString() {
        return projID + " , " + title + " , " + lecID + " , " + spec + " , " + date + " , " + stuID + " , " + status
                + " , " + comment;
    }

    /* Lim Wen Jie 
     * to return a string representation of an object to csv file
    */
    public String toCSVString() {
        return projID + "," + title + "," + lecID + "," + spec + "," + date + "," + stuID + "," + status + ","
                + comment;
    }

    /**
     * Reads the project list into a list of lines and writes to the project.csv
     * file
     */
    /* Lim Wen Jie */
    public void saveToProjFile(List<Project> list) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i).toCSVString() + "\n");

        Files.write(Paths.get("project.csv"), sb.toString().getBytes());
    }


    /**
     * Reads the list of projects from a projects.csv file
     */
    /* Lim Wen Jie */
    public List<Project> readProjFromFile() throws IOException {
        List<Project> projects = new ArrayList<Project>();

        List<String> lines;

        lines = Files.readAllLines(Paths.get("project.csv"));
        for (int i = 0; i < lines.size(); i++) {
            String[] items = lines.get(i).split(",");
            // items[0] is id, items[1] is title....
            projects.add(new Project(items[0], items[1], items[2], items[3], items[4], items[5], items[6], items[7]));
        }

        return projects;

    }

}