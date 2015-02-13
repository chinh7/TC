package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 20/11/2014.
 */
public class R270B {
    static String min(String a, String b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.compareTo(b)<0) return a; else return b;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        String[] first = new String[n];
        String[] last = new String[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            first[i] = st.nextToken();
            last[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken())-1;
        }
        String cur="";
        for(int i=0; i<n; i++){
            int j=a[i];
            String next = null;
            if(first[j].compareTo(cur)>=0) next = first[j];
            if(last[j].compareTo(cur)>=0) next = min(next, last[j]);
            if(next==null){
                System.out.println("NO");
                return;
            }
            cur = next;
        }
        System.out.println("YES");
    }
}
