package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/19/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ColorfulWolves {
    private final int INF = Integer.MAX_VALUE/4;
    public int getmin(String[] colormap){
        int n = colormap.length;
        int[][] d = new int[n][n];

        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                if(colormap[i].charAt(j) == 'Y'){
                    d[i][j]=count;
                    count++;
                } else{
                    if(i!=j) d[i][j]=INF;
                }
            }
        }

        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    if(d[i][j] > d[i][k]+d[k][j]) d[i][j] = d[i][k]+d[k][j];
        if(d[0][n-1]!=INF) return d[0][n-1]; else return -1;
    }
}
