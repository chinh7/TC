package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R258D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cur = n*m;
        int count=0;
        for(int i=n, j=m; cur>0 && i>=1 && j>=1; i--, j--){
            cur -= i+j-1;
            count++;
        }
        if(count%2==1) System.out.println("Akshat"); else System.out.println("Malvika");
    }
}
