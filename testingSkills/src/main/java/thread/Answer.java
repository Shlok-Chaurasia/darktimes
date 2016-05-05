package thread;

/**
 * Created by shlok.chaurasia on 07/03/16.
 */
public class Answer implements Runnable {
    Chat chat;
    private final Question question = new Question(chat);
    public Answer(Chat chat) {
        this.chat = chat;
    }

    String Answer[] = { "Hi", "I am good, what about you?", "Great!" };
    public void run() {
        for(String a: Answer)
            chat.answer(a);
    }
}
