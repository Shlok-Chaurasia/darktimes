package messaging.factories;

import messaging.MessageTypeEnum;
import messaging.impl.MessageImpl;
import messaging.interfaces.Message;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class MessageFactory<T> {
    public static Message createMessage(MessageTypeEnum messageTypeEnum)
    {
        return new MessageImpl<>();
    }
}
