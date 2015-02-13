package topcoder;

/**
 * Created by chinh on 05/11/2014.
 */
public class ColorfulChocolates {
    public int maximumSpread(String chocolates, int maxSwaps){
        int n = chocolates.length();
        int ret = 0;
        for(int i=0; i<n; i++){
            boolean[] added = new boolean[n];
            added[i] = true;
            int left=i, right=i;
            int swap = 0;
            int count=1;
            while(true){
                int curSwap = 0;
                for(int l=left, r=right; l>=0 || r<n; l--, r++){
                    if(l>=0 && chocolates.charAt(l)==chocolates.charAt(i) && !added[l]){
                        added[l] = true;
                        left--;
                        curSwap=left-l;
                        break;
                    }
                    if(r<n && chocolates.charAt(r)==chocolates.charAt(i) && !added[r]){
                        added[r] = true;
                        right++;
                        curSwap=r-right;
                        break;
                    }
                }
                if(curSwap==0) break;
                if(swap+curSwap>maxSwaps) break;
                swap += curSwap;
                count++;
            }
            ret = Math.max(ret, count);
        }
        return ret;
    }
}
