package topcoder;

/**
 * Created by chinh on 29/10/2014.
 */
public class ORSolitaire {

    public int getMinimum(int[] numbers, int goal){
        int m=0, tmp=goal;
        while(tmp>0){
            m++;
            tmp = tmp>>1;
        }
        int[] count = new int[m];
        for(int i=0; i<numbers.length; i++){
            if((goal|numbers[i])==goal){
                for(int j=0; j<m; j++){
                    if(((numbers[i]>>j)&1)>0){
                        count[j]++;
                    }
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            if(((goal>>i)&1)>0){
                ret = Math.min(ret, count[i]);
            }
        }
        return ret;
    }
}
