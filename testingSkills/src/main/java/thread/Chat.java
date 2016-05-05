package thread;

/**
 * Created by shlok.chaurasia on 07/03/16.
 */
public class Chat {
    boolean flag = false;

    public synchronized void question(String s)
    {
        if(flag)
        {try{
            wait();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        }
        System.out.println(s);
        flag = true;
        notify();
    }
    public synchronized void answer(String s)
    {
        if(!flag)
        {try{
            wait();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        }
        System.out.println(s);
        flag = false;
        notify();
    }

}
