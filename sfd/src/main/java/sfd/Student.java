package sfd;

/**
 * Created by zhuxinquan on 16-8-28.
 */
public class Student {
    private String sno;                 //学号
    private String name;                //名字
    private String academy;             //学院
    private String department;          //系
    private String classAndGrade;       //计科1505

    public Student() {
    }

    public Student(String sno, String name, String academy, String department, String classAndGrade) {
        this.sno = sno;
        this.name = name;
        this.academy = academy;
        this.department = department;
        this.classAndGrade = classAndGrade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClassAndGrade() {
        return classAndGrade;
    }

    public void setClassAndGrade(String classAndGrade) {
        this.classAndGrade = classAndGrade;
    }
}
