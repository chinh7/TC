package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by leducduy on 11/11/14.
 */
public class R277D2B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] a = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) a[i][j]=1;
        }
        int[][] b = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                b[i][j] = Integer.parseInt(st.nextToken());
                if(b[i][j]==0){
                    for(int e=0; e<n; e++) a[i][e] = 0;
                    for(int e=0; e<m; e++) a[e][j] = 0;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int cur = 0;
                for(int e=0; e<n; e++) cur |= a[i][e];
                for(int e=0; e<m; e++) cur |= a[e][j];
                if(cur!=b[i][j]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==n-1) System.out.println(a[i][j]); else System.out.print(a[i][j]+" ");
            }
        }
    }
}
