package com.company.BaseClass;

import com.company.BaseClass.Hunman.Student;

import javax.security.auth.Subject;
import java.time.Year;
import java.util.Objects;

public class Score {
    private Subject subject;
    private double score;
    private Student student;
    private final Year year;
    //----------------------//


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return Double.compare(score1.getScore(), getScore()) == 0 && Objects.equals(getSubject(), score1.getSubject()) && Objects.equals(getStudent(), score1.getStudent()) && Objects.equals(getYear(), score1.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getScore(), getStudent(), getYear());
    }

    public Score() {
        year = null;
    }

    public Score(Subject subject, double score, Student student, Year year) {
        this.subject = subject;
        this.score = score;
        this.student = student;
        this.year = year;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Year getYear() {
        return year;
    }

}
