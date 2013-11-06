package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/7/13
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class RRGAME {

    private static final int MOD = 1000000007;
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long max = 0;
        long secondMax = 0;
        long sum = 0;
        long a[] = new long[n];
        for(int i=0; i<n; i++){
            long number = Long.parseLong(st.nextToken());
            a[i] = (m-number)/k + 1;
            sum = sum + a[i];
            if(max<a[i]){
                secondMax = max;
                max = a[i];
            }
            else if(secondMax<a[i]) secondMax = a[i];
        }

        long outerMax;
        long lower = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(a[i]==max) outerMax = secondMax; else outerMax = max;
            lower = Math.min(lower, Math.max(outerMax, (sum-a[i]+1)/2));
        }
        long upper = Math.min(sum/2, sum-max);
        System.out.println((upper-lower+1)%MOD);
    }

}
