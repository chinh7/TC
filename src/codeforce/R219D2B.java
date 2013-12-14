package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class R219D2B {
    static int getLength(long x){
        int count=0;
        while(x>0){
            x/=10;
            count++;
        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long w = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int len=getLength(m);
        long result=0;
        while(true){
            long bound = (long) Math.pow(10, len);
            if((bound-m)>Long.MAX_VALUE/(len*k) || (bound-m)*len*k>w){
                result+=w/(k*len);
                break;
            }
            result+=bound-m;
            w-=(bound-m)*len*k;
            m=bound;
            len++;
        }
        System.out.println(result);
    }

}
