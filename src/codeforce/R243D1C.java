package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chinh on 4/27/14.
 */
public class R243D1C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<Integer, TreeSet<Integer>>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int value = Integer.parseInt(st.nextToken());
            if(!map.containsKey(value)){
                map.put(value, new TreeSet<Integer>());
            }
            map.get(value).add(i);
        }
        int maxScore = s/e;
        int[] best = new int[maxScore+1];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[0]=-1;
        int result=0;
        for(int i=0; i<n; i++){
            for(int score=maxScore-1; score>=0; score--){
                if(best[score]!=Integer.MAX_VALUE){
                    if(map.containsKey(a[i])){
                        int key = best[score]+1;
                        Integer next = map.get(a[i]).ceiling(key);
                        if(next!=null){
                            best[score+1] = Math.min(best[score+1],next);
                            if(i+1+best[score+1]+1+(long)e*(score+1)<=s) result=Math.max(result, score+1);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}