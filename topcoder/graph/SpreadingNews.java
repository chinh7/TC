package topcoder.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/26/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpreadingNews {
    private int n;
    private boolean[][] graph;
    private int dfs(int u){
        ArrayList<Integer> cost = new ArrayList<Integer>();
        for(int v=0; v<n; v++){
            if(graph[u][v]){
                int c = dfs(v);
                cost.add(c);
            }
        }
        Collections.sort(cost);
        int max = 0;
        int size = cost.size();
        for(int i=0; i<size; i++){
            if(max<size-i+cost.get(i)) max=size-i+cost.get(i);
        }
        return max;
    }
    public int minTime(int[] supervisors){
        n = supervisors.length;
        graph = new boolean[n][n];
        for(int i=1; i<n; i++){
            graph[supervisors[i]][i] = true;
        }
        return dfs(0);
    }
}
