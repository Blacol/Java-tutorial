package com.blacol.score.entity;

public class Student {
    private String name;
    private int[] scores=new int[7];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
}
