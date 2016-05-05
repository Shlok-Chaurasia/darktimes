package messaging.impl;

import messaging.TopicTypeEnum;
import messaging.interfaces.Topic;

import java.util.HashMap;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class TopicImpl1<T> extends Topic<T> {

    public TopicImpl1() {
        groupIdToMessage = new HashMap<>();
        topicTypeEnum = TopicTypeEnum.TYPE_1;
    }


}
