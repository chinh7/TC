package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R257D1B {
    static class Vertex implements Comparable<Vertex>{
        int label;
        long distance;
        public Vertex(int label, long distance){
            this.label = label;
            this.distance = distance;
        }
        public int compareTo(Vertex o){
            if(this.distance>o.distance) return 1;
            if(this.distance<o.distance) return -1;
            return 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] x = new int[m+k];
        int[] y = new int[m+k];
        int[] z = new int[m+k];
        int[] cursor = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            z[i] = Integer.parseInt(st.nextToken());
            cursor[x[i]]++;
            cursor[y[i]]++;
        }
        boolean[] isStation = new boolean[n];
        for(int i=m; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = 0;
            y[i] = Integer.parseInt(st.nextToken())-1;
            z[i] = Integer.parseInt(st.nextToken());
            cursor[x[i]]++;
            cursor[y[i]]++;
            isStation[y[i]] = true;
        }
        m += k;
        for(int i=0; i<n; i++) cursor[i+1] += cursor[i];
        int[] edges = new int[2*m];
        int[] w = new int[2*m];
        boolean[] isRailroad = new boolean[2*m];
        for(int i=0; i<m; i++){
            edges[--cursor[x[i]]] = y[i];
            edges[--cursor[y[i]]] = x[i];
            w[cursor[x[i]]] = w[cursor[y[i]]] = z[i];
            if(i>=m-k) isRailroad[cursor[x[i]]] = isRailroad[cursor[y[i]]] = true;
        }
        //done building graph

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        distance[0] = 0;
        queue.add(new Vertex(0, 0));
        while(!queue.isEmpty()){
            Vertex u = queue.poll();
            if(u.distance>distance[u.label]) continue;
            for(int i=cursor[u.label]; i<cursor[u.label+1]; i++){
                if(u.distance+w[i]<distance[edges[i]]){
                    distance[edges[i]] = u.distance+w[i];
                    queue.add(new Vertex(edges[i], distance[edges[i]]));
                }
            }
        }
        for(int i=0; i<n; i++){
            if(isStation[i]){
                boolean isRemovable = false;
                for(int e=cursor[i]; e<cursor[i+1]; e++){
                    int j = edges[e];
                    if(!isRailroad[e] && distance[i]==distance[j]+w[e]){
                        isRemovable = true;
                        break;
                    }
                }
                if(!isRemovable) k--;
            }
        }
        System.out.println(k);
    }

}
