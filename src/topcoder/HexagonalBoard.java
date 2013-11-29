package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/23/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class HexagonalBoard {
    int[][] colors;
    int required = 0;
    void dfs(String[] board, int i, int j, int color){
        int[] x = {-1,-1,0,1,1,0};
        int[] y = {0,1,1,0,-1,-1};
        int n = board.length;
        colors[i][j] = color;
        for(int e=0; e<6; e++){
            int u = i+x[e];
            int v = j+y[e];
            if(u>=0 && u<n && v>=0  && v<n && board[u].charAt(v)=='X'){
                if(colors[u][v] == 0){
                    required = 2;
                    dfs(board, u, v, 3-color);
                } else{
                    if(colors[u][v] == colors[i][j]) required = 3;
                }
            }
            if(required == 3) return;
        }
    }
    public int minColors(String[] board){
        int n = board.length;
        colors = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i].charAt(j)=='X' && colors[i][j] == 0){
                    required = Math.max(required, 1);
                    dfs(board, i, j, 1);
                }
                if(required == 3) return required;
            }
        }
        return required;
    }
}
