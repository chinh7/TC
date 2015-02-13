package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R234D2D {
    static final int INF = (int)1e9;
    static int[] par;
    static int find(int i){
        if(par[i]==-1) return i;
        return (par[i]=find(par[i]));
    }
    static void union(int i, int j){
        int x = find(i);
        int y = find(j);
        if(x!=y) par[y] = x;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] type = new int[n];
        int cur = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j=cur; j<cur+num; j++) type[j]=i;
            cur += num;
        }


        int[][] d = new int[k][k];
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(i!=j) d[i][j] = INF;
            }
        }

        par = new int[n];
        Arrays.fill(par, -1);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            if(z==0) union(x,y);
            d[type[x]][type[y]] = d[type[y]][type[x]] = Math.min(d[type[x]][type[y]], z);
        }

        int[] typeRoot = new int[k];
        Arrays.fill(typeRoot, -1);
        for(int i=0; i<n; i++){
            int root = find(i);
            if(typeRoot[type[i]]>=0 && typeRoot[type[i]]!=root){
                System.out.println("No");
                return;
            }
            typeRoot[type[i]] = root;
        }

        for(int e=0; e<k; e++){
            for(int i=0; i<k; i++){
                for(int j=0; j<k; j++){
                    d[i][j] = Math.min(d[i][j], d[i][e]+d[e][j]);
                }
            }
        }
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(d[i][j]==INF) d[i][j]=-1;
            }
        }
        System.out.println("Yes");
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(j==k-1) System.out.println(d[i][j]); else System.out.print(d[i][j]+" ");
            }
        }
    }
}
