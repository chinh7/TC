package topcoder;


import java.util.ArrayDeque;

/**
 * Created by chinh on 7/22/14.
 */
public class BishopMove {
    class Cell{
        int x; int y; int d;
        public Cell(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    boolean inBound(int x, int y){
        return x>=0 && x<8 && y>=0 && y<8;
    }
    public int howManyMoves(int r1, int c1, int r2, int c2){
        ArrayDeque<Cell> queue = new ArrayDeque<Cell>();
        boolean[][] visited = new boolean[8][8];
        queue.add(new Cell(r1,c1,0));
        int[] e = {-1,1};
        while(!queue.isEmpty()){
            Cell u = queue.poll();
            if(u.x==r2 && u.y==c2) return u.d;
            visited[u.x][u.y] = true;
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    int k=1;
                    while(inBound(u.x+e[i]*k, u.y+e[j]*k) && !visited[u.x+e[i]*k][u.y+e[j]*k]){
                        queue.add(new Cell(u.x+e[i]*k, u.y+e[j]*k, u.d+1));
                        k++;
                    }
                }
            }
        }
        return -1;
    }
}
