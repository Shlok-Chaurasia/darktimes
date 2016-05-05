package bowling.intefaces;

import bowling.impl.BowlScore;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface BowlingAlley {

    void displayScores();
    void updateScore(int bowl, int laneNumber);

}
