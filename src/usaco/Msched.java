package usaco;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/18/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Msched {
    static int count = 0;
    static int[] sorted;
    static int[] pointer, edges;
    static boolean[] checked;
    static void dfs(int i){
        for(int e=pointer[i]; e<pointer[i+1]; e++){
            if(!checked[edges[e]]) dfs(edges[e]);
        }
        checked[i] = true;
        sorted[count++] = i;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("msched.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msched.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sorted = new int[n];
        checked = new boolean[n];
        int[] time = new int[n];
        for(int i=0; i<n; i++){
            time[i] = Integer.parseInt(br.readLine());
        }
        int[] incomingCount = new int[n];
        pointer = new int[n+1];
        edges = new int[m];
        int[] x = new int[m];
        int[] y = new int[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            pointer[y[i]]++;
            incomingCount[x[i]]++;
        }
        for(int i=0; i<n; i++) pointer[i+1]+=pointer[i];
        for(int i=0; i<m; i++){
            edges[--pointer[y[i]]] = x[i];
        }
        for(int i=0; i<n; i++){
            if(incomingCount[i]==0){
                dfs(i);
            }
        }
        int[] max = new int[n];
        for(int u=0; u<n; u++){
            int i = sorted[u];
            max[i] = time[i];
            for(int e=pointer[i]; e<pointer[i+1]; e++){
                int j = edges[e];
                max[i] = Math.max(max[i], max[j]+time[i]);
            }
        }
        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(result, max[i]);
        }
        System.out.println(result);
        out.close();
    }
}
