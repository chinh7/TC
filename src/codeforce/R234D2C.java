package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R234D2C {
    static void rotateCw(int[] a, int[] b, int n, int m){
        int p = a.length;
        int[] tmp = new int[p];
        for(int i=0; i<p; i++){
            tmp[i] = b[i];
            b[i] = n-1-a[i];
        }
        for(int i=0; i<p; i++){
            a[i] = tmp[i];
        }
    }
    static void rotateHor(int[] a, int[] b, int n, int m){
        for(int i=0; i<b.length; i++) b[i] = m-1-b[i];
    }
    static void rotateCcw(int[] a, int[] b, int n, int m){
        int p = a.length;
        int[] tmp = new int[p];
        for(int i=0; i<p; i++){
            tmp[i] = a[i];
            a[i] = m-1-b[i];
        }
        for(int i=0; i<p; i++){
            b[i] = tmp[i];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] a = new int[p];
        int[] b = new int[p];
        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken())-1;
            b[i] = Integer.parseInt(st.nextToken())-1;
        }
        int t = n+m;
        for(int i=0; i<x%4; i++){
            rotateCw(a,b,n,t-n);
            n=t-n;
        }
        for(int i=0; i<y%2; i++) rotateHor(a, b, n, t-n);
        for(int i=0; i<z%4; i++){
            rotateCcw(a,b,n,t-n);
            n=t-n;
        }

        for(int i=0; i<p; i++) System.out.println((a[i]+1)+" "+(b[i]+1));
    }
}
