package messaging.interfaces;

import messaging.TopicTypeEnum;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface Publisher {
    void publish(Message message, TopicTypeEnum topicTypeEnum, int groupId);

}
