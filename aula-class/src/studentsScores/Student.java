package studentsScores;

import java.util.List;

public class Student {
    public String name;
    public List<Double> scores;

    public Student(String name, List<Double> scores) {
        this.name = name;
        this.scores = scores;
    }
}
