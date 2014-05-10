package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/4/14.
 */
public class R244D2E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[] countL = new int[m];
        int[] countR = new int[m];
        long distanceL=0;
        long distanceR=0;
        for(int i=1; i<n; i++){
            countR[i%m]++;
            if(i%m==(n-1)%m) distanceR+=numbers[i]-numbers[0];
        }
        long result = distanceR*2;
        for(int i=1; i<n; i++){
            countL[(i-1)%m]++;
            distanceL += (long)countL[0]*(numbers[i]-numbers[i-1]);
            distanceR -= (long)countR[(n-1)%m]*(numbers[i]-numbers[i-1]);
            result = Math.min(result, (distanceL+distanceR)*2);
            countR[i%m]--;

        }
        System.out.println(result);
    }
}
