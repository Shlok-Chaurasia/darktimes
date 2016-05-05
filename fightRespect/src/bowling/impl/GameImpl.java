package bowling.impl;

import bowling.enums.SetTypeEnum;
import bowling.factories.SetFactory;
import bowling.intefaces.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class GameImpl implements Game {
    int currentSet;
    List<Set> frames;
    SetTypeEnum setTypeEnum;
    SetTypeEnum finalsetTypeEnum;

    public GameImpl() {
        frames = new ArrayList<>();
        setTypeEnum = SetTypeEnum.NORMAL;
        finalsetTypeEnum = SetTypeEnum.FINAL;
    }

    @Override
    public void initialize() {
        for (int set = 0; set < BowlingAlleyImpl.MAX_NUMBER_OF_SETS_PER_GAME; set++) {
            Set newSet = SetFactory.getSet(setTypeEnum);
            if(set == BowlingAlleyImpl.MAX_NUMBER_OF_SETS_PER_GAME-1)
            {
                newSet = SetFactory.getSet(finalsetTypeEnum);
            }
            newSet.initialize();
            frames.add(newSet);
        }
        currentSet = 0;
    }

    @Override
    public void updateScore(int bowlScore) {
        //check for invalid set
        Set setInProgress = frames.get(currentSet);
        setInProgress.updateScore(bowlScore);
        if (setInProgress.isComplete()) {
            currentSet++;
        }
    }

    public void printResult() {
        int setNumber = 0;
        for (Set set : frames) {
            System.out.println("======================================================================================");
            System.out.println("Set Number: " + setNumber);
            setNumber++;
            ArrayList<Player> players = set.getPlayers();
            int playerNumber = 0;
            for (Player player : players) {
                System.out.println("Player Score => " + playerNumber + " =>" + player.getScore());
                playerNumber++;
            }
            System.out.println("======================================================================================");
        }
    }
}
