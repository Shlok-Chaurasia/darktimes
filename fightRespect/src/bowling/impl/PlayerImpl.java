package bowling.impl;

import bowling.intefaces.Player;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class PlayerImpl implements Player {
    PlayerScore playerScore;

    @Override
    public void initialize() {
        playerScore = new PlayerScore();
    }

    @Override
    public void setScore(int score) {
        playerScore.updatePlayerScore(score);
    }

    @Override
    public int getScore() {
        return playerScore.getScore();
    }

}
