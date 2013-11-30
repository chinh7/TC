package topcoder;

import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/30/13
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberLabyrinthDiv2 {
    class Node{
        int x,y;
        int k;
        public Node(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
        public boolean isInbound(int n, int m){
            return (x>=0 && x<n && y>=0 && y<m);
        }
    }
    public int getMinimumNumberOfMoves(String[] board, int r1, int c1, int r2, int c2, int k){
        int n = board.length;
        int m = board[0].length();
        int[][][] distance = new int[n][m][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int e=0; e<=k; e++){
                    distance[i][j][e] = -1;
                }
            }
        }
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node source = new Node(r1, c1, 0);
        distance[source.x][source.y][0] = 0;
        queue.add(source);
        while(!queue.isEmpty()){
            Node u = queue.poll();
            if(board[u.x].charAt(u.y)=='.'){
                if(u.k<k){
                    for(int d=1; d<=9; d++){
                        int[] x = {-d,d,0,0};
                        int[] y = {0,0,-d,d};
                        for(int e=0; e<4; e++){
                            Node v = new Node(u.x+x[e], u.y+y[e], u.k+1);
                            if(v.isInbound(n,m) && distance[v.x][v.y][v.k]<0){
                                distance[v.x][v.y][v.k] = distance[u.x][u.y][u.k]+1;
                                queue.offer(v);
                            }
                        }
                    }
                }
            } else{
                int d = Integer.parseInt(board[u.x].charAt(u.y)+"");
                int[] x = {-d,d,0,0};
                int[] y = {0,0,-d,d};
                for(int e=0; e<4; e++){
                    Node v = new Node(u.x+x[e], u.y+y[e], u.k);
                    if(v.isInbound(n,m) && distance[v.x][v.y][v.k]<0){
                        distance[v.x][v.y][v.k] = distance[u.x][u.y][u.k]+1;
                        queue.offer(v);
                    }
                }
            }
        }
        int result = -1;
        for(int i=0; i<=k; i++){
            if(distance[r2][c2][i]>=0){
                if(result<0 || result>distance[r2][c2][i]) result = distance[r2][c2][i];
            }
        }
        return result;
    }
}
