package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 20/11/2014.
 */
public class R270A {
    static int[] parent;
    static int[] cursor;
    static int[] edges;
    static boolean[] visited;
    static int[][] d;
    static boolean valid;
    static class Path implements Comparable<Path>{
        int x,y;
        int length;
        public Path(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
        public int compareTo(Path other){
            return this.length-other.length;
        }
    }
    static int find(int i){
        if(parent[i]<0) return i;
        return (parent[i] = find(parent[i]));
    }
    static void check(int i, int j, int distance){
        if(distance!=d[i][j]) valid=false;
        if(!valid) return;
        visited[j] = true;
        for(int e=cursor[j]; e<cursor[j+1]; e++){
            int t = edges[e];
            if(!visited[t]) check(i, t, distance+d[j][t]);
            if(!valid) return;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //verify
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(d[i][j]!=d[j][i] || (i==j && d[i][j]>0) || (i!=j && d[i][j]==0)){
                    System.out.println("NO");
                    return;
                }
            }
        }
        int p = n*(n-1)/2;
        Path[] paths = new Path[p];
        p=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                paths[p++] = new Path(i, j, d[i][j]);
            }
        }
        Arrays.sort(paths);

        parent = new int[n];
        Arrays.fill(parent, -1);

        int[] x = new int[n-1];
        int[] y = new int[n-1];
        int[] l = new int[n-1];
        cursor = new int[n+1];
        int m = 0;
        for(int i=0; i<p; i++){
            int u = find(paths[i].x);
            int v = find(paths[i].y);
            if(u!=v){
                parent[u] = v;
                x[m] = paths[i].x;
                y[m] = paths[i].y;
                cursor[x[m]]++;
                cursor[y[m]]++;
                m++;
            }
        }
        for(int i=0; i<n; i++) cursor[i+1] += cursor[i];
        edges = new int[2*m];
        for(int i=0; i<m; i++){
            edges[--cursor[x[i]]] = y[i];
            edges[--cursor[y[i]]] = x[i];
        }

        visited = new boolean[n];
        valid = true;
        for(int i=0; i<n; i++){
            Arrays.fill(visited, false);
            check(i, i, 0);
            if(!valid){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

}
