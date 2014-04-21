package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/13/14.
 */
public class R241D2E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] graph = new long[n][n];
        int[][] count = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(i!=j) graph[i][j] = Long.MAX_VALUE/2;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[x-1][y-1]=w;
            graph[y-1][x-1]=w;
            count[x-1][y-1]=1;
            count[y-1][x-1]=1;
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(graph[i][k]+graph[k][j]<=graph[i][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                        count[i][j] = count[i][k]+count[k][j];
                    }
                }
            }
        }
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(i==n-2 && j==n-1) System.out.println(count[i][j]); else System.out.print(count[i][j]+" ");
            }
        }
    }
}
