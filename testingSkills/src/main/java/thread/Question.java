package thread;

/**
 * Created by shlok.chaurasia on 07/03/16.
 */
public class Question implements Runnable{
    Chat chat;
    String question[] = { "Hi", "How are you ?", "I am also doing fine!" };
    public Question(Chat chat) {
        this.chat = chat;
    }

    public void run() {
        for(String q:question)
            chat.question(q);
    }
}
