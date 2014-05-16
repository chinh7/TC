package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chinh on 5/16/14.
 */
public class R246D2D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] p = new int[n+1];
        p[0] = -1;
        int k = -1;
        for(int i=1; i<=n; i++) {
            while(k >= 0 && s.charAt(k) != s.charAt(i-1))
                k = p[k];
            p[i] = ++k;
        }
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start=n;
        while(p[start]>0){
            start = p[start];
            map.put(start,1);
        }
        for(int i=1; i<=n; i++){
            start = i;
            while(p[start]>0){
                start = p[start];
                if(map.containsKey(start)) map.put(start, map.get(start)+1);
            }
        }
        map.put(n,1);
        SortedSet<Integer> keys = new TreeSet<Integer>(map.keySet());
        System.out.println(map.size());
        for(int key : keys){
            System.out.println(key+" "+map.get(key));
        }

    }

}
