package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/1/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class FloodRelief {
    private int n,m;
    private int[][] graph;
    private boolean[][] checked, visited;
    private boolean safe;
    private int[] x = {-1, 0, 1, 0}, y = {0, 1, 0, -1};

    public void dfs(int u, int v){
        if(visited[u][v]) return;
        visited[u][v] = true;
        checked[u][v] = true;

        for(int e=0; e<4; e++){
            int i = u+x[e], j=v+y[e];
            if(i<n && i>=0 && j<m && j>=0 && !visited[i][j]){
                if(graph[i][j]<graph[u][v]){
                    safe = true;
                    return;
                } else
                if(graph[i][j]>graph[u][v]){
                    checked[i][j] = true;
                } else{
                    dfs(i,j);
                }
                if(safe) return;
            }
        }
    }
    public int minimumPumps(String[] heights){
        n = heights.length;
        m = heights[0].length();
        graph = new int[n][m];
        checked = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) graph[i][j] = heights[i].charAt(j) - 'a';
        }
        int ret = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!checked[i][j]){
                    safe = false;
                    visited = new boolean[n][m];
                    dfs(i,j);
                    if(!safe) ret++;
                }
            }
        }
        return ret;

    }

}
