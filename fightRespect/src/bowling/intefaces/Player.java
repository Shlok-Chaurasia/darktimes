package bowling.intefaces;

import bowling.impl.BowlScore;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface Player {
    void initialize();
    void setScore(int score);
    int getScore();
}
