package usaco;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/20/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mroute {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("mroute.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mroute.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int[][] l = new int[n][n];
        int[][] c = new int[n][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            l[x][y] = Integer.parseInt(st.nextToken());
            c[x][y] = Integer.parseInt(st.nextToken());
            l[y][x] = l[x][y];
            c[y][x] = c[x][y];
        }
        int[] best = new int[n];
        int[] minC = new int[n];
        int[] totalL = new int[n];
        boolean[] relaxed = new boolean[n];
        Arrays.fill(best, INF);
        best[0] = 0;
        totalL[0] = 0;
        minC[0] = INF;
        while(true){
            int min = INF;
            int j=-1;
            for(int i=0; i<n; i++){
                if(!relaxed[i] && min>best[i]){
                    min=best[i];
                    j=i;
                }
            }
            if(j<0) break;
            relaxed[j] = true;
            for(int i=0; i<n; i++){
                if(l[j][i]>0){
                    int candidate = totalL[j]+l[j][i]+v/Math.min(minC[j],c[j][i]);
                    if(best[i]>candidate){
                        best[i] = candidate;
                        totalL[i] = totalL[j]+l[j][i];
                        minC[j] = Math.min(minC[j], c[j][i]);
                    } else
                    if(best[i]==candidate){
                        if(minC[j]>c[j][i]){
                            totalL[i] = totalL[j]+l[j][i];
                            minC[j] = c[j][i];
                        }
                    }
                }
            }
        }
        System.out.println(best[n-1]);
        out.close();
    }
}
