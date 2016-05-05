package bowling.impl;

import bowling.enums.GameTypeEnum;
import bowling.factories.GameFactory;
import bowling.intefaces.Bowl;
import bowling.intefaces.BowlingAlley;
import bowling.intefaces.Game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class BowlingAlleyImpl implements BowlingAlley {
    public static int MAX_NUMBER_OF_LANES = 10;
    public static int MAX_NUMBER_OF_SETS_PER_GAME = 10;
    public static int MAX_NUMBER_OF_PLAYERS_PER_GAME = 5;
    public static int MAX_NUMBER_OF_Bowl_PER_PLAYER = 2;

    Map<Integer, Game> games;
    GameTypeEnum gameTypeEnum;

    public BowlingAlleyImpl() {
        games = new HashMap<>();
        gameTypeEnum = GameTypeEnum.GAME_TYPE_1;
    }

    public void initialize() {
        for (int lane = 1; lane <= MAX_NUMBER_OF_LANES; lane++) {
            Game game = GameFactory.getGame(gameTypeEnum);
            game.initialize();
            games.put(lane, game);
        }
    }

    @Override
    public void updateScore(int bowlScore, int laneNumber) {
        games.get(laneNumber).updateScore(bowlScore);
    }

    @Override
    public void displayScores() {
        for (Game game : games.values()) {
            game.printResult();
        }
    }
}
