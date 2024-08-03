package control;

import entity.Student;
import entity.StudentStatus;
import entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentControl {
    private Map<Integer, Student> students = new HashMap<>();
    private Map<Integer, Subject> subjects;

    public StudentControl(SubjectControl subjectControl) {
        this.subjects = subjectControl.getSubjects();
    }

    //학생 등록 메서드
    public void addStudent(int id, String name, String subject) {
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
                } else if (sub.getType().equals("선택")) optionCount++;
            }
        }
        if (essentialCount < 3 || optionCount < 2) {
            System.out.println("필수는 3과목 이상, 선택은 두과목 이상 선택하여야 합니다");
            return;
        }
        Student student1 = new Student(id, name, subjectsList, StudentStatus.GREEN);
        students.put(id, student1);
    }

    public void getAllStudents() {
    }

    public void getStudentInfo(int id) {

    }

    // 상태별 수강생 목록 조회메서드
    public void getStudentByState(String state) {
        for (Student student : students.values()) {
            if(student.getStatus().name().equals(state)) {
                System.out.println(" ID : " + student.getId() + " 이름 : " + student.getName());
            }
        }
    }

    //상태별 수강생 목록 조회 메서드 위 메서드와 합칠수 있을듯
    public List<Student> getStudentByStatus(StudentStatus status) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students.values()) {
            if(student.getStatus().name().equals(status.name())) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    //수강생을 삭제하는 메서드
    public void deleteStudent(int id) {
        students.remove(id);
    }

    public Student getStudentById(int id)
    {
        return students.get(id);
    }
}
