package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R222D2C {
    static int n, m, k, s=0;
    static boolean[] isEmpty;
    static boolean[] isVisited;
    static int count=0;


    static void dfs(int u){
        isVisited[u] = true;
        count++;
        if(count==s-k) return;
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        int i = u/m;
        int j = u%m;
        for(int e=0; e<4; e++){
            if(i+x[e]>=0 && i+x[e]<n && j+y[e]>=0 && j+y[e]<m){
                int v = (i+x[e])*m + j+y[e];
                if(isEmpty[v] && !isVisited[v]){
                    dfs(v);
                    if(count==s-k) return;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isEmpty = new boolean[n*m];
        isVisited = new boolean[n*m];

        int first = -1;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                if(str.charAt(j)=='.'){
                    isEmpty[i*m+j]=true;
                    s++;
                    if(first<0) first=i*m+j;
                }
            }
        }
        dfs(first);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isEmpty[i*m+j]){
                    if(k==0 || isVisited[i*m+j]) System.out.print("."); else{
                        System.out.print("X");
                        k--;
                    }
                }else{
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

}
