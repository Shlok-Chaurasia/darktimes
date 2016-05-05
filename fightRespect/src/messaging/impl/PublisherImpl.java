package messaging.impl;

import messaging.TopicTypeEnum;
import messaging.interfaces.Message;
import messaging.interfaces.MessageRelayer;
import messaging.interfaces.Publisher;

/**
 * Created by shlok.chaurasia on 26/02/16.
 */
public class PublisherImpl<T> implements Publisher {
    MessageRelayer messageRelayer;

    public PublisherImpl() {
        this.messageRelayer = new MessageRelayerImpl<>();
    }

    @Override
    public void publish(Message message, TopicTypeEnum topicTypeEnum, int groupId) {
        messageRelayer.pushMessage(topicTypeEnum, message, groupId);
    }

}
