package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/13/14.
 */
public class R241D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int t = Integer.parseInt(st.nextToken());
                int max = 0;
                if(i>0) max = Math.max(max, dp[i-1][j]);
                if(j>0) max = Math.max(max, dp[i][j-1]);
                dp[i][j] = max+t;
            }
            if(i==m-1) System.out.println(dp[i][n-1]); else System.out.print(dp[i][n-1]+" ");
        }
    }
}
