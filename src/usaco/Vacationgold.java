package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/14/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vacationgold {
    static final long INF = Long.MAX_VALUE/2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("vacationgold.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("vacationgold.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] x = new int[m];
        int[] y = new int[m];
        int[] w = new int[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            w[i] = Integer.parseInt(st.nextToken());
        }
        int[] hub = new int[k];
        HashMap<Integer, Integer> hubIndex = new HashMap<Integer, Integer>();
        for(int i=0; i<k; i++){
            hub[i] = Integer.parseInt(br.readLine())-1;
            hubIndex.put(hub[i], i);
        }
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> adjW = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<m; i++){
            if(!hubIndex.containsKey(x[i]) && hubIndex.containsKey(y[i])){
                ArrayList<Integer> adjList, adjWList;
                if(adj.containsKey(x[i])){
                    adjList = adj.get(x[i]);
                    adjWList = adjW.get(x[i]);
                } else {
                    adjList = new ArrayList<Integer>();
                    adjWList = new ArrayList<Integer>();
                }
                adjList.add(y[i]);
                adjWList.add(w[i]);
                adj.put(x[i], adjList);
                adjW.put(x[i], adjWList);
            }
        }
        long[][] hubMin = new long[k][k];
        long[][] inHubMin = new long[n][k];
        long[][] outHubMin = new long[k][n];

        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(i!=j) hubMin[i][j] = INF;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                if(!(hubIndex.containsKey(i) && hubIndex.get(i)==j)){
                    inHubMin[i][j] = INF;
                    outHubMin[j][i] = INF;
                }
            }
        }
        for(int i=0; i<m; i++){
            if(hubIndex.containsKey(x[i]) && hubIndex.containsKey(y[i])){
                int xi = hubIndex.get(x[i]);
                int yi = hubIndex.get(y[i]);
                hubMin[xi][yi] = w[i];
            }
            if(hubIndex.containsKey(x[i]) && !hubIndex.containsKey(y[i])){
                int xi = hubIndex.get(x[i]);
                outHubMin[xi][y[i]] = w[i];
            }
            if(!hubIndex.containsKey(x[i]) && hubIndex.containsKey(y[i])){
                int yi = hubIndex.get(y[i]);
                inHubMin[x[i]][yi] = w[i];
            }
        }

        for(int i=0; i<m; i++){
            if(hubIndex.containsKey(x[i]) && !hubIndex.containsKey(y[i])){
                int xi = hubIndex.get(x[i]);
                if(adj.containsKey(y[i])){
                    ArrayList<Integer> adjList = adj.get(y[i]);
                    ArrayList<Integer> adjWList = adjW.get(y[i]);
                    for(int j=0; j<adjList.size(); j++){
                        int yi = hubIndex.get(adjList.get(j));
                        hubMin[xi][yi] = Math.min(hubMin[xi][yi], w[i]+adjWList.get(j));
                    }
                }
            }
        }
        for(int e=0; e<k; e++){
            for(int i=0; i<k; i++){
                for(int j=0; j<k; j++){
                    hubMin[i][j] = Math.min(hubMin[i][j], hubMin[i][e]+hubMin[e][j]);
                }
            }
        }
        for(int i=0; i<m; i++){
            if(hubIndex.containsKey(x[i]) && !hubIndex.containsKey(y[i])){
                int xi = hubIndex.get(x[i]);
                for(int j=0; j<k; j++){
                    outHubMin[j][y[i]] = Math.min(outHubMin[j][y[i]], hubMin[j][xi]+w[i]);
                }
            }
            if(!hubIndex.containsKey(x[i]) && hubIndex.containsKey(y[i])){
                int yi = hubIndex.get(y[i]);
                for(int j=0; j<k; j++){
                    inHubMin[x[i]][j] = Math.min(inHubMin[x[i]][j], hubMin[yi][j]+w[i]);
                }
            }
        }

        ArrayList<Long> result = new ArrayList<Long>();
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            if(hubIndex.containsKey(u) && hubIndex.containsKey(v)){
                int ui = hubIndex.get(u);
                int vi = hubIndex.get(v);
                if(hubMin[ui][vi]!=INF) result.add(hubMin[ui][vi]);
            }
            if(!hubIndex.containsKey(u) && hubIndex.containsKey(v)){
                int vi = hubIndex.get(v);
                if(inHubMin[u][vi]!=INF) result.add(inHubMin[u][vi]);
            }
            if(hubIndex.containsKey(u) && !hubIndex.containsKey(v)){
                int ui = hubIndex.get(u);
                if(outHubMin[ui][v]!=INF) result.add(outHubMin[ui][v]);
            }
            if(!hubIndex.containsKey(u) && !hubIndex.containsKey(v)){
                long min = INF;
                for(int j=0; j<k; j++){
                    if(inHubMin[u][j]!=INF && outHubMin[j][v]!=INF) min = Math.min(min, inHubMin[u][j]+outHubMin[j][v]);
                }
                if(min!=INF) result.add(min);
            }
        }
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++) System.out.println(result.get(i));
        out.close();
    }
}
