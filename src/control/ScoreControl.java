package control;

import entity.Score;
import entity.Student;
import entity.Subject;

import java.util.*;

public class ScoreControl
{
    private List<Score> scores = new ArrayList<Score>();
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Subject> subjects;

    public void addScore(int id, int subject, int round, int score) {
    }

    public void updateScore(int id, int subject, int round, int score) {
    }

    public void getGradesBySession(int id, int subject) {
    }

    public void getAverageGradeByStudentState(String state) {
    }
}
