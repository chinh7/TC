package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/27/14.
 */
public class R243D2B {
    static boolean mirrored(int[][] a, int n, int m){
        if(n%2!=0) return false;
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m; j++){
                if(a[i][j]!=a[n-1-i][j]) return false;
            }
        }
        return true;
    }
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
        while(mirrored(a,n,m)){
            n=n/2;
        }
        System.out.println(n);
    }
}