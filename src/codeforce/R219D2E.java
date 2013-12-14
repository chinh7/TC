package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class R219D2E {


    static int[][] M;
    static long[] prev;
    static int log2(int x){
        return (int) (Math.log(x)/Math.log(2));
    }
    static int rqm(int i, int j) {
        int k = log2(j-i+1);
        if (prev[M[i][k]] >= prev[M[j - (1 << k) + 1][k]])
            return M[i][k];
        else
            return M[j - (1 << k) + 1][k];
    }
     static void process(int n) {
        for(int i=0; i<n; i++) M[i][0]=i;
        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                if (prev[M[i][j - 1]] > prev[M[i + (1 << (j - 1))][j - 1]])
                    M[i][j] = M[i][j - 1];
                else
                    M[i][j] = M[i + (1 << (j - 1))][j - 1];
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        M = new int[n][log2(n)+1];
        prev = new long[n];
        int pt = 1;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            long[] cur = new long[n];

            for(int i=0; i<n; i++){
                M[i][0] = i;
                int round = t-pt;
                long max = 0;
                if(t!=1) max = prev[rqm(Math.max(i - d * round, 0), Math.min(i + d * round, n - 1))];
                cur[i] = max+b-Math.abs(a-i-1);
            }
            prev = cur;
            pt = t;
            process(n);
        }
        long max = Long.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max<prev[i]) max=prev[i];
        }
        System.out.println(max);
    }

}
