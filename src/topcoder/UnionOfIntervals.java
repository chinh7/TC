package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/9/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnionOfIntervals {
    private final int bound = 2000000000;
    public 	int nthElement(int[] lowerBound, int[] upperBound, int n){
        long low = -bound; long hi = bound;
        int length = lowerBound.length;
        n++;
        while(low<=hi){
            int target = (int) ((hi+low)/2);
            int smaller = 0, equal = 0;
            for(int i=0; i<length; i++){
                if(target>=lowerBound[i]){
                    if(target<=upperBound[i]){
                        equal++;
                        smaller+=target-lowerBound[i];
                    } else{
                        smaller+=upperBound[i]-lowerBound[i]+1;
                    }
                }
            }
            if(smaller<n && smaller+equal>=n){
                return target;
            } else
            if(n<=smaller){
                hi = target-1;
            } else
            if(n>smaller+equal){
                low = target+1;
            }
        }
        //should never get here
        return 0;
    }
}
