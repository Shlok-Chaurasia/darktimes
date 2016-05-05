package bowling.impl;

import bowling.enums.BowlTypeEnum;
import bowling.enums.PlayerTypeEnum;
import bowling.factories.BowlFactory;
import bowling.factories.PlayerFactory;
import bowling.intefaces.Bowl;
import bowling.intefaces.Player;
import bowling.intefaces.Set;

import java.util.*;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class NormalSetImpl implements Set {
    Map<Integer, Player> idToNumber;
    Map<Player, List<Bowl>> playerToScore;
    int currentPlayer;
    boolean isSetComplete;
    PlayerTypeEnum playerType;
    BowlTypeEnum bowlTypeEnum;

    public NormalSetImpl() {
        idToNumber= new HashMap<>();
        playerToScore= new HashMap<>();
        isSetComplete=false;
        playerType = PlayerTypeEnum.PLAYER_TYPE1;
        bowlTypeEnum=BowlTypeEnum.NORMAL;
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
        Player player = idToNumber.get(currentPlayer);
        Bowl bowl = BowlFactory.createBowl(bowlTypeEnum);
        bowl.initialize();
        BowlScore bowlScore1 = new BowlScore();
        bowlScore1.setScore(bowlScore);
        bowl.setScore(bowlScore);
        player.setScore(bowlScore);
        playerToScore.get(player).add(bowl);
        if(playerToScore.get(player).size() == BowlingAlleyImpl.MAX_NUMBER_OF_Bowl_PER_PLAYER)
            currentPlayer++;
        if(currentPlayer > BowlingAlleyImpl.MAX_NUMBER_OF_PLAYERS_PER_GAME)
            isSetComplete=true;
    }

    @Override
    public boolean isComplete() {
        return isSetComplete;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> list = new ArrayList<>();
        for(Player player: idToNumber.values())
            list.add(player);
        return list;
    }
}
