package entity;

public class Score
{
    private int subjectId;
    private int studentId;
    private int score;
    private String grade;
    private String Type;

    public Score(int subjectId, int studentId, int score, String grade, String type) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.score = score;
        this.grade = grade;
        Type = type;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
