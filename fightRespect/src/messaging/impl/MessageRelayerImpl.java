package messaging.impl;

import messaging.TopicTypeEnum;
import messaging.factories.TopicFactory;
import messaging.interfaces.Message;
import messaging.interfaces.MessageRelayer;
import messaging.interfaces.Receiver;
import messaging.interfaces.Topic;

import java.util.*;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
//Handling Concurrency
public class MessageRelayerImpl<T> implements MessageRelayer {
    public static Map<TopicTypeEnum, List<Receiver>> topicToReceivers = new HashMap<>();
    public static Map<TopicTypeEnum, Topic> topics = new HashMap<>();

    @Override
    public void subscribeReceiverToTopic(TopicTypeEnum topicTypeEnum, Receiver receiver) {
        if (!topicToReceivers.containsKey(topicTypeEnum)) {
            topicToReceivers.put(topicTypeEnum, new ArrayList<>());
        }
        topicToReceivers.get(topicTypeEnum).add(receiver);
    }

    @Override
    public void addTopic(TopicTypeEnum topicTypeEnum) {
        topicToReceivers.put(topicTypeEnum, new ArrayList<>());
    }

    @Override
    public void pushMessage(TopicTypeEnum topic, Message message, int messageGroupId) {
        if (!topics.containsKey(topic)) {
            Topic<T> topicCreated = TopicFactory.createTopic(topic);
            topics.put(topic, topicCreated);
        }

        topics.get(topic).addMessageToGroup(message, messageGroupId);

    }

    @Override
    public synchronized void relayMessageToReceivers(TopicTypeEnum type, int groupId) {
        Topic topicsForType = topics.get(type);
        Collections.sort(topicsForType.getMessagesForGroup(groupId));
        List<Message> messages = topicsForType.getMessagesForGroup(groupId);
        List<Receiver> receivers = topicToReceivers.get(type);
        for (Message message : messages) {
            for (Receiver receiver : receivers) {
                receiver.receiveMessage(message);
            }
        }
    }
}
