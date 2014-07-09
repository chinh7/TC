package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by chinh on 6/2/14.
 */
public class R250D2D {
    static int[] parent;
    static int[] size;
    static class Node{
        int index;
        int weight;
        public Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }
    static int find(int x){
        if(x==parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    static long union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if(rx==ry) return 0;
        long ret = (long)size[rx]*size[ry];
        parent[rx]=ry;
        size[ry]+=size[rx];
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++){
            int w = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, w);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.weight-o1.weight;
            }
        });
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }

        int[] x = new int[m];
        int[] y = new int[m];
        int[] d = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            d[x[i]]++;
            d[y[i]]++;
        }
        for(int i=0; i<n; i++) d[i+1]+=d[i];
        int[] edges = new int[m*2];
        for(int i=0; i<m; i++){
            edges[--d[x[i]]]=y[i];
            edges[--d[y[i]]]=x[i];
        }
        double count=0;
        int[] pos = new int[n];
        for(int i=0; i<n; i++){
            pos[nodes[i].index]=i;
        }
        for(Node node : nodes){
            for(int i=d[node.index]; i<d[node.index+1]; i++){
                if(pos[node.index]>pos[edges[i]]){
                    count += union(node.index, edges[i])*node.weight;
                }
            }
        }
        System.out.println(2*count/((long)n*(n-1)));
    }
}

