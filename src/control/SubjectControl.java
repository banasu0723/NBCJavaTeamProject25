package control;

import entity.Subject;

import java.util.HashMap;
import java.util.Map;

public class SubjectControl
{
    private Map<Integer, Subject> subjects = new HashMap<>();

    public SubjectControl() {
        initializeSubjects();
    }

    //과목 등록을 위한 메서드
    private void initializeSubjects()
    {
        subjects.put(1, new Subject(1, "java", "필수"));
        subjects.put(2, new Subject(2, "객체지향", "필수"));
        subjects.put(3, new Subject(3, "SPRING", "필수"));
        subjects.put(4, new Subject(4, "JPA", "필수"));
        subjects.put(5, new Subject(5, "MYSQL", "필수"));
        subjects.put(6, new Subject(6, "디자인 패턴", "선택"));
        subjects.put(7, new Subject(7, "SPRING SECURITY", "선택"));
        subjects.put(8, new Subject(8, "REDIS", "선택"));
        subjects.put(9, new Subject(9, "MONGODB", "선택"));
    }

    //모든 과목 목록을 보여주는 메서드
    public void displayAllSubjects()
    {
        for(Subject subject : subjects.values())
        {
            System.out.println("id : " + subject.getId() + ", 과목명 : " + subject.getName() + ", 필수 / 선택 : " + subject.getType());
        }
    }

    public Map<Integer, Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<Integer, Subject> subjects) {
        this.subjects = subjects;
    }
}
