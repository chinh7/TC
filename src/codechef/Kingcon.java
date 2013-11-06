package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/5/13
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kingcon {

    static boolean[][] link;
    static int n, count, rootChild;
    static int[] num, low, parent;
    static boolean[] isAP;

    static void number(int u){
        num[u] = low[u] = ++count;
        for(int v=0; v<n; v++){
            if(link[u][v]){
                if(num[v]==0){
                    parent[v] = u;
                    if(u == 0) rootChild++;
                    number(v);
                    if(low[v]>=num[u]) isAP[u] = true;
                    low[u] = Math.min(low[u], low[v]);
                } else{
                    if(parent[u]!=v) low[u] = Math.min(low[u], num[v]);
                }
            }
        }
    }
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Kingcon.input"));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            link = new boolean[n][n];
            num = new int[n];
            low = new int[n];
            parent = new int[n];
            isAP = new boolean[n];
            rootChild = 0;
            count = 0;
            while(m-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                link[x][y] = link[y][x] = true;
            }
            number(0);
            isAP[0] = (rootChild>1);
            int result = 0;
            for(int i=0; i<n; i++){
                if(isAP[i]) result++;
            }
            System.out.println(result*k);
        }
    }

}
