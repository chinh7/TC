package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/19/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class BunnyConverter {
    public int getMinimum(int nn, int zz, int start, int goal){
        boolean[] checked = new boolean[nn+1];
        long n = nn, z = zz;
        long y = goal;
        int count = 0;
        //backward
        while(y!=start){
            long sum = y*y+z*z*z;
            long k = sum/n+1;
            int x = (int) (k*n-sum);
            if(checked[x]) return -1;
            checked[x] = true;
            y = x;
            count++;
        }
        return count;
    }
}
