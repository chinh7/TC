package topcoder;

/**
 * Created by chinh on 4/13/14.
 */
public class TwoLLogo {
    public long countWays(String[] grid){
        int n = grid.length;
        int m = grid[0].length();
        int[][] up = new int[n][m];
        int[][] right = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i].charAt(j)=='.'){
                    if(i>0) up[i][j] = up[i-1][j]+1; else up[i][j]=1;
                } else{
                    up[i][j] = 0;
                }
            }
        }
        for(int j=m-1; j>=0; j--){
            for(int i=0; i<n; i++){
                if(grid[i].charAt(j)=='.'){
                    if(j<m-1) right[i][j] = right[i][j+1]+1; else right[i][j]=1;
                } else{
                    right[i][j] = 0;
                }
            }
        }

        long result = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<m-1; j++){
                for(int l=1; l<right[i][j]; l++){
                    int u=i, v=j+l;
                    while(true){
                        v++;
                        if(v>=m){
                            v=0;
                            u++;
                        }
                        if(u>=n) break;
                        int upWithBound = up[u][v];
                        if(v>=j && v<=j+l) upWithBound = Math.min(upWithBound, u-i);
                        if(up[i][j]>1 && upWithBound>1 && right[u][v]>1)
                            result += (up[i][j]-1)*(upWithBound-1)*(right[u][v]-1);
                    }
                }
            }
        }
        return result;
    }
}
