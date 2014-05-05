package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/24/14.
 */
public class CoderStrikeDiv1C {
    static int find(int[] sorted, int key){
        int l=0, r=sorted.length;
        while(l<r){
            int mid = (l+r)/2;
            if(sorted[mid]>=key) r=mid; else l=mid+1;
        }
        if(l<sorted.length && sorted[l]<key) return 0;
        return sorted.length-l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] degree = new int[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            degree[x]++;
            degree[y]++;
            ArrayList<Integer> list;
            if(map.containsKey(x)){
                list = map.get(x);
            } else{
                list = new ArrayList<Integer>();
                map.put(x, list);
            }
            list.add(y);
            if(map.containsKey(y)){
                list = map.get(y);
            } else{
                list = new ArrayList<Integer>();
                map.put(y, list);
            }
            list.add(x);
        }
        int[] sortedDegree = Arrays.copyOf(degree, degree.length);
        Arrays.sort(sortedDegree);
        long result=0;
        int[] edgesCount = new int[n];
        for(int i=0; i<n; i++){
            int required = p - degree[i];
            int eligible = find(sortedDegree, required);
            if(map.containsKey(i)){
                ArrayList<Integer> list = map.get(i);
                int count=0;
                for(int j : list){
                    edgesCount[j]++;
                }
                for(int j : list){
                    if(edgesCount[j]>0){
                        if(degree[j]-edgesCount[j]+1<=required && degree[j]>=required) count++;
                        edgesCount[j]=0;
                    }
                }
                eligible-=count;
            }
            if(degree[i]*2L>=p) eligible--;
            result+=eligible;
        }
        System.out.println(result/2);
    }
}
