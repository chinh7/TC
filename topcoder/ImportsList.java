package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/6/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImportsList {
    private boolean[][] graph;
    private boolean[] visited;
    int n;
    private void dfs(int root, int i){
        visited[i] = true;
        for(int j=0; j<n; j++){
            if(graph[i][j]){
                if(visited[j]){
                    graph[root][j] = false;
                } else{
                    dfs(root, j);
                }
            }
        }
    }
    public int[] importsCount(String[] requires){
        n = requires.length;
        graph = new boolean[n][n];
        visited = new boolean[n];

        graph = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(requires[i].charAt(j)=='Y') graph[i][j] = true;
            }
        }
        for(int i=0; i<n; i++){
            Arrays.fill(visited,false);
            dfs(i, i);
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(graph[i][j]) count++;
            }
            result[i] = count;
        }
        return result;
    }
}
