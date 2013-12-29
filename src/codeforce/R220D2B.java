package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/19/13
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class R220D2B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        long result = 1;
        int i = 0;
        while(i<n-1){
            int j=i;
            while(j<n-1 && s.charAt(j)+s.charAt(j+1)-2*'0' == 9) j++;
            int l = j-i+1;
            if(l%2!=0) result *= (l/2+1);
            i = j+1;
        }
        System.out.println(result);

    }
}
