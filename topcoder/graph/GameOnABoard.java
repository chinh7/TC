package topcoder.graph;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/25/13
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameOnABoard {
    private final int INF = Integer.MAX_VALUE/2;
    int n,m;
    private class Vertex implements Comparable<Vertex>{
        int x,y,w;
        int d = INF;

        public Vertex(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w  = w;
        }
        public int compareTo(Vertex o){
            return this.d - o.d;
        }
    }

    private boolean valid(int i, int j){
        return (i>=0 && i<n && j>=0 && j<m);
    }

    private void initialize(Vertex[][] vertex_map){
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                vertex_map[i][j].d = INF;
    }


    public int optimalChoice(String[] cost){
        n = cost.length;
        m = cost[0].length();

        Vertex[][] vertex_map = new Vertex[n][m];

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                Vertex v = new Vertex(i,j,cost[i].charAt(j)-'0');
                vertex_map[i][j] = v;
            }

        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>();

        int result = INF;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                initialize(vertex_map);
                Vertex source = vertex_map[i][j];
                int longest = 0;
                source.d = source.w;
                heap.add(source);
                while(true){
                    Vertex u = heap.poll();
                    if(u==null) break;
                    if(longest<u.d) longest=u.d;
                    for(int e=0; e<4; e++)
                        if(valid(u.x+x[e], u.y+y[e])){
                            Vertex v = vertex_map[u.x+x[e]][u.y+y[e]];
                            if(v.d>u.d+v.w){
                                heap.remove(v);
                                v.d = u.d+v.w;
                                heap.add(v);
                            }
                        }
                }
                if(result>longest) result=longest;
            }

        return result;
    }
}
