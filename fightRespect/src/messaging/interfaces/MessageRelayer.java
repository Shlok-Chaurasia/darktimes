package messaging.interfaces;

import messaging.TopicTypeEnum;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface MessageRelayer {
    void subscribeReceiverToTopic(TopicTypeEnum topicTypeEnum, Receiver receiver);
    void addTopic(TopicTypeEnum topicTypeEnum);
    void relayMessageToReceivers(TopicTypeEnum type, int groupId);
    void pushMessage(TopicTypeEnum topic, Message message, int messageGroupId);
}
