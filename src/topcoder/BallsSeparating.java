package topcoder;

/**
 * Created by chinh on 03/11/2014.
 */
public class BallsSeparating {
    public int minOperations(int[] red, int[] green, int[] blue){
        int n = red.length;
        int ret = Integer.MAX_VALUE;
        for(int r=0; r<n; r++){
            for(int g=0; g<n; g++){
                for(int b=0; b<n; b++){
                    if(r!=g && g!=b && b!=r){
                        int cost=0;
                        for(int i=0; i<n; i++){
                            if(i==r){
                                cost += green[i]+blue[i];
                            } else
                            if(i==g){
                                cost += blue[i]+red[i];
                            } else
                            if(i==b){
                                cost += green[i]+red[i];
                            } else{
                                cost += red[i]+green[i]+blue[i]-Math.max(red[i], Math.max(green[i], blue[i]));
                            }
                        }
                        ret = Math.min(ret, cost);
                    }
                }
            }
        }
        return ret;
    }
}
