package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/22/14.
 */
public class CoderStrikeDiv1B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] startTime = new int[n+1];
        int[] endTime = new int[n+1];
        Arrays.fill(startTime, -1);
        Arrays.fill(endTime, -1);
        Integer leader = null;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("+")){
                int x = Integer.parseInt(st.nextToken());
                if(set.size()==0){
                    if(leader!=null && leader!=x){
                        leader=null;
                    }
                }
                if(i==1) leader=x;
                set.add(x);
                startTime[x]=i;
            } else{
                int x = Integer.parseInt(st.nextToken());
                if(set.size()==0){
                    leader = x;
                } else{
                    if(set.contains(x)){
                        set.remove(x);
                    } else{
                        leader = null;
                    }
                }
                endTime[x]=i;
            }
        }
        if(set.size()>0 && !set.contains(leader)) leader=null;
        if(leader!=null) startTime[leader]=endTime[leader]=-1;
        int count=0;
        for(int i=1; i<=n; i++){
            if(startTime[i]<0 && endTime[i]<0) count++;
        }
        System.out.println(count);
        for(int i=1; i<=n; i++){
            if(startTime[i]<0 && endTime[i]<0){
                count--;
                if(count==0) System.out.println(i); else System.out.print(i+" ");
            }
        }
    }
}