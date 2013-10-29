package topcoder.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/2/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class RoadReconstruction {
    private int[] parent;
    private class Road implements Comparable<Road>{
        String id;
        int u,v;
        int cost;
        public Road(String id, int u, int v, int cost){
            this.id = id;
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        public int compareTo(Road o){
            if(this.cost!=o.cost) return (this.cost-o.cost);
            return this.id.compareTo(o.id);
        }
    }
    private int find(int u){
        if(parent[u]==-1) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }
    private void union(int u, int v){
        int uu = find(u);
        int vv = find(v);
        if(uu==vv) return;
        parent[uu] = vv;
    }
    public String selectReconstruction(String[] strings){
        int m = strings.length;
        Road[] roads = new Road[m];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = 0;
        for(int i=0; i<m; i++){
            String[] splits = strings[i].split(" ");
            int cost = (splits.length == 4) ? Integer.parseInt(splits[3]) : 0;
            int u, v;
            if(map.containsKey(splits[1])){
                u = map.get(splits[1]);
            } else{
                u = n++;
                map.put(splits[1], u);
            }
            if(map.containsKey(splits[2])){
                v = map.get(splits[2]);
            } else{
                v = n++;
                map.put(splits[2], v);
            }

            roads[i] = new Road(splits[0], u, v, cost);
        }
        parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.sort(roads);

        StringBuilder result = new StringBuilder();
        ArrayList<String> ids = new ArrayList<String>();
        for(Road road : roads){
            if(find(road.u)!=find(road.v)){
                union(road.u, road.v);
                if(road.cost!=0){
                    ids.add(road.id);
                }
            }
        }
        int common = find(0);
        for(int i=1; i<n; i++){
            if(find(i)!=common) return "IMPOSSIBLE";
        }
        Collections.sort(ids);
        for(String id : ids){
            result.append(id+" ");
        }

        return result.toString().trim();
    }
}
