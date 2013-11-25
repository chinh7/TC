package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/25/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class MMATCH {
    static final int INF = Integer.MAX_VALUE;
    static int[][] a;
    static int[] p;
    static int f;
    static void augmentPath(int v, int minEdge){
        if(v==0){
            f = minEdge;
            return;
        }
        if(p[v]>=0){
            augmentPath(p[v], Math.min(minEdge, a[p[v]][v]));
            a[p[v]][v] -= f;
            a[v][p[v]] += f;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("MMATCH.in"));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int n = L+B+2;
            a = new int[n][n];
            p = new int[n];
            while(true){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(x==0 && y==0) break;
                y+=L;
                a[0][x] = 1;
                a[x][y] = 1;
                a[y][n-1] = 1;
            }
            int maxFlow = 0;
            while(true){
                ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
                Arrays.fill(p,-1);
                queue.offer(0);
                p[0] = 0;
                while(!queue.isEmpty()){
                    int u = queue.poll();
                    if(u==n-1) break;
                    for(int v=0; v<n; v++){
                        if(a[u][v]>0 && p[v]<0){
                            queue.offer(v);
                            p[v] = u;
                        }
                    }
                }
                f=0;
                augmentPath(n-1, INF);
                if(f==0) break;
                maxFlow+=f;
            }
            System.out.println(maxFlow);
        }
    }
}
