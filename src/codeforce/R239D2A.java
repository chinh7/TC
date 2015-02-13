package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/6/14.
 */
public class R239D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] k = new int[n];
        for(int i=0; i<n; i++){
            k[i] = Integer.parseInt(st.nextToken());
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int total=0;
            for(int j=0; j<k[i]; j++){
                int itemN = Integer.parseInt(st.nextToken());
                total += itemN*5+15;
            }
            min = Math.min(min, total);
        }
        System.out.println(min);
    }
}
