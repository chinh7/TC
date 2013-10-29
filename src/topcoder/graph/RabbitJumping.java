package topcoder.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/21/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class RabbitJumping {
    final int INF = Integer.MAX_VALUE/2;
    private class Segment{
        int x,y;
        public Segment(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    boolean compatible(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        return a%2 == b%2;
    }

    public int getMinimum(int[] holes, int largeJump){
        if(largeJump%2 == 0) return -1;
        int holesN = holes.length/2;
        //number of segments = holesN+1;
        //-INF -> holes[0]-1, holes[1]+1 -> holes[2]-1, ... , holes[holesN*2 - 1]+1 -> 1,000,000,001
        //each node has 2 states: at even & at odd coordinate. each (segment, state) corresponds to a node.
        //the number of nodes is thus 2*(holesN+1).
        //destination is n-1;

        int n = holesN*2+2;
        boolean[][] connected = new boolean[n][n];
        Segment[] cs = new Segment[n];
        for(int i=0; i<holesN+1; i++){
            int left = (i==0) ? -INF : holes[2*i-1]+1; //left end of the segment
            int right = (i==holesN) ? INF : holes[2*i]-1;
            cs[i*2] = new Segment(left, right);
            cs[i*2+1] = new Segment(left, right);
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if((j-i)%2 == 0) continue; //impossible to jump from an odd node directly to an even node or vice versa.
                if(i%2==0 && j-i==1){
                    if(cs[i].y-cs[i].x >= largeJump){
                        connected[i][j] = true;
                        connected[j][i] = true;
                    }
                } else{

                    int startX = compatible(cs[i].x, i) ? cs[i].x : cs[i].x+1;
                    int startY = compatible(cs[i].y, i) ? cs[i].y : cs[i].y-1;

                    int endX = compatible(cs[j].x, i) ? cs[j].x+1 : cs[j].x;
                    int endY = compatible(cs[j].y, i) ? cs[j].y-1 : cs[j].y;

                    if(startX > cs[i].y || endX > cs[j].y || endX > startY+largeJump || startX+largeJump > endY) continue;

                    connected[i][j] = true;
                    connected[i][j] = true;

                }
            }
        }
        ArrayList<Integer> queue = new ArrayList<Integer>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        distance[0] = 0;
        queue.add(0);
        visited[0] = true;
        int head = 0;

        while(head<queue.size()){
            int u = queue.get(head);
            head++;
            for(int v=0; v<n; v++){
                if(!visited[v] && connected[u][v]){
                    visited[v] = true;
                    queue.add(v);
                    distance[v] = distance[u]+1;
                }
            }
        }

        return distance[n-1];
    }
}
