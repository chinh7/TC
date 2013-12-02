package topcoder.graph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/2/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoxAndTouristFamilies {
    boolean[][] connected;
    boolean[] visited;
    int[] familyCount;
    int n;
    int[] count(int i){
        visited[i] = true;
        int nFamily = familyCount[i];
        int nEdge=1;
        for(int j=0; j<n; j++){
            if(connected[i][j] && !visited[j]){
                int[] ret=count(j);
                nFamily+=ret[0];
                nEdge+=ret[1];
            }
        }
        int[] result = {nFamily, nEdge};
        return result;
    }
    double pow(double a, int x){
        if(x==0) return 1;
        if(x%2==0){
            double i = pow(a, x/2);
            return i*i;
        } else{
            return a*pow(a, x-1);
        }
    }

    public double expectedLength(int[] A, int[] B, int[] f){
        //assume there is no duplicated edge.

        n = A.length+1;
        int m = f.length;

        connected = new boolean[n][n];
        familyCount = new int[n];
        visited = new boolean[n];

        for(int i=0; i<m; i++){
            familyCount[f[i]]++;
        }

        for(int i=0; i<n-1; i++){
            connected[A[i]][B[i]] = true;
            connected[B[i]][A[i]] = true;
        }

        double result=0;
        for(int i=0; i<n-1; i++){
            Arrays.fill(visited, false);
            visited[B[i]] = true;
            int[] aCount = count(A[i]);

            Arrays.fill(visited, false);
            visited[A[i]] = true;
            int[] bCount = count(B[i]);

            result+=pow((double)aCount[1]/(n-1), bCount[0])*pow((double)bCount[1]/(n-1), aCount[0]);
        }
        return result;
    }
}
