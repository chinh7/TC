package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/9/14.
 */
public class R254D2B {
    static boolean[] visited;
    static int n;
    static boolean[][] edges;
    static long result=1;
    static void visit(int i){
        visited[i] = true;
        for(int j=0; j<n; j++){
            if(edges[i][j] && !visited[j]){
                result*=2;
                visit(j);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new boolean[n][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            edges[x][y] = edges[y][x] = true;
        }
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visit(i);
            }
        }
        System.out.println(result);
    }
}
