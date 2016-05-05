package patterns.singleton;

/**
 * Created by shlok.chaurasia on 03/02/16.
 */
public class SingletonClass {
    private volatile static SingletonClass singletonClass;

    private SingletonClass() {
    }
    public static SingletonClass getInstance(){
        if(singletonClass==null)
        {
            synchronized (SingletonClass.class)
            {
                if(singletonClass==null)
                {
                    singletonClass=new SingletonClass();
                }
            }
        }
        return singletonClass;
    }
}
