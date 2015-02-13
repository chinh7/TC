package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R253D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int m = s.length();
        int ret = Math.min(n, (m+n)/2);
        int start = ret;
        for(int l=Math.max(n-1,start)+1; l<=Math.min((m+n)/2,m); l++){
            int i = m-(2*l-n);
            int j = i+l-1;
            if(s.startsWith(s.substring(j+1, m), i)) ret = l;
        }
        for(int l=2; l<m; l+=2){
            for(int i=0, j=l-1; j<m; i++, j++){
                if(s.startsWith(s.substring(i+l/2, j+1), i)) ret=Math.max(ret, l/2);
            }
        }
        System.out.println(ret*2);
    }
}
