package patterns.objectPool;

/**
 * Created by shlok.chaurasia on 02/04/16.
 */
public class ReusablePool {
    Resource resources[];
    private volatile static ReusablePool reusablePool;
    private ReusablePool(Integer size)
    {
        resources = new Resource[size];
    }

    public static ReusablePool getInstance()
    {
        if(reusablePool == null)
        {
            synchronized(ReusablePool.class)
            {
                if(reusablePool == null)
                {
                    reusablePool=new ReusablePool(10);
                }
            }
        }
        return reusablePool;
    }


}
