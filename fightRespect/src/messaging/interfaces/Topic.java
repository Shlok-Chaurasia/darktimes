package messaging.interfaces;

import messaging.TopicTypeEnum;
import messaging.interfaces.Message;

import java.util.*;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public abstract class Topic<T> {
    protected  HashMap<Integer, List<Message<T>>> groupIdToMessage;
    protected TopicTypeEnum topicTypeEnum;
    public void addMessageToGroup(Message<T> message, int groupId)
    {
        if(!groupIdToMessage.containsKey(groupId))
            groupIdToMessage.put(groupId, new ArrayList<Message<T>>());
        groupIdToMessage.get(groupId).add(message);
    }
    public List<Message<T>> getMessagesForGroup(int groupId)
    {
        return groupIdToMessage.get(groupId);
    }
    public Set<Integer> getMessageGroupIds()
    {
        return groupIdToMessage.keySet();
    }
}
