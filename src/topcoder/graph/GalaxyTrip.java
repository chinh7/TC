package topcoder.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/31/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GalaxyTrip {
    private int n;
    private boolean[][] graph;
    private boolean[] visited;
    private ArrayList<Integer> sizes = new ArrayList<Integer>();
    private int count;
    private void dfs(int i){
        count++;
        visited[i] = true;
        for(int j=0; j<n; j++){
            if(!visited[j] && graph[i][j]){
                dfs(j);
            }
        }
    }
    public int[] possibleValues(String[] dependencies){
        n = dependencies.length;
        graph = new boolean[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            String[] splits = dependencies[i].split(" ");
            for(String j : splits){
                if(j!="") graph[i][Integer.parseInt(j)] = true;
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count = 0;
                dfs(i);
                sizes.add(count);
            }
        }
        boolean[] possibleValue = new boolean[n+1];
        possibleValue[0] = true;
        count=0;
        for(int size : sizes){
            for(int i=n; i>=size; i--){
                if(!possibleValue[i] && possibleValue[i-size]){
                    possibleValue[i] = true;
                    count++;
                }
            }
        }
        int[] possibleValues = new int[count];
        count=0;
        for(int i=1; i<=n; i++){
            if(possibleValue[i]) possibleValues[count++] = i;
        }
        Arrays.sort(possibleValues);
        return possibleValues;
    }
}
