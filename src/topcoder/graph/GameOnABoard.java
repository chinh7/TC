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
    private int n,m;
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

    private class Heap{
        Vertex[] container;
        int[][] pos;
        int size = 0;
        public Heap(int n, int m){
            container = new Vertex[n*m];
            pos = new int[n][m];
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++){
                    pos[i][j]=-1;
                }
        }
        public void add(Vertex v){

            if(pos[v.x][v.y]<0){
                container[size] = v;
                pos[v.x][v.y] = size++;
            }
            int i = pos[v.x][v.y];
            int parent = (i-1)/2;
            while(i>0 && container[parent].d>v.d){
                container[i] = container[parent];
                pos[container[i].x][container[i].y] = i;
                i = parent;
                parent = (i-1)/2;
            }
            container[i] = v;
            pos[v.x][v.y] = i;

        }

        public Vertex pop(){

            if (size==0) return null;
            Vertex ret = container[0];
            Vertex v = container[size-1];
            size--;
            int i = 0;
            while(true){
                int child = (i+1)*2-1;
                if(child>=size) break;
                if(child+1<size && container[child+1].d < container[child].d) child++;
                if(v.d <= container[child].d) break;
                container[i] = container[child];
                pos[container[i].x][container[i].y] = i;
                i = child;
            }
            container[i] = v;
            pos[v.x][v.y] = i;

            return ret;
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
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};


        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                Vertex v = new Vertex(i,j,cost[i].charAt(j)-'0');
                vertex_map[i][j] = v;
            }

        int result = INF;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                Heap heap = new Heap(n,m);
                initialize(vertex_map);
                Vertex source = vertex_map[i][j];
                int longest = 0;
                source.d = source.w;
                heap.add(source);
                Vertex end = new Vertex(-1,-1,-1);
                while(true){
                    Vertex u = heap.pop();
                    if(u==null) break;
                    if(longest<u.d){
                        longest=u.d;
                        end = u;
                    }
                    for(int e=0; e<4; e++)
                        if(valid(u.x+x[e], u.y+y[e])){
                            Vertex v = vertex_map[u.x+x[e]][u.y+y[e]];
                            if(v.d>u.d+v.w){
                                v.d = u.d+v.w;
                                heap.add(v);
                                v.d = u.d+v.w;
                            }
                        }
                }
                if(result>longest){
                    result=longest;
                }
            }

        return result;
    }
}
