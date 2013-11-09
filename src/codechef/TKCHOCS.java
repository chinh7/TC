package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/8/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class TKCHOCS {
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("TKCHOCS.input"));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int[][] dp = new int[n][n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<=i; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //PO
            for(int i=0; i<n-1; i++){
                int bound = Math.min(i, n-i-2);
                for(int j=0; j<=bound; j++){
                    dp[i][j] = map[i][j];
                    for(int e=-1; e<=1; e++){
                        if(j+e>=0 && j+e<=i-1 ){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j+e]+map[i][j]);
                        }
                    }

                }
            }
            //MANTIS

            for(int j=n-1; j>0; j--){
                int bound = Math.max(j, n - j);
                for(int i=n-1; i>=bound; i--){
                    dp[i][j] = map[i][j];
                    for(int e=-1; e<=1; e++){
                        if(i+e<n && i+e>=j+1){
                            dp[i][j] = Math.max(dp[i][j], dp[i+e][j+1]+map[i][j]);
                        }
                    }
                }
            }

            int diagCount = (n+1)/2;
            int[] sum = new int[diagCount];
            for(int j=0; j<diagCount; j++){
                int i = n-1-j;
                if(j>0) sum[j] = sum[j-1]+map[i][j]; else sum[j] = map[i][j];
            }

            int best = 0;
            for(int jp=0; jp<diagCount; jp++){
                for(int jm=0; jm<diagCount; jm++){
                    int ip = n-1-jp;
                    int im = n-1-jm;

                    int maxp = 0;
                    int maxm = 0;
                    for(int e=-1; e<=1; e++){
                        if(jp+e>=0 && jp+e<=ip-1 ){
                            maxp = Math.max(maxp, dp[ip-1][jp+e]);
                        }
                        if(im+e<n && im+e>=jm+1){
                            maxm = Math.max(maxm, dp[im+e][jm+1]);
                        }
                    }


                    int max = maxp + maxm + Math.max(sum[jp], sum[jm]);
                    if(best<max){
                        best = max;
                    }
                }
            }
            System.out.println(best);
        }

    }

}
