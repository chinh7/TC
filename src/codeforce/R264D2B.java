package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R264D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        int[] s = new int[n];
        s[0] = -a[0];
        for(int i=0; i<n-1; i++) s[i+1] = a[i]-a[i+1];
        for(int i=1; i<n; i++) s[i] += s[i-1];
        int ret=0;
        for(int i=0; i<n; i++){
            ret = Math.min(ret, s[i]);
        }
        System.out.println(-ret);
    }

}
