package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/20/14.
 */
public class CoderStrike2014A {
    static String find(int min, int max, int curMin, int curMax, int required){
        if(curMin<min || curMax>max) return "Incorrect";
        if(curMin>min) required--;
        if(curMax<max) required--;
        return required>=0 ? "Correct" : "Incorrect";

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int x = Integer.parseInt(st.nextToken());
            if(curMin>x) curMin=x;
            if(curMax<x) curMax=x;
        }
        System.out.println(find(min, max, curMin, curMax, n-m));
    }

}
