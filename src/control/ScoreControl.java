package control;

import entity.Score;
import entity.Student;
import entity.StudentStatus;
import entity.Subject;

import java.util.*;

public class ScoreControl
{
    private List<Score> scores = new ArrayList<Score>();
    StudentControl studentControl = new StudentControl(new SubjectControl());

    public void addScore(int id, int subject, int round, int score)
    {
    }
    public void updateScore(int id, int subject, int round, int score) {
    }

    public void getGradesBySession(int id, int subject) {
    }

    public void getAverageGradeByStudentState(String state) {
    }
}
