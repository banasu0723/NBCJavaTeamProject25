package control;

import entity.Student;
import entity.StudentStatus;
import entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentControl
{
    private Map<Integer, Student> students = new HashMap<>();
    private Map<Integer, Subject> subjects;

    public StudentControl(SubjectControl subjectControl) {
        this.subjects = subjectControl.getSubjects();
    }

    public void addStudent(int id, String name, String subject)
    {
        String[] subjectsArr = subject.split(",");
        List<Subject> subjectsList = new ArrayList<>();

        //필수 3과목 이상, 선택 2과목 이상
        int essentialCount = 0, optionCount = 0;

        for (String s : subjectsArr) {
            int subjectIdInt = Integer.parseInt(s);
            if (subjects.containsKey(subjectIdInt)) {
                Subject sub = subjects.get(subjectIdInt);
                subjectsList.add(sub);
                if (sub.getType().equals("필수")) {
                    essentialCount++;
                } else if(sub.getType().equals("선택")) optionCount++;
            }
        }
        if (essentialCount < 3 || optionCount < 2)
        {
            System.out.println("필수는 3과목 이상, 선택은 두과목 이상 선택하여야 합니다");
            return;
        }
        Student student1 = new Student(id, name, subjectsList, StudentStatus.GREEN);
        students.put(id, student1);
    }

    public void getAllStudents() {
    }

    public void getStudentInfo(int id) {
        if (students.containsKey(id)) {
            Student student = students.get(id);
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
            System.out.println("Status: " + student.getStatus());

            System.out.println("Subjects:");
            for (Subject subject : student.getSubjects()) {
                System.out.println(" - " + subject.getName() + " (" + subject.getType() + ")");
            }
        } else {
            System.out.println("학생을 찾을 수 없습니다.");
        }
    }

    public void getStudentByState(String state) {
    }

    public void deleteStudent(int id) {
    }
}
