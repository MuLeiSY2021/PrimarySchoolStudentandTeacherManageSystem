package com.company.DataBaseAbout;

import com.company.BaseClass.Hunman.Student;
import com.company.BaseClass.Score;

import javax.security.auth.Subject;
import java.time.Year;
import java.util.LinkedList;

public class ScrDataBase {
    private LinkedList<Score> scoreLinkedList;
    private LinkedList<Score> ram_scoreLinkedLits;
    private static final Score nullScore = new Score();

    //------------------------------------------------//
    public LinkedList<Score> select(Subject subject, double max_score, boolean max_equ, double min_score, boolean min_equ, Year year, Student student) {
        LinkedList<Score> ptr_scoreLinkedList = scoreLinkedList;
        if(subject != null) {
            LinkedList<Score> tem_scoreLinkedList = new LinkedList<>();
            for(Score score:ptr_scoreLinkedList) {
                if(score.getSubject().equals(subject)) {
                    tem_scoreLinkedList.add(score);
                }
            }
            ptr_scoreLinkedList = tem_scoreLinkedList;
        }
        if(year != null) {
            LinkedList<Score> tem_scoreLinkedList = new LinkedList<>();
            for(Score score:ptr_scoreLinkedList) {
                if(score.getYear().equals(year)) {
                    tem_scoreLinkedList.add(score);
                }
            }
            ptr_scoreLinkedList = tem_scoreLinkedList;
        }
        if(student != null) {
            LinkedList<Score> tem_scoreLinkedList = new LinkedList<>();
            for(Score score:ptr_scoreLinkedList) {
                if(score.getStudent().equals(student)) {
                    tem_scoreLinkedList.add(score);
                }
            }
            ptr_scoreLinkedList = tem_scoreLinkedList;
        }
        if(max_score != 0) {
            LinkedList<Score> tem_scoreLinkedList = new LinkedList<>();
            for(Score score:ptr_scoreLinkedList) {
                if(score.getScore() <= max_score) {
                    tem_scoreLinkedList.add(score);
                }
            }
            ptr_scoreLinkedList = tem_scoreLinkedList;
            if(max_equ) {
                ptr_scoreLinkedList.removeIf(score -> score.getScore() == max_score);
            }
        }

        if(min_score != 0) {
            LinkedList<Score> tem_scoreLinkedList = new LinkedList<>();
            for(Score score:ptr_scoreLinkedList) {
                if(score.getScore() >= min_score) {
                    tem_scoreLinkedList.add(score);
                }
            }
            ptr_scoreLinkedList = tem_scoreLinkedList;
            if(min_equ) {
                ptr_scoreLinkedList.removeIf(score -> score.getScore() == min_score);
            }
        }

        ram_scoreLinkedLits = ptr_scoreLinkedList;
        return ptr_scoreLinkedList;
    }

    public double getAvgScore(LinkedList<Score> scoreLinkedList) {
        double result = 0;
        int number = 0;
        for (Score score:scoreLinkedList) {
            result += score.getScore();
            number++;
        }
        return result /= number;
    }
}
