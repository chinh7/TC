package topcoder;

/**
 * Created by chinh on 21/11/2014.
 */
public class RandomAppleEasy {
    public 	double theRed(int[] red, int[] green){
        int n = red.length;
        int m = n*10;
        int[][] count = new int[m+1][m+1];
        count[0][0]=1;
        for(int e=0; e<n; e++){
            for(int i=m; i>=red[e]; i--){
                for(int j=m; j>=green[e]; j--){
                    count[i][j] += count[i-red[e]][j-green[e]];
                }
            }
        }
        double x = 0, y=0;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=m; j++){
                if(i+j==0) continue;
                x += count[i][j]*i*1.0/(i+j);
                y += count[i][j];
            }
        }
        return x/y;

    }
}
