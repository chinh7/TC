package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by leducduy on 11/11/14.
 */
public class R277_5D2F {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for(int i=0; i<m; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++) a[j]+=s.charAt(j)-'0';
        }
        long[][] dp = new long[n+1][n+1];
        int[] count = new int[2];
        for(int i=0; i<n; i++){
            if(a[i]<2) count[a[i]]++;
        }
        dp[count[0]][count[1]]=1;
            for(int i=n; i>=0; i--){
                for(int j=n-i; j>=0; j--){
                    if(i>=2) dp[i-2][j+2] = (dp[i-2][j+2]+dp[i][j]*i*(i-1)/2)%mod;
                    if(i>=1) dp[i-1][j] = (dp[i-1][j]+dp[i][j]*i*j)%mod;
                    if(j>=2) dp[i][j-2] = (dp[i][j-2]+dp[i][j]*j*(j-1)/2)%mod;
                }
            }
        System.out.println(dp[0][0]);
    }
}
