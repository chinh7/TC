package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/4/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Delish {
    static void invert(long[] values){
        for(int i=0; i<values.length/2; i++){
            long tmp = values[i];
            values[i] = values[values.length-1-i];
            values[values.length-i-1] = tmp;
        }
    }
    static void findMax(long[] values, long[] best, int inverted){
        int start = 0, end = values.length-1;
        int lBest = start, rBest = start;
        int l = start, r = start;
        long currentSum = values[start], max = values[start];
        best[start] = currentSum;
        for(int i = start+1; i<=end; i++){
            long value = values[i];
            if(currentSum*inverted >= 0){
                currentSum += values[i];
                r = i;
            } else{
                l = r = i;
                currentSum = values[i];
            }
            if(currentSum*inverted > max*inverted){
                max = currentSum;
                lBest = l;
                rBest = r;
            }
            best[i] = currentSum;
        }
    }
    static long delish2(long[] values){
        int n = values.length;
        long[] leftMax = new long[n];
        long[] leftMin = new long[n];
        long[] rightMax = new long[n];
        long[] rightMin = new long[n];
        findMax(values, leftMax, 1);
        findMax(values, leftMin, -1);
        invert(values);
        findMax(values, rightMax, 1);
        findMax(values, rightMin, -1);
        invert(rightMax); invert(rightMin);
        long result = Long.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            result = Math.max(result,Math.abs(leftMax[i]-rightMin[i+1]));
            result = Math.max(result,Math.abs(rightMax[i+1]-leftMin[i]));
        }
        return result;
    }
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("delish.input"));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] values = new long[N];
            for(int i=0; i<N; i++){
                values[i] = Long.parseLong(st.nextToken());
            }
            System.out.println(delish2(values));
        }

    }
}
