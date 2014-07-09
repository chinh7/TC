package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 6/13/14.
 */
public class ZeptoC {
    static int dis(String[] a, String[] b){
        int n = a.length;
        int m = a[0].length();
        int ret=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ret+=a[i].charAt(j)!=b[i].charAt(j)?1:0;
            }
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String[][] a = new String[k][n];
        for(int i=0; i<k; i++){
            for(int j=0; j<n; j++){
                a[i][j] = br.readLine();
            }
        }
        k++;
        int[][] weight = new int[k][k];
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(i!=j) weight[i][j] = n*m;
            }
        }
        for(int i=1; i<k; i++){
            for(int j=i+1; j<k; j++){
                weight[i][j]=weight[j][i]=Math.min(n*m, dis(a[i-1],a[j-1])*w);
            }
        }
        int[] best = new int[k];
        boolean[] added = new boolean[k];
        Arrays.fill(best, n*m+1);
        best[0]=0;
        int[] vertices = new int[k];
        int[] types = new int[k];
        int[] prev = new int[k];
        int total=0;
        for(int i=0; i<k; i++){
            int min=n*m+1; int u=-1;
            for(int v=0; v<k; v++){
                if(!added[v] && min>best[v]){
                    min=best[v];
                    u=v;
                }
            }
            if(u<0) break;
            added[u]=true;
            vertices[i]=u;
            types[i]=min==n*m?0:prev[u];
            total+=min;
            for(int v=0; v<k; v++){
                if(!added[v] && best[v]>weight[u][v]){
                    best[v] = weight[u][v];
                    prev[v]=u;
                }
            }
        }
        System.out.println(total);
        for(int i=1; i<k; i++) System.out.println(vertices[i]+" "+types[i]);
    }
}
