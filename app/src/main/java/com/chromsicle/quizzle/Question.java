package com.chromsicle.quizzle;

public class Question {
    //instance variables that will represent a question
    private int answerResId; //each answer id that will come from strings.xml
    private boolean isTrue;

    public Question(int answerResId, boolean isTrue) {
        this.answerResId = answerResId;
        this.isTrue = isTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
