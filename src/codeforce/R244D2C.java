package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/4/14.
 */
public class R244D2C {
    static int n;
    static int curMin, nMin;
    static int[] edges,reversedEdges, d, reversedD;
    static int[] cost;
    static boolean[] visited;
    static ArrayList<Integer> order;
    static void label(int x){
        visited[x]=true;
        for(int i=d[x]; i<d[x+1]; i++){
            if(!visited[edges[i]]){
                label(edges[i]);
            }
        }
        order.add(x);
    }
    static void calculate(int x){
        visited[x]=true;
        if(curMin>cost[x]){
            curMin=cost[x];
            nMin=1;
        } else if(curMin==cost[x]){
            nMin++;
        }
        for(int i=reversedD[x]; i<reversedD[x+1]; i++){
            if(!visited[reversedEdges[i]]){
                calculate(reversedEdges[i]);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        d = new int[n+1];
        reversedD = new int[n+1];
        int[] x = new int[m];
        int[] y = new int[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            d[x[i]]++;
            reversedD[y[i]]++;
        }
        for(int i=0; i<n; i++){
            d[i+1]+=d[i];
            reversedD[i+1]+=reversedD[i];
        }
        edges = new int[m];
        reversedEdges = new int[m];
        for(int i=0; i<m; i++){
            edges[d[x[i]]-1] = y[i];
            reversedEdges[reversedD[y[i]]-1] = x[i];
            d[x[i]]--;
            reversedD[y[i]]--;
        }
        visited = new boolean[n];
        order = new ArrayList<Integer>();
        Arrays.fill(visited, false);
        for(int i=0; i<n; i++){
            if(!visited[i]) label(i);
        }
        Arrays.fill(visited, false);

        long minCount=1;
        long minCost=0;
        for(int i=n-1; i>=0; i--){
            if(!visited[order.get(i)]){
                curMin = Integer.MAX_VALUE;
                nMin = 1;
                calculate(order.get(i));
                minCost+=curMin;
                minCount = (minCount*nMin)%1000000007;
            }
        }
        System.out.println(minCost+" "+minCount);
    }
}
