package topcoder.graph;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/12/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheapestRoute {
    private final int INF = 1000000;
    public int[] routePrice(int[] cellPrice, int[] enterCell, int[] exitCell, int teleportPrice){
        int n = cellPrice.length;
        int[][] graph = new int[n][n];
        int nTeleport = enterCell.length;
        HashMap<Integer, Integer> teleport = new HashMap<Integer, Integer>();
        for(int i=0; i<nTeleport; i++){
            teleport.put(enterCell[i],exitCell[i]);
        }
        for(int i=0; i<n; i++){
            if(cellPrice[i]<0) cellPrice[i] = INF;
            for(int j=0; j<n; j++){
                if(i!=j) graph[i][j] = INF;
            }
        }
        for(int i=0; i<n; i++){
            if(i+1<n){
                graph[i][i+1] = cellPrice[i+1];
            }
            if(i-1>=0){
                graph[i][i-1] = cellPrice[i-1];
            }
            if(teleport.containsKey(i)){
                int j = teleport.get(i);
                if(cellPrice[j]!=INF) graph[i][j] = Math.min(graph[i][j], teleportPrice);
            }
        }

        int[] cheapest = new int[n];
        int[] minStep = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(cheapest, INF);
        Arrays.fill(minStep, INF);
        cheapest[0] = 0;
        minStep[0] = 0;

        while(true){
            int min = INF;
            int u = -1;
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    if(min>cheapest[i]){
                        min = cheapest[i];
                        u = i;
                    }
                }
            }
            if(u<0) break;
            visited[u] = true;
            for(int v=0; v<n; v++){
                if(cheapest[v]>graph[u][v]+cheapest[u]){
                    cheapest[v] = graph[u][v]+cheapest[u];
                    minStep[v] = minStep[u]+1;
                } else
                if(cheapest[v]==graph[u][v]+cheapest[u]){
                    minStep[v] = Math.min(minStep[v], minStep[u]+1);
                }
            }
        }
        int[] result = {cheapest[n-1], minStep[n-1]};
        if(cheapest[n-1]!=INF) return result; else return new int[0];
    }
}
