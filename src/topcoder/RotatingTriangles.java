package topcoder;

/**
 * Created by chinh on 06/11/2014.
 */
public class RotatingTriangles {
    int[][] foldedOrWhite;
    int[][] foldedOrBlack;
    boolean folded(char[][] grid, int i, int j){
        return grid[i][j] == '/';
    }
    boolean white(char[][] grid, int i, int j){
        return grid[i][j] == '.';
    }
    boolean black(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        return grid[i][j] == '#';
    }
    boolean allFoldedOrWhite(char[][] grid, int i, int u, int v){
        if(i>=grid.length) return true;
        return (v-foldedOrWhite[i][v]+1<=u);
    }
    boolean allFoldedOrBlack(char[][] grid, int i, int u, int v){
        return (v-foldedOrBlack[i][v]+1<=u);
    }
    char[][] rotate(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        char[][] tmp = new char[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[j][n-i-1] = grid[i][j];
            }
        }
        return tmp;
    }
    int count(char grid[][]){
        int ret = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<=m; j++){
                int r = i;
                int v = j;
                int u = j;
                while(r < n && v<m && !black(grid, r, u-1) && folded(grid, r, v) && allFoldedOrBlack(grid, r, u, v)){
                    if(allFoldedOrWhite(grid, r + 1, u, v)){
                        ret++;
                    }
                    v++;
                    r++;
                }
                r = i;
                u = j-1;
                v = j;
                while(r < n && u>=0 && v<m && folded(grid, r, u) && folded(grid, r, v)  && allFoldedOrBlack(grid, r, u, v)){
                    if(allFoldedOrWhite(grid, r + 1, u, v)){
                        ret++;
                    }
                    u--;
                    v++;
                    r++;
                }
            }
        }
        return ret;
    }
    void prep(char grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        foldedOrWhite = new int[n][m];
        foldedOrBlack = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(black(grid, i, j)) foldedOrWhite[i][j] = 0; else foldedOrWhite[i][j] = j>0?foldedOrWhite[i][j-1]+1:1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(white(grid, i, j)) foldedOrBlack[i][j] = 0; else foldedOrBlack[i][j] = j>0?foldedOrBlack[i][j-1]+1:1;
            }
        }
    }
    public int count(String[] s){
        int n = s.length;
        int m = s[0].length();
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = s[i].charAt(j);
            }
        }
        int ret = 0;
        for(int rotate=0; rotate<4; rotate++){
            prep(grid);
            ret += count(grid);
            grid = rotate(grid);
        }
        return ret;
    }
}
