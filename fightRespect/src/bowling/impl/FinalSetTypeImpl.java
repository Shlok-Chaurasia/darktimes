package bowling.impl;

import bowling.enums.BowlTypeEnum;
import bowling.enums.PlayerTypeEnum;
import bowling.factories.PlayerFactory;
import bowling.intefaces.Bowl;
import bowling.intefaces.Player;
import bowling.intefaces.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class FinalSetTypeImpl implements Set {
    Map<Integer, Player> idToNumber;
    Map<Player, List<Bowl>> playerToScore;
    int currentPlayer;
    boolean isSetComplete;
    PlayerTypeEnum playerType;
    BowlTypeEnum bowlTypeEnum;

    public FinalSetTypeImpl() {
        idToNumber= new HashMap<>();
        playerToScore= new HashMap<>();
        isSetComplete=false;
        playerType = PlayerTypeEnum.PLAYER_TYPE1;
        bowlTypeEnum = BowlTypeEnum.NORMAL;
    }

    @Override
    public void initialize() {
        for(int numberOfPlayers = 0; numberOfPlayers<BowlingAlleyImpl.MAX_NUMBER_OF_PLAYERS_PER_GAME; numberOfPlayers++)
        {
            Player player = PlayerFactory.createPlayer(playerType);
            player.initialize();
            playerToScore.put(player, new ArrayList<>());
            idToNumber.put(numberOfPlayers+1, player);
            if(numberOfPlayers==0)
                currentPlayer = numberOfPlayers+1;
        }
        isSetComplete=false;
    }

    @Override
    public void updateScore(int bowlScore) {

    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }
}
