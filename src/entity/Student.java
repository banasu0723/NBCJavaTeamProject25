package entity;

import java.util.List;

public class Student
{
    private int id;
    private String name;
    private List<Subject> subjects;
    private StudentStatus status;

    //기본생성자
    public Student(int id, String name, List<Subject> subjects, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.status = status;
    }

    //일단 쓰든 쓰지않든 냅두기!
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
}
