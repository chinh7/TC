package topcoder.graph;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/20/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class JumpingBoard {
    private int n,m;
    private String[] graph;
    boolean[][] visited;
    boolean[][] inStack;
    int[][] max;
    boolean loop=false;
    private class Vertex{
        int x, y;
        public Vertex(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private boolean valid(Vertex u){
        return (u.x>=0 && u.x<n && u.y>=0 && u.y<m && graph[u.x].charAt(u.y)!='H');
    }

    private Vertex[] getNeighbors(Vertex u, int step){
        int[] xDiff = {-step, step, 0, 0};
        int[] yDiff = {0, 0, -step, step};
        ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
        for(int i=0; i<4; i++){
            Vertex v = new Vertex(u.x+xDiff[i], u.y+yDiff[i]);
            if(valid(v)){
                neighbors.add(v);
            }
        }
        return neighbors.toArray(new Vertex[0]);
    }

    private void dfs(Vertex u){
        visited[u.x][u.y] = true;
        inStack[u.x][u.y] = true;
        Vertex[] neighbors = getNeighbors(u, graph[u.x].charAt(u.y)-'0');
        if(neighbors.length == 0){
            max[u.x][u.y] = 1;
        } else{
            for(Vertex v : neighbors){
                if(inStack[v.x][v.y]){
                    loop = true;
                    return;
                }
                if(!visited[v.x][v.y]) dfs(v);
                if(loop) return;
                if(max[u.x][u.y] < max[v.x][v.y] + 1) max[u.x][u.y] = max[v.x][v.y] + 1;
            }
        }
        inStack[u.x][u.y] = false;
    }

    public int maxJumps(String[] board){
        n = board.length;
        m = board[0].length();
        graph = board;
        visited = new boolean[n][m];
        inStack = new boolean[n][m];
        max = new int[n][m];
        dfs(new Vertex(0,0));
        if(loop) return -1; else return max[0][0];
    }
}
