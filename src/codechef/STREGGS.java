package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/9/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class STREGGS {
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("STREGGS.input"));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int[][] dp = new int[n][k+1];

            for(int i=0; i<n; i++) dp[i][1] = (n-i)*a[i];
            for(int eggsBroken=2; eggsBroken<=k; eggsBroken++){
                for(int i=0; i<n; i++){
                    dp[i][eggsBroken] = Integer.MAX_VALUE;
                    for(int j=i+1; j<n; j++){
                        if(dp[j][eggsBroken-1]<Integer.MAX_VALUE)
                            dp[i][eggsBroken] = Math.min(dp[i][eggsBroken], a[i]*(j-i)+dp[j][eggsBroken-1]);
                    }
                }
            }
            int result = dp[0][k];
            for(int i=1; i<n; i++) result=Math.min(result, dp[i][k]);
            System.out.println(result);

        }
    }
}