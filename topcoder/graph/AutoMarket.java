package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/11/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class AutoMarket {
    private int n;
    private boolean[][] graph;
    private int[] numbered;
    int result = 1;
    private void visit(int i){
        numbered[i] = 1;
        for(int j=0; j<n; j++){
            if(graph[i][j]){
                if(numbered[j]==0) visit(j);
                if(numbered[i]<numbered[j]+1) numbered[i] = numbered[j]+1;
            }
        }
        if(result<numbered[i]){
            result = numbered[i];
        }
    }
    public int maxSet(int[] cost, int[] features, int[] fixTimes){
        n = cost.length;
        graph = new boolean[n][n];
        numbered = new int[n];
        int[] degree = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(cost[i]>cost[j] && features[i]<features[j] && fixTimes[i]>fixTimes[j]){
                    graph[i][j] = true;
                    degree[j]++;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(degree[i]==0){
                visit(i);
            }
        }
        return result;
    }
}
