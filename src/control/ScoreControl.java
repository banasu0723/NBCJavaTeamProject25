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
        //예외처리
        if (student == null) {
            System.out.println("학생이 없습니다");
            return;
        }
        if (round < 1 || round > 10) {
            System.out.println("회차는 1~10회차만 가능합니다");
            return;
        }
        if(score < 0 || score > 100 ) {
            System.out.println("점수는 0~100사이의 값입니다.");
            return;
        }

        boolean existSubject = false;
        Subject thisSubject = null;
        for(Subject subject : student.getSubjects()) {
            if(subject.getId() == subjectId) {
                thisSubject = subject;
                existSubject = true;
            }
        }

        if(existSubject) {
            System.out.println("현재 수강중인 과목이 아닙니다");
            return;
        }

        for(Score scores : scores) {
            if(scores.getStudentId() == id && scores.getSubjectId() == subjectId && scores.getRound() == round) {
                System.out.println("이미 등록된 점수는 등록 할 수 없습니다");
                return;
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
        for(Score score : scores) {
            if (score.getStudentId() == id && score.getSubjectId() == subject && score.getRound() == round) {
                score.setScore(newScore);
            }
        }

        System.out.println("\n점수 수정 성공!");
    }

    //수강생 과목별 평균 등급 조회
    public void getAverageGradeByStudentSubject(int id, int subject){
        char averageGrade;
        /*List<Student> students = studentControl.getSubjects()

        for(Student student : students){

        }*/

        System.out.println("과목명 : " + subject);
        System.out.println("평균 등급 : ");
    }

    public void getGradesBySession(int id, int subject) {
    }

    //수강생 상태별 필수과목의 평균 등급 조회 - 작성자 조준호
    //state(green, red, yellow)를 넣으면 그 state를 기반으로 각 학생의 필수과목의 평균등급을 조회합니다.
    public void getAverageGradeByStudentState(String status) {
        //상태가 존재하지 않으면 예외처리를 해야한다
        boolean existState = false;
        for(StudentStatus state : StudentStatus.values()) {
            if(state.name().equals(status)) {
                existState = true;
            }
        }

        if(!existState) {
            System.out.println("상태를 잘못 입력하였습니다.");
            return;
        }

        StudentStatus state = StudentStatus.valueOf(status);
        List<Student> students = studentControl.getStudentByStatus(status);

        //학생의 스코어 객체를 돌면서 필수인 값이 있으면 점수를 모은다
        boolean existStudents = false;
        for (Student student : students) {
            int sumScore = 0;
            int sumEssentialSubjects = 0;
            for (Subject subject : student.getSubjects()) {
                if (subject.getType().equals("필수")) {
                    for (Score score : scores) {
                        if (score.getSubjectId() == subject.getId() && score.getStudentId() == student.getId()) {
                            sumScore += score.getScore();
                            sumEssentialSubjects++;
                            existStudents = true;
                        }
                    }
                }
            }
            //만약에 학생이 점수를 등록하지 않았을때 / by zero 오류가 출력된다 그걸 방지하기 위한 방법
            if(sumEssentialSubjects!=0)
            {
                int averageScore = sumScore / sumEssentialSubjects;
                char grade = calculateGrade(averageScore, "필수");
                System.out.println(student.getName() + "학생의 필수과목 평균 " + grade);
            }
        }
        //반복문을 돌았음에도 학생이 존재하지 않는경우의 예외 처리
        if(!existStudents)
        {
            System.out.println("해당 상태의 학생은 존재하지 않습니다");
        }
    }

    //수강생의 점수를 삭제하는 메서드
    public void deleteStudentScore(int id)
    {
        for(Score score : scores) {
            if (score.getStudentId() == id) scores.remove(id);
        }
    }
}