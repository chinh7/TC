package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/27/14.
 */
public class R243D2D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(n<m){
            int[][] b = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    b[i][j] = a[j][i];
                }
            }
            a=b;
            n=n^m; m=n^m; n=n^m;
        }
        int res=Integer.MAX_VALUE;
        if(n<=k){
            for(int row=0; row<(1<<m); row++){
                int curRes = 0;
                for(int i=0; i<n; i++){
                    int diff=Integer.MAX_VALUE;
                    for(int candidate=0; candidate<=1; candidate++){
                        int count=0;
                        for(int j=0; j<m; j++){
                            count+=(((row>>j)&1)^candidate)^a[i][j];
                        }
                        diff=Math.min(count, diff);
                    }
                    curRes+=diff;
                }
                res = Math.min(res, curRes);
            }
        } else{
            for(int fixed=0; fixed<n; fixed++){
                for(int trigger=0; trigger<=1; trigger++){
                    int[] row = new int[m];
                    for(int j=0; j<m; j++) row[j] = a[fixed][j]^trigger;
                    int curRes = 0;
                    for(int i=0; i<n; i++){
                        int diff=Integer.MAX_VALUE;
                        for(int candidate=0; candidate<=1; candidate++){
                            int count=0;
                            for(int j=0; j<m; j++){
                                count+=row[j]^candidate^a[i][j];
                            }
                            diff=Math.min(count, diff);
                        }
                        curRes+=diff;
                    }
                    res = Math.min(res, curRes);
                }
            }
        }
        if(res<=k) System.out.println(res); else System.out.println(-1);
    }
}