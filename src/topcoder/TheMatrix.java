package topcoder;

/**
 * Created by chinh on 4/30/14.
 */
public class TheMatrix {
    public int MaxArea(String[] board){
        int n = board.length;
        int m = board[0].length();
        int[][] longest = new int[n][m];
        for(int j=0; j<m; j++){
            for(int i=n-1; i>=0; i--){
                if(i<n-1 && board[i].charAt(j)!=board[i+1].charAt(j)) longest[i][j]=longest[i+1][j]+1; else longest[i][j]=1;
            }
        }
        int maxArea=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int e=j;
                int minStretch = Integer.MAX_VALUE;
                while(e<m && (e==j || board[i].charAt(e)!=board[i].charAt(e-1))){
                    minStretch = Math.min(longest[i][e], minStretch);
                    maxArea = Math.max(maxArea, (e-j+1)*minStretch);
                    e++;
                }
            }
        }
        return maxArea;
    }
}
