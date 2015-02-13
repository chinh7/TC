package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by leducduy on 11/11/14.
 */
public class R277D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if(n%2==0) System.out.println(n/2); else System.out.println(n/2-n);
    }
}
