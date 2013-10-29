package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/15/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class TeamBuilder {
    private boolean[][] graph;
    private boolean[] visited;
    private int n;

    private void visit(int i){
        visited[i] = true;
        for(int j=0; j<n; j++){
            if(graph[i][j] && !visited[j]){
                visit(j);
            }
        }
    }
    public int[] specialLocations(String[] paths){
        n = paths.length;
        graph = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = (paths[i].charAt(j)=='1');
            }
        }
        int source = 0;
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            visit(i);
            boolean isSource = true;
            for(int j=0; j<n; j++) isSource = isSource && visited[j];
            if(isSource) source++;
        }

        graph = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[j][i] = (paths[i].charAt(j)=='1');
            }
        }
        int drain = 0;
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            visit(i);
            boolean isSource = true;
            for(int j=0; j<n; j++) isSource = isSource && visited[j];
            if(isSource) drain++;
        }

        int[] result = {source, drain};
        return result;

    }
}
