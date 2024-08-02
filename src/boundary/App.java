package boundary;

import control.ScoreControl;
import control.StudentControl;
import control.SubjectControl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트 더미데이터 생성할 예정..!

        SubjectControl subjectControl = new SubjectControl();
        StudentControl studentControl = new StudentControl(subjectControl);
        ScoreControl scoreControl = new ScoreControl();

        while (true) {
            //조회 및 입력부분
            System.out.println("1. 학생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 점수 등록");
            System.out.println("4. 점수 수정");
            System.out.println("5. 회차별 등급 조회");
            System.out.println("6. 수강생 정보 조회");
            System.out.println("7. 수강생 정보 수정");
            System.out.println("8. 상태별 수강생 목록 조회");
            System.out.println("9. 수강생 삭제");
            System.out.println("10. 수강생 과목별 평균 등급 조회.");
            System.out.println("11. 특정 상태의 수강생 필수 과목 평균 등급 조회");
            System.out.println("12. 종료");
            int cmd = sc.nextInt();

            if (cmd == 1) {
                // 학생등록 로직
                System.out.print("학생 ID를 입력하세요! : ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("학생 이름을 입력하세요 : ");
                String name = sc.nextLine();
                subjectControl.displayAllSubjects();
                System.out.print("과목 목록을 숫자로 입력해주세요 : ");
                String subjects = sc.nextLine();
                // 학생 등록 메서드 : 매개변수 id, name, 과목목록
                studentControl.addStudent(id, name, subjects);
            } else if (cmd == 2) {
                // 수강생 목록 조회 로직
                 //studentControl.getAllStudents();
            } else if (cmd == 3) {
                // 점수 등록 로직
                System.out.print("수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                //학생 과목 조회 메서드 추가
                System.out.print("과목 번호를 입력하세요 : ");
                int subject = sc.nextInt();
                System.out.print("회차를 입력하세요 : ");
                int round = sc.nextInt();
                System.out.print("등록할 점수를 입력해주세요 : ");
                int score = sc.nextInt();
                //점수 등록 메서드 : id, subject, round, score
                //scoreControl.addScore(id, subject, round, score);
            } else if (cmd == 4) {
                // 점수 수정 로직
                System.out.print("수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                //학생 과목 조회 메서드 추가
                System.out.print("과목 번호를 입력하세요 : ");
                int subject = sc.nextInt();
                System.out.print("회차를 입력하세요 : ");
                int round = sc.nextInt();
                System.out.print("등록할 점수를 입력해주세요 : ");
                int score = sc.nextInt();
                //점수 수정 메서드 : id, subject, round, score
                //scoreControl.updateScore(id, subject, round, score);
            } else if (cmd == 5) {
                // 회차별 등급 조회 로직
                System.out.print("수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                System.out.print("과목 번호를 입력하세요 : ");
                int subject = sc.nextInt();
                //회차별 등급 조회 메서드 : id, subject
                //scoreControl.getGradesBySession(id, subject);
            } else if (cmd == 6) {
                // 수강생 정보 조회 로직
                System.out.print("수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                //수강생 정보 조회 메서드
                //studentControl.getStudentInfo(id);
            } else if (cmd == 7) {
                // 수강생 정보 수정 로직
                System.out.print("수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("수정할 이름 (수정하지 않으려면 enter를 누르세요) : ");
                String name = sc.nextLine();
                System.out.print("수정할 상태 GREEN,RED,YELLOW (수정하지 않으려면 enter를 누르세요) : ");
                String state = sc.nextLine().toUpperCase();
                //수강생 정보 수정 메서드 매개변수 id, name, state)
                //studentControl.addStudent(id,name,state);
            } else if (cmd == 8) {
                // 상태별 수강생 목록 조회
                System.out.print("조회할 상태를 입력하세요 : ");
                sc.nextLine();
                String state = sc.nextLine().toUpperCase();
                //상태별 수강생 목록 조회 메서드
                //studentControl.getStudentByState(state)
            } else if (cmd == 9) {
                // 수강생 삭제
                System.out.print("삭제할 수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                //수강생 삭제 메서드 매개변수 : 수강생ID
                //studentControl.deleteStudent(id);
            } else if (cmd == 10) {
                // 수강생 과목별 평균 등급 조회 로직
                System.out.print("수강생 ID를 입력하세요 : ");
                int id = sc.nextInt();
                //수강생 과목별 평균 등급 조회 메서드 매개변수 : id
                //getAverageGradeByCourseForStudent(id);
            } else if (cmd == 11) {
                // 특정 상태의 수강생 필수 과목 평균 등급 조회
                System.out.print("조회할 상태를 입력하세요 : ");
                sc.nextLine();
                String state = sc.nextLine().toUpperCase();
                //특정 상태의 수강생 필수 과목 평균 등급 조회 메서드 매개변수 : state
                //scoreControl.getAverageGradeByStudentState(state);
            } else if(cmd == 12){
                System.out.println("종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        sc.close();
    }
}

