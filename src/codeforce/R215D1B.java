package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R215D1B {

    static void add(HashMap<Integer, Integer> map, int k){
        int count = 0;
        if(map.containsKey(k)) count = map.get(k);
        map.put(k, count + 1);
    }

    static void remove(HashMap<Integer, Integer> map, int k){
        if(map.containsKey(k)){
            int count = map.get(k);
            if(count==1) map.remove(k); else map.put(k, count-1);
        }
    }

    static int getDifference(HashMap<Integer, Integer> mapA, HashMap<Integer, Integer> mapB, int k){
        int countA = 0;
        int countB = 0;
        if(mapA.containsKey(k)) countA = mapA.get(k);
        if(mapB.containsKey(k)) countB = mapB.get(k);
        return Math.abs(countA-countB);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        for(int i=0; i<m; i++){
            add(mapB, Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<p; i++){
            HashMap<Integer, Integer> mapA = new HashMap<Integer, Integer>();
            int mismatched = m;
            for(int j=0; i+j*p<n; j++){
                if(j>=m){
                    int origDiff = getDifference(mapA, mapB, a[i+(j-m)*p]);
                    remove(mapA, a[i+(j-m)*p]);
                    int diff = getDifference(mapA, mapB, a[i+(j-m)*p]);
                    mismatched+=diff-origDiff;
                }
                int origDiff = getDifference(mapA, mapB, a[i+j*p]);
                add(mapA, a[i+j*p]);
                int diff = getDifference(mapA, mapB, a[i+j*p]);
                mismatched+=diff-origDiff;
                if(mismatched==0) result.add(i+(j-m+1)*p);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            if(i==result.size()-1) System.out.println(result.get(i)+1); else System.out.print((result.get(i)+1)+" ");
        }
    }

}
