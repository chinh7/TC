package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/3/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class LightedPanels {
    private int n,m;
    private int[][] grid;
    private int flipped = 0, result = -1;
    private boolean valid(int i, int j){
        return (i>=0&&i<n&&j>=0&&j<m);
    }
    private void flip(int i, int j, int[][] grid){
        for(int u=-1; u<2; u++){
            for(int v=-1; v<2; v++){
                if(valid(i+u, j+v)){
                    grid[i+u][j+v]=1-grid[i+u][j+v];
                }
            }
        }
    }
    private void check(int i, int j){
        if(j==m){
            ///main
            int[][] tmp = new int[n][m];
            for(int u=0; u<n; u++){
                for(int v=0; v<m; v++){
                    tmp[u][v] = grid[u][v];
                }
            }

            int added = 0;
            for(int u=1; u<n; u++){
                for(int v=1; v<m; v++){
                    if(tmp[u-1][v-1]==0){
                        flip(u,v,tmp);
                        added++;
                    }
                }
            }
            for(int u=0; u<n; u++){
                for(int v=0; v<m; v++){
                    if(tmp[u][v]==0) return;
                }
            }
            if(result==-1 || result>flipped+added) result = flipped+added;
            return;
        }
        int ii=i-1, jj=j;
        if(i==0){
            ii=i;
            jj=j+1;
        }

        //don't flip i,j
        check(ii, jj);

        //flip i,j
        flip(i,j, grid);
        flipped++;
        check(ii, jj);

        //revert
        flip(i,j, grid);
        flipped--;
    }
    public int minTouch(String[] board){
        n = board.length;
        m = board[0].length();
        grid = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = (board[i].charAt(j)=='*') ? 1 : 0;
            }
        }
        check(n-1, 0);
        return result;
    }
}
