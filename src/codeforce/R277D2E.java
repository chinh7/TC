package codeforce;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by leducduy on 11/11/14.
 */
public class R277D2E {
    static class Data implements Comparable<Data>{
        int index; int value;
        public Data(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data data) {
            if(this.value!=data.value) return this.value-data.value;
            return data.index-this.index;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] longest = new int[n];
        int[] c = new int[n+1];
        Arrays.fill(c, Integer.MAX_VALUE);
        c[0] = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int l=0, r=n;
            while(l<r){
                int mid = (r-l+1)/2+l;
                if(c[mid]<a[i]) l=mid; else r=mid-1;
            }
            longest[i] = l + 1;
            c[longest[i]] = Math.min(c[longest[i]], a[i]);
        }
        HashMap<Integer, TreeSet<Data>> map = new HashMap<Integer, TreeSet<Data>>();
        for(int i=0; i<n; i++){
            int l = longest[i];
            if(!map.containsKey(l)) map.put(l, new TreeSet<Data>());
            TreeSet<Data> set = map.get(l);
            set.add(new Data(i, a[i]));
        }
        //done calc lis list

        int longestLength=0;
        for(int i=0; i<n; i++){
            longestLength = Math.max(longestLength, longest[i]);
        }
        //done getting the lis


        int[] types = new int[n];
        Arrays.fill(types, 1);
        for(int i=n; i>=0; i--){
            if(i<n) map.get(longest[i]).remove(new Data(i, a[i]));
            int l = i==n ? longestLength : longest[i]-1;
            if(l==0) continue;
            TreeSet<Data> set = map.get(l);
            if(i==n || types[i]>1){
                int cap = (i==n?Integer.MAX_VALUE:a[i]);
                while(set.size()>0 && set.first().value<cap){
                    types[set.pollFirst().index] = 2;
                }
            }
        }
        //done marking numbers belong to at least one lis

        HashMap<Integer, Integer> occurrence = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            if(types[i]>1){
                if(!occurrence.containsKey(longest[i])) occurrence.put(longest[i], 0);
                occurrence.put(longest[i], occurrence.get(longest[i])+1);
            }
        }

        for(int i=0; i<n; i++){
            if(types[i]>1 && occurrence.get(longest[i])==1) types[i] = 3;
        }

        for(int i=0; i<n; i++){
            System.out.print(types[i]);
        }
        System.out.println();
    }
}
