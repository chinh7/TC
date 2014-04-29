package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/27/14.
 */
public class R243D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum=0, max=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(max<x) max=x;
            sum+=x;
        }
        sum-=max;
        if(sum<=m) System.out.println("YES"); else System.out.println("NO");

    }
}