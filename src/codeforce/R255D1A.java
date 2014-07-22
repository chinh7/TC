package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R255D1A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] inc = new int[n];
        for(int i=0; i<n; i++){
            if(i>0 && a[i]>a[i-1]){
                inc[i]=inc[i-1]+1;
            } else {
                inc[i]=1;
            }
        }
        int[] dec = new int[n];
        for(int i=n-1; i>=0; i--){
            if(i<n-1 && a[i]<a[i+1]) dec[i]=dec[i+1]+1; else dec[i]=1;
        }
        int result = 1;
        for(int i=0; i<n; i++){
            if(i>0) result = Math.max(result, inc[i-1]+1);
            if(i<n-1) result = Math.max(result, dec[i+1]+1);
            if(i>0 && i<n-1 && a[i+1]-a[i-1]>1){
                result = Math.max(result, inc[i-1]+1+dec[i+1]);
            }
        }
        System.out.println(result);
    }
}
