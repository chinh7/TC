package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/6/14.
 */
public class R239D2D {
    static final int MOD = (int)1e9+7;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[] d = new int[n];
        for(int i=0; i<n; i++){
            int step = 2;
            for(int j=p[i]; j<i; j++){
                step = (step+d[j])%MOD;
            }
            d[i] = step;
        }
        int ret = 0;
        for(int i=0; i<n; i++) ret = (ret+d[i])%MOD;
        System.out.println(ret);
    }
}
