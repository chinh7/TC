package codility;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chinh on 5/22/14.
 */
public class Magnesium {
    class Edge{
        int x; int y; int w;
        public Edge(int x, int y, int w){
            this.x=x;
            this.y=y;
            this.w=w;
        }
    }
    public int solution(int n, int[] A, int[] B, int[] C) {
        int m = A.length;
        Edge[] edges = new Edge[m];
        for(int i=0; i<m; i++){
            edges[i] = new Edge(A[i],B[i],C[i]);
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });
        int result=0;
        int[] longest = new int[n];
        int[] latest = new int[n];
        for(int i=0; i<m; i++){
            if(longest[edges[i].x]>longest[edges[i].y]){
                if(latest[edges[i].x]<edges[i].w){
                    longest[edges[i].y]=longest[edges[i].x]+1;
                    latest[edges[i].y]=edges[i].w;
                }
            } else if(longest[edges[i].x]<longest[edges[i].y]){
                if(latest[edges[i].y]<edges[i].w){
                    longest[edges[i].x]=longest[edges[i].y]+1;
                    latest[edges[i].x]=edges[i].w;
                }
            } else{
                boolean xUpdated=false;
                boolean yUpdated=false;
                if(latest[edges[i].y]<edges[i].w){
                    longest[edges[i].x]++;
                    xUpdated=true;
                }
                if(edges[i].x!=edges[i].y && latest[edges[i].x]<edges[i].w) {
                    longest[edges[i].y]++;
                    yUpdated=true;
                }
                if(xUpdated) latest[edges[i].x]=edges[i].w;
                if(yUpdated) latest[edges[i].y]=edges[i].w;
            }
        }
        for(int i=0; i<n; i++){
            if(result<longest[i]) result=longest[i];
        }
        return result;
    }
}
