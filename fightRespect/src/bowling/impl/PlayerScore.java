package bowling.impl;

import bowling.intefaces.Bowl;
import bowling.intefaces.Score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class PlayerScore implements Score {
    int playerScore;
    public PlayerScore() {
        this.playerScore = 0;
    }
    public void updatePlayerScore(int bowlScore)
    {
        playerScore+=bowlScore;
    }

    @Override
    public int getScore(){
        return playerScore;
    }

    @Override
    public void setScore(int score) {
        playerScore=score;
    }


}
