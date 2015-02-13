package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */

//WA misread the statement. Didn't know changes are saved. To solve this correctly require BIT + binary search
// (replace left[] and right[]) in addition to the current implementation : (
public class R234D2E {
    static long total(long x, int pos){
        return (x*(x+1)/2)<<pos;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = 32;
        long[][] left = new long[max][n];
        long[][] right = new long[max][n];
        for(int pos=0; pos<max; pos++){
            int stretch = 0;
            for(int i=0; i<n; i++) {
                left[pos][i] = stretch;
                if (((a[i] >> pos) & 1) == 1) stretch++; else stretch=0;
            }
        }
        for(int pos=0; pos<max; pos++){
            int stretch = 0;
            for(int i=n-1; i>=0; i--) {
                right[pos][i] = stretch;
                if (((a[i] >> pos) & 1) == 1) stretch++; else stretch=0;
            }
        }


        long sum = 0;
        for(int pos=0; pos<max; pos++){
            for(int i=0; i<n; i++) {
                if (((a[i] >> pos) & 1) == 0) {
                    sum += total(left[pos][i], pos);
                } else{
                    if(i==n-1) sum += total(left[pos][i]+1, pos);
                }
            }
        }
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());
            for(int pos=0; (value>>pos)>0; pos++) {
                if (((value >> pos) & 1) == 1 && ((a[i] >> pos) & 1) == 0) {
                    sum = sum - total(left[pos][i], pos) - total(right[pos][i], pos) + total(left[pos][i]+right[pos][i]+1, pos);
                }
                if (((value >> pos) & 1) == 0 && ((a[i] >> pos) & 1) == 1) {
                    sum = sum + total(left[pos][i], pos) + total(right[pos][i], pos) - total(left[pos][i]+right[pos][i]+1, pos);
                }
            }
            System.out.println(sum);
        }
    }
}
