package bowling.factories;

import bowling.enums.GameTypeEnum;
import bowling.impl.GameImpl;
import bowling.intefaces.Game;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class GameFactory {
    public static Game getGame(GameTypeEnum gameTypeEnum)
    {
        if(gameTypeEnum == GameTypeEnum.GAME_TYPE_1)
            return new GameImpl();
        return null;
    }
}
