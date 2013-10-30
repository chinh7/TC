package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 10/30/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MayTheBestPetWin {
    public int calc(int[] A, int[] B){
        int sA = 0, sB=0;
        int n = A.length;
        for(int i=0; i<n; i++){
            sA+=A[i];
            sB+=B[i];
        }
        int max = sA+sB;
        boolean[] existing = new boolean[max+1];
        existing[0] = true;
        for(int i=0; i<n; i++){
            for(int j=max-A[i]-B[i]; j>=0; j--){
                if(existing[j]){
                    existing[j+A[i]+B[i]] = true;
                }
            }
        }
        int result = sB;
        for(int i=0; i<=max; i++){
            if(existing[i]){
                result = Math.min(result, Math.max(i-sA, sB-i));
            }
        }
        return result;
    }
}
