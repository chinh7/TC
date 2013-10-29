package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/28/13
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreedyGovernment {
    private int[][] graph;
    private boolean[] visited;
    private int n;
    private int max = 0;
    private class Data{
        int pathCount=0;
        int cost = 0;
        public Data(int pc, int c){
            pathCount = pc;
            cost = c;
        }
    }

    Data dfs(int i){
        visited[i] = true;
        if(i==n-1){
            return new Data(1, 0);
        }
        int pathCount = 0;
        int cost = 0;
        for(int j=0; j<n; j++){
            if(graph[i][j]>=0 && !visited[j]){
                Data data = dfs(j);
                if(data.pathCount>0){
                    if(max<data.pathCount) max = data.pathCount;
                    pathCount+=data.pathCount;
                    cost+=data.cost+graph[i][j]*data.pathCount;
                    visited[j] = false;
                }
            }
        }
        return new Data(pathCount, cost);
    }
    public double maxAverageCost(String[] tolls, int tollHike){
        n = tolls.length;
        graph = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(tolls[i].charAt(j)=='X') graph[i][j]=-1; else graph[i][j]=tolls[i].charAt(j) - '0';
            }
        }
        Data result = dfs(0);
        if(result.pathCount==0) return 0.0;
        return (double)(result.cost+max*tollHike)/result.pathCount;
    }
}
