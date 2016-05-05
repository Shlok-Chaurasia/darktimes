package bowling.factories;

import bowling.enums.BowlTypeEnum;
import bowling.impl.BowlImpl;
import bowling.intefaces.Bowl;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class BowlFactory {
    public static Bowl createBowl(BowlTypeEnum bowlTypeEnum)
    {
//        if(bowlTypeEnum==BowlTypeEnum.TYPE_1)
//            return new BowlImpl();
        return null;
    }
}
