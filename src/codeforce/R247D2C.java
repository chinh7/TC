package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/22/14.
 */
public class R247D2C {
    static final int MOD=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] prev = new int[2][n+1];
        prev[0][0]=1;
        int result=0;
        for(int depth=0; depth<n; depth++){
            int[][] current = new int[2][n+1];
            for(int weight=1; weight<=k; weight++){
                for(int sum=weight+depth; sum<=n; sum++){
                    if(weight<d){
                        current[0][sum] = (current[0][sum]+prev[0][sum-weight])%MOD;
                        current[1][sum] = (current[1][sum]+prev[1][sum-weight])%MOD;
                    } else{
                        current[1][sum] = (current[1][sum]+(prev[0][sum-weight]+prev[1][sum-weight])%MOD)%MOD;
                    }
                }
            }
            result=(result+current[1][n])%MOD;
            prev=current;
        }
        System.out.println(result);
    }
}


