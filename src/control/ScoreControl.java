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


    //수강생 점수 등록
    public void addScore(int id, int subjectId, int round, int score) {
        //고유 번호가 id인 학생
        Student student = studentControl.getStudentById(id);

        Subject thisSubject = null;
        for (Subject subject : student.getSubjects()) {
            if (subject.getId() == subjectId) {
                thisSubject = subject;
            }
        }
        //등급 추가
        char grade = calculateGrade(score, thisSubject.getType());
        Score newScore = new Score(id, subjectId, score, round, grade);
        scores.add(newScore);

        System.out.println("등록이 완료되었습니다:");
    }

    //점수별 등급 계산
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

    //수강생의 과목별 회차 점수 수정
    public void updateScore(int id, int subject, int round, int newScore) {
        System.out.println("시험 점수를 수정합니다...");

        //조건에 맞는 수강생의 회차에 맞는 점수 넣기
        for(Score score : scores){
            if(score.getStudentId() == id && score.getSubjectId()==subject && score.getRound()==round){
                score.setScore(newScore);
            }
        }

        System.out.println("\n점수 수정 성공!");
    }


    public void getGradesBySession(int id, int subject) {
    }

    public void getAverageGradeByStudentState(String state) {
    }

}


