package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/11/14.
 */
public class R245D2C {
    static int[] d;
    static int[] edges;
    static int[] parent;
    static int result=0;
    static int[] label, target;
    static ArrayList<Integer> picked = new ArrayList<Integer>();
    static void dfs(int u, int depth, int modifiedEven, int modifiedOdd){
        if(depth%2==0){
            if(modifiedEven%2==(label[u]==target[u]?1:0)){
                result++;
                modifiedEven++;
                picked.add(u);
            }
        } else{
            if(modifiedOdd%2==(label[u]==target[u]?1:0)){
                result++;
                modifiedOdd++;
                picked.add(u);
            }
        }
        for(int i=d[u]; i<d[u+1]; i++){
            int v = edges[i];
            if(parent[u]!=v){
                parent[v]=u;
                dfs(v, depth+1, modifiedEven, modifiedOdd);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n-1];
        int[] y = new int[n-1];
        d = new int[n+1];
        label = new int[n];
        target = new int[n];
        parent = new int[n];

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            d[x[i]]++;
            d[y[i]]++;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            label[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++) d[i+1]+=d[i];
        edges = new int[2*n-2];
        for(int i=0; i<n-1; i++){
            edges[--d[x[i]]] = y[i];
            edges[--d[y[i]]] = x[i];
        }
        dfs(0, 0, 0, 0);
        System.out.println(result);
        Collections.sort(picked);
        for(int i : picked){
            System.out.println(i+1);
        }
    }

}

