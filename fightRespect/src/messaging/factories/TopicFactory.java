package messaging.factories;

import messaging.TopicTypeEnum;
import messaging.impl.TopicImpl1;
import messaging.impl.TopicImpl2;
import messaging.interfaces.Topic;

/**
 * Created by shlok.chaurasia on 26/02/16.
 */
public class TopicFactory {
    public static Topic createTopic(TopicTypeEnum topicTypeEnum)
    {
        if(topicTypeEnum==TopicTypeEnum.TYPE_1)
            return new TopicImpl1<>();
        if(topicTypeEnum==TopicTypeEnum.TYPE_2)
            return new TopicImpl2<>();

        return  null;
    }
}
