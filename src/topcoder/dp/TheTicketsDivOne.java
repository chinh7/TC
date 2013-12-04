package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/4/13
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheTicketsDivOne {
    public double find(int n, int m){
        double[][] f = new double[n+1][n+1];
        f[1][1] = 1;
        for(int i=2; i<=n; i++){
            double tmp = 1.0/2;
            for(int j=1; j<=i-1; j++){
                f[i][1] = f[i][1]/2+f[i-1][j]/3;
                tmp /= 2;
            }
            f[i][1] = (f[i][1]/2 + 1.0/6)/(1-tmp);
            for(int j=2; j<=i; j++){
                f[i][j] = f[i-1][j-1]/3+f[i][j-1]/2;
            }
        }
        return f[n][m];
    }
}
