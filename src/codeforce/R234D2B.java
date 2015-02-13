package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R234D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            int pg = -1;
            int ps = -1;
            String s = br.readLine();
            for(int j=0; j<m; j++){
                if(s.charAt(j)=='G') pg = j;
                if(s.charAt(j)=='S') ps = j;
            }
            a[i] = ps-pg;
            if(a[i]<0){
                System.out.println(-1);
                return;
            }
        }
        Arrays.sort(a);
        int ret=1;
        for(int i=0; i<n-1; i++){
            if(a[i]!=a[i+1]) ret++;
        }
        System.out.println(ret);
    }
}
