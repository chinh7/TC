package topcoder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/23/13
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class MazeOnFire {
    private final int INF = Integer.MAX_VALUE/2;
    private int n,m;
    private class Vertex{
        int x, y;
        int d;
        public Vertex(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    private boolean valid(int x, int y){
        return (x<n&&x>=0&&y<m&&y>=0);
    }
    public int maximumTurns(String[] maze){
        n = maze.length;
        m = maze[0].length();
        int[] x = {-1,0,1,0};
        int[] y = {0,-1,0,1};
        int[][] map = new int[n][m];
        int[][] grid = new int[n][m];
        Vertex start = new Vertex(0,0,0); //dummy

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                switch(maze[i].charAt(j)){
                    case 'F':
                        map[i][j]=-1;
                        break;
                    case '#':
                        map[i][j]=-2;
                        break;
                    case '$':
                        start = new Vertex(i,j,0);
                }
            }
        }
        int count=0;
        while(true){
            boolean continued = false;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]==-1){
                        for(int e=0; e<4; e++){
                            if(valid(i+x[e], j+y[e])){
                                if(map[i+x[e]][j+y[e]]==0){
                                    continued = true;
                                    map[i+x[e]][j+y[e]] = -3; //new fire
                                }
                            }
                        }
                    }
                }
            }
            count = continued ? count+1 : INF;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]==-3) map[i][j] = -1;
                    if(map[i][j]==0){
                        grid[i][j] = count;
                    }
                }
            }

            if(!continued) break;

        }

        ArrayList<Vertex> queue = new ArrayList<Vertex>();
        boolean[][] visited = new boolean[n][m];
        queue.add(start);
        visited[start.x][start.y] = true;
        int head = 0;
        int max = grid[start.x][start.y];
        while(head<queue.size()){
            Vertex u = queue.get(head);
            head++;
            for(int e=0; e<4; e++){
                int i = u.x+x[e];
                int j = u.y+y[e];
                if(valid(i,j) && !visited[i][j] && grid[i][j]>u.d){
                    visited[i][j] = true;
                    queue.add(new Vertex(i,j,u.d+1));
                    if(max<grid[i][j]) max = grid[i][j];
                }
            }
        }

        if(max == INF) return -1; else return max+1;
    }
}
