package dp;

/**
 * Created by shlok.chaurasia on 24/03/16.
 */
public class DpQuestions {

    public void eggProblem(int floors, int eggs)
    {
        int dpArr[][]= new int[floors+1][eggs+1];
        for(int egg = 0 ; egg<=eggs;egg++)
        {
            dpArr[0][egg] = 0;
            dpArr[1][egg] = 1;
        }

        for(int floor =1; floor<=floors;floor++)
        {
            dpArr[floor][1] = floor;
        }
        for(int floor = 2; floor<=floors;floor++)
        {

            for(int egg = 2; egg<=eggs;egg++)
            {
                int min = Integer.MAX_VALUE;
                for(int k = 1; k <=floor ;k++)
                {
                    int max = 1+ Math.max(dpArr[k-1][egg-1],dpArr[floor - k][egg]);
                    if(max < min)
                        min = max;
                }
                dpArr[floor][egg] = min;
            }
        }
        System.out.print(dpArr[floors][eggs]);
    }
}
