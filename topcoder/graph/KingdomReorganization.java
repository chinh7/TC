package topcoder.graph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/26/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class KingdomReorganization {
    private final int INF = Integer.MAX_VALUE/2;
    private int getValue(char chr){
        if(chr<='Z') return chr-'A';
        return chr-'a'+26;
    }
    public int getCost(String[] kingdom, String[] build, String[] destroy){
        int n = kingdom.length;
        int[][] cost = new int[n][n];
        int total = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(kingdom[i].charAt(j)=='0')
                    cost[i][j] = getValue(build[i].charAt(j));
                else{
                    cost[i][j] = -getValue(destroy[i].charAt(j));
                    total += getValue(destroy[i].charAt(j));
                }
                cost[j][i] = cost[i][j];
            }
        }
        int[] distance = new int[n];
        boolean[] added = new boolean[n];
        Arrays.fill(distance, INF);
        distance[0] = 0;
        while(true){
            int min=INF;
            int u = -1;
            for(int i=0; i<n; i++){
                if(!added[i] && min>distance[i]){
                    u = i;
                    min = distance[i];
                }
            }
            if(u<0) break;
            added[u] = true;
            total += min;

            for(int v=0; v<n; v++){
                if(!added[v] && distance[v]>cost[u][v]) distance[v]=cost[u][v];
            }
        }
        return total;
    }
}
