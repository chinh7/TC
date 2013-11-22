package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/22/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class AstronomicalRecords {
    public int minimalPlanets(int[] A, int[] B){
        int n = A.length;
        int m = B.length;
        int[][] longest = new int[n][m];
        int result = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                longest[i][j] = 1;
                for(int ii=0; ii<i; ii++){
                    for(int jj=0; jj<j; jj++){
                        if((long)A[i]*B[jj] == (long)A[ii]*B[j]){
                            longest[i][j] = Math.max(longest[i][j], longest[ii][jj]+1);
                        }
                    }
                }
                result = Math.max(result, longest[i][j]);
            }
        }

        return n+m-result;
    }
}
