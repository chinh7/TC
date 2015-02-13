package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 05/11/2014.
 */
public class TimeTravellingSalesman {
    final int INF = Integer.MAX_VALUE;
    public	long determineCost(int n, String[] roads){
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> w = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<roads.length; i++) sb.append(roads[i]);
        StringTokenizer st = new StringTokenizer(sb.toString());
        while(st.hasMoreTokens()){
            StringTokenizer stColon = new StringTokenizer(st.nextToken(),",");
            x.add(Integer.parseInt(stColon.nextToken()));
            y.add(Integer.parseInt(stColon.nextToken()));
            w.add(Integer.parseInt(stColon.nextToken()));
        }
        int m = x.size();
        int[] cursor = new int[n+1];
        for(int i=0; i<m; i++){
            cursor[x.get(i)]++; cursor[y.get(i)]++;
        }
        for(int i=0; i<n; i++) cursor[i+1]+=cursor[i];
        int[] edges = new int[2*m];
        int[] weights = new int[2*m];
        for(int i=0; i<m; i++){
            edges[--cursor[x.get(i)]] = y.get(i);
            edges[--cursor[y.get(i)]] = x.get(i);
            weights[cursor[x.get(i)]] = w.get(i);
            weights[cursor[y.get(i)]] = w.get(i);
        }
        int[] d = new int[n];
        Arrays.fill(d, INF);
        d[0] = 0;
        boolean[] added = new boolean[n];
        long ret = 0;
        for(int i=0; i<n; i++){
            int u=-1;
            for(int j=0; j<n; j++){
                if(!added[j] && (u<0 || d[u]>d[j])){
                    u = j;
                }
            }
            if(d[u]==INF) return -1;
            added[u] = true;
            ret += d[u];
            for(int e=cursor[u]; e<cursor[u+1]; e++){
                int v = edges[e];
                d[v] = Math.min(d[v], weights[e]);
            }
        }
        return ret;
    }
}
