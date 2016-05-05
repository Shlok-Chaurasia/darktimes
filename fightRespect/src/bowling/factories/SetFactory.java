package bowling.factories;

import bowling.enums.SetTypeEnum;
import bowling.impl.NormalSetImpl;
import bowling.intefaces.Set;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class SetFactory {
    public static Set getSet(SetTypeEnum setTypeEnum)
    {
        if(setTypeEnum==SetTypeEnum.NORMAL)
            return new NormalSetImpl();
        return null;
    }
}
