package bowling.impl;

import bowling.intefaces.Bowl;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class BowlImpl implements Bowl {
    private BowlScore bowlScore;

    @Override
    public void initialize() {
        bowlScore= new BowlScore();
    }

    @Override
    public void setScore(int score) {
        bowlScore.setScore(score);
    }

}
