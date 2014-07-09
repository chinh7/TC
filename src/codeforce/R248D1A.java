package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chinh on 5/24/14.
 */
public class R248D1A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        long sum=0;
        for(int i=0; i<m; i++){
            if(i>0) sum+=Math.abs(a[i]-a[i-1]);
            if(i>0 && a[i]!=a[i-1]){
                if(!map.containsKey(a[i])){
                    map.put(a[i], new ArrayList<Integer>());
                }
                map.get(a[i]).add(a[i-1]);
            }
            if(i<m-1 && a[i]!=a[i+1]){
                if(!map.containsKey(a[i])){
                    map.put(a[i], new ArrayList<Integer>());
                }
                map.get(a[i]).add(a[i+1]);
            }
        }
        long max=0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            Integer x = entry.getKey();
            ArrayList<Integer> list = entry.getValue();
            Collections.sort(list);
            int median = list.get(list.size()/2);
            long reduced = 0;
            for(int element : list) reduced = reduced + Math.abs(element-x) - Math.abs(element-median);
            if(max<reduced) max=reduced;
        }
        System.out.println(sum-max);
    }
}
