package topcoder.graph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/19/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivateGame {
    int[] parent;
    private class Edge implements Comparable<Edge>{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return o.w-this.w;
        }
    }
    private int getValue(char c){
        if(c>='0' && c<='9') return c-'0';
        if(c>='a' && c<='z') return c-'a'+10;
        if(c>='A' && c<='Z') return c-'A'+36;
        return -1;
    }

    private int find(int u){
        if(u==parent[u]) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }

    private void union(int u, int v){
        int uu = find(u);
        int vv = find(v);
        if(uu!=vv){
            parent[vv] = uu;
        }
    }

    public int findMaxScore(String[] grid){
        int n = grid.length;
        if(n==0) return 0;
        int m = grid[0].length();
        int N = n*m;
        int E = 0;
        Edge[] edges = new Edge[(n-1)*m+(m-1)*n];
        for(int i=0; i<n; i++){
            m = grid[i].length();
            for(int j=0; j<m; j++){
                int u = i*m+j;
                if(i+1<n){
                    int v = (i+1)*m+j;
                    int w = Math.abs(getValue(grid[i].charAt(j)) - getValue(grid[i+1].charAt(j)));
                    edges[E++] = new Edge(u,v,w);

                }
                if(j+1<m){
                    int v = i*m+j+1;
                    int w = Math.abs(getValue(grid[i].charAt(j)) - getValue(grid[i].charAt(j+1)));
                    edges[E++] = new Edge(u,v,w);
                }
            }
        }
        assert E==(n-1)*m+(m-1)*n;
        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
        Arrays.sort(edges);
        int result=0;
        for(int i=0; i<E; i++){
            if(find(edges[i].u)!=find(edges[i].v)){
                result+=edges[i].w;
                union(edges[i].u, edges[i].v);
            }
        }

        return result;
    }
}
