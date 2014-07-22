package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R257D1A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        if(k>n+m-2){
            System.out.println(-1);
            return;
        }
        long result = Math.max(n/(Math.min(k,n-1)+1)*m/(k+1-Math.min(k,n-1)), m/(Math.min(k,m-1)+1)*n/(k+1-Math.min(k,m-1)));
        System.out.println(result);
    }

}
