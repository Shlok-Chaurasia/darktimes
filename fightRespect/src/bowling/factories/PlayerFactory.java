package bowling.factories;

import bowling.enums.PlayerTypeEnum;
import bowling.impl.PlayerImpl;
import bowling.intefaces.Player;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class PlayerFactory {
    public static Player createPlayer(PlayerTypeEnum playerType)
    {
        if(playerType == PlayerTypeEnum.PLAYER_TYPE1)
            return new PlayerImpl();
        return null;
    }
}
