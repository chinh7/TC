package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/11/14.
 */
public class R245D2D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] topLeft = new long[n][m];
        long[][] bottomLeft = new long[n][m];
        long[][] topRight = new long[n][m];
        long[][] bottomRight = new long[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                topLeft[i][j] = Math.max(i>0?topLeft[i-1][j]:0, j>0?topLeft[i][j-1]:0)+a[i][j];
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<m; j++){
                bottomLeft[i][j] = Math.max(i<n-1?bottomLeft[i+1][j]:0, j>0?bottomLeft[i][j-1]:0)+a[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){
                topRight[i][j] = Math.max(i>0?topRight[i-1][j]:0, j<m-1?topRight[i][j+1]:0)+a[i][j];
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                bottomRight[i][j] = Math.max(i<n-1?bottomRight[i+1][j]:0, j<m-1?bottomRight[i][j+1]:0)+a[i][j];
            }
        }
        long max = 0;
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                max = Math.max(max, topLeft[i-1][j]+bottomRight[i+1][j]+bottomLeft[i][j-1]+topRight[i][j+1]);
                max = Math.max(max, topLeft[i][j-1]+bottomRight[i][j+1]+bottomLeft[i+1][j]+topRight[i-1][j]);
            }
        }
        System.out.println(max);
    }

}

