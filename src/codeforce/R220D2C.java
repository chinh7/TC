package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/19/13
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class R220D2C {
    static final int INF = Integer.MAX_VALUE;
    static final HashMap<Character, Character > h = new HashMap<Character, Character>(){{
        put('D','I');
        put('I','M');
        put('M','A');
        put('A','D');
    }};
    static final int[] x = {-1, 0, 1, 0};
    static final int[] y = {0, 1, 0, -1};

    static int n,m;
    static String[] s;
    static int[][] best;
    static boolean[][] visited;
    static int result = 0;

    static int calc(int i, int j){
        if(result==INF) return 0;
        visited[i][j] = true;
        int longest = 0;
        for(int e=0; e<4; e++){
            int u = i+x[e];
            int v = j+y[e];
            if(u>=0 && u<n && v>=0 && v<m && h.get(s[i].charAt(j))==s[u].charAt(v)){
                if(!visited[u][v]){
                    //best[u][v]<0
                    longest = Math.max(longest, calc(u,v));
                } else{
                    if(best[u][v]<0){
                        result = INF;
                    } else{
                        longest = Math.max(longest, best[u][v]);
                    }
                }
            }
            if(result==INF) return 0;
        }
        if(s[i].charAt(j)=='A') best[i][j] = 1; else best[i][j] = 0;
        best[i][j] += longest;
        result = Math.max(result, best[i][j]);
        return best[i][j];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = br.readLine();
        }
        best = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) best[i][j] = -1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(best[i][j]<0 && s[i].charAt(j)=='D'){
                    calc(i,j);
                }
            }
        }
        if(result == 0) System.out.println("Poor Dima!"); else
        if(result == INF) System.out.println("Poor Inna!"); else System.out.println(result);
    }
}
