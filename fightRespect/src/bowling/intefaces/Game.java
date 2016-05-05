package bowling.intefaces;

import bowling.impl.BowlScore;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface Game {
    void initialize();
    void updateScore(int bowlScore);
    void printResult();
}
