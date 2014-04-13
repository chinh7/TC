package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/6/14.
 */
public class R240D2D {
    static final int MOD = (int)1e9+7;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++) dp[i][1]=1;
        for(int l=2; l<=k; l++){
            for(int i=1; i<=n; i++){
                int j=1;
                while(i*j<=n){
                    dp[i][l]=(dp[i][l]+dp[i*j][l-1])%MOD;
                    j++;
                }
            }
        }
        int result=0;
        for(int i=1; i<=n; i++) result = (result+dp[i][k])%MOD;
        System.out.println(result);
    }

}
