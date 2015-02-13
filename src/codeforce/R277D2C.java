package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by leducduy on 11/11/14.
 */
public class R277D2C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken())-1;
        String s = br.readLine();
        int ret=0;
        int first=-1, last=-1;
        for(int i=0; i<n/2; i++){
            if(s.charAt(i)!=s.charAt(n-1-i)){
                int distance = Math.abs(s.charAt(i)-s.charAt(n-1-i));
                int cost = Math.min(distance, 'z'-'a'+1-distance);
                if(first<0) first = i;
                last = i;
                ret += cost;
            }
        }
        if(p>=n/2) p = n-1-p;
        if(first>=0){
            if(p<first) ret += last-p; else
            if(p>last) ret += p-first; else ret += last-first + Math.min(p-first, last-p);
        }
        System.out.println(ret);
    }
}
