package bowling.impl;

import bowling.intefaces.Score;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class BowlScore implements Score{
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
