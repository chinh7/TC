package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/28/13
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class R219D2D {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int zeros[][] = new int[n][m]; //zeros[i][j]: number of consecutive 0s from i,j up
        int count[][][][] = new int[n][m][n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                if(s.charAt(j)=='0'){
                    if(i>0) zeros[i][j] = zeros[i-1][j];
                    zeros[i][j] += 1;
                }
            }
            for(int j=m-1; j>=0; j--){
                for(int u=i; u>=0; u--){
                    int min = Math.min(zeros[i][j], i-u+1);
                    count[u][j][i][j] = min;
                    for(int v=j-1; v>=0; v--){
                        min = Math.min(min, zeros[i][v]);
                        count[u][v][i][j] = count[u][v+1][i][j]+min;
                    }
                }
            }
        }
        //up to this point count[u][v][i][j] is the number of squares in (u,v,i,j) which have i,j as the lower right corner

        for(int a=0; a<n; a++){
            for(int b=0; b<m; b++){
                for(int c=a; c<n; c++){
                    for(int d=b; d<m; d++){
                        if(c>a) count[a][b][c][d] += count[a][b][c-1][d];
                        if(d>b) count[a][b][c][d] += count[a][b][c][d-1];
                        if(c>a && d>b) count[a][b][c][d] -= count[a][b][c-1][d-1];
                    }
                }
            }
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            System.out.println(count[a][b][c][d]);
        }
    }
}
