package entity;

public class Score
{
    private int studentId;
    private int subjectId;
    private int score;
    private int round;
    private char grade;

    public Score(int studentId, int subjectId, int score, int round, char grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
        this.round = round;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
