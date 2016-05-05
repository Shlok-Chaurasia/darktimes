package bowling.intefaces;

import bowling.impl.BowlScore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface Set {
    void initialize();
    void updateScore(int bowlScore);
    boolean isComplete();
    ArrayList<Player> getPlayers();
}
