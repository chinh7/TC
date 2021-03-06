package codility;

/**
 * Created by chinh on 7/10/14.
 */
public class Aluminium {
    int calc(int[] A){
        int n = A.length;
        int[] f = new int[n];
        int curMax=f[0]=A[0];
        for(int i=1; i<n; i++){
            curMax = Math.max(curMax, A[i]);
            f[i] = Math.max(f[i-1]+A[i], curMax);
        }
        int curSum = 0;
        int result = curMax;
        for(int i=n; i>=0; i--){
            if(i>0) result = Math.max(result, f[i-1]+curSum);
            if(i<n) curSum = Math.max(0, curSum+A[i]);
        }
        return result;
    }

    public int solution(int[] A) {
        int result = calc(A);
        int n = A.length;
        for(int i=0; i<n/2; i++){
            int tmp = A[i];
            A[i] = A[n-1-i];
            A[n-1-i] = tmp;
        }
        result = Math.max(result, calc(A));
        return result;
    }
}
