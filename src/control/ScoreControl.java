package control;

import entity.Score;
import entity.Student;
import entity.StudentStatus;
import entity.Subject;

import java.util.*;

public class ScoreControl {
    private List<Score> scores = new ArrayList<Score>();
    StudentControl studentControl;

    public ScoreControl(StudentControl studentControl) {
        this.studentControl = studentControl;
    }

    public void addScore(int id, int subjectId, int round, int score) {
        Student student = studentControl.getStudentById(id);

        Subject thisSubject = null;
        for (Subject subject : student.getSubjects()) {
            if (subject.getId() == subjectId) {
                thisSubject = subject;
            }
        }
        char grade = calculateGrade(score, thisSubject.getType());
        Score newScore = new Score(id, subjectId, score, round, grade);
        scores.add(newScore);

        System.out.println("등록이 완료되었습니다:");
    }

    private char calculateGrade(int score, String type) {
        if (type.equals("필수")) {
            if (score >= 95 ) return 'A';
            else if (score >= 90 ) return 'B';
            else if (score >= 80 ) return 'C';
            else if (score >= 70 ) return 'D';
            else if (score >= 60 ) return 'F';
        } else if (type.equals("선택")) {
            if (score >= 90 ) return 'A';
            else if (score >= 80 ) return 'B';
            else if (score >= 70 ) return 'C';
            else if (score >= 60 ) return 'D';
            else if (score >= 50 ) return 'F';
        }
        return 'N';
    }


    public void updateScore(int id, int subject, int round, int score) {
    }

    public void getGradesBySession(int id, int subject) {
    }

    public void getAverageGradeByStudentState(String state) {
    }

}


