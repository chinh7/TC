package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R258D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] b = a.clone();
        Arrays.sort(a);
        int i=0;
        while(i<n && a[i]==b[i]) i++;
        int j=n-1;
        while(j>=0 && a[j]==b[j]) j--;
        for(int e=i; e<=j; e++){
            if(b[e]!=a[j-e+i]){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
        if(i>=n || j<0) System.out.println("1 1"); else
        System.out.println((i+1)+" "+(j+1));
    }
}
