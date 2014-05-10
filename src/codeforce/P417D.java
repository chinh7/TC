package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/10/14.
 */
public class P417D {
    static class Friend{
        int cost; int monitorCount; int problems;
        public Friend(int cost, int monitorCount, int problems){
            this.cost = cost;
            this.monitorCount = monitorCount;
            this.problems = problems;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        Friend[] friends = new Friend[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int monitorCount = Integer.parseInt(st.nextToken());
            int problemCount = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int problems = 0;
            for(int j=0; j<problemCount; j++){
                int problem = Integer.parseInt(st.nextToken())-1;
                problems |= (1<<problem);
            }
            friends[i] = new Friend(cost, monitorCount, problems);
        }
        Arrays.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return o1.monitorCount-o2.monitorCount;
            }
        });
        long[] min = new long[1<<m];
        Arrays.fill(min, -1);
        min[0]=0;
        long result = -1;
        for(int i=0; i<n; i++){
            for(int j=(1<<m)-1; j>=0; j--){
                int prev = j-(j&friends[i].problems);
                if(min[prev]<0) continue;
                if(min[j]<0 || min[j]>min[prev]+friends[i].cost) min[j]=min[prev]+friends[i].cost;
            }
            if(min[(1<<m)-1]<0) continue;
            if(result<0 || result>min[(1<<m)-1]+friends[i].monitorCount*b) result=min[(1<<m)-1]+friends[i].monitorCount*b;
        }
        System.out.println(result);
    }
}
