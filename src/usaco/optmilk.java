package usaco;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/14/13
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Optmilk {
    static int[][] cal(int[] a, int i, int j){
        int n = a.length;
        int[][] ret = new int[2][2];
        int[] prev = new int[2];
        int[] cur = new int[2];
        for(int e=i+1; e<=j; e++){
            cur[0] = Math.max(prev[0], prev[1]);
            cur[1] = a[e]+prev[0];
            prev[0] = cur[0]; prev[1] = cur[1];
        }
        ret[0] = prev;

        prev = new int[2];
        prev[1] = a[i];
        for(int e=i+1; e<=j; e++){
            cur[0] = Math.max(prev[0], prev[1]);
            cur[1] = a[e]+prev[0];
            prev[0] = cur[0]; prev[1] = cur[1];
        }
        ret[1] = prev;

        return ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("optmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("optmilk.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());

        int segmentLength = (int) Math.floor(Math.sqrt(n));
        int tailLength = n%segmentLength;
        int segmentN = n/segmentLength + (tailLength>0 ? 1 : 0);

        int[][][] best = new int[segmentN][2][2];
        for(int i=0; i<segmentN; i++){
            int bound;
            if(i==segmentN-1) bound=n; else bound = (i+1)*segmentLength;
            best[i] = cal(a, i*segmentLength, bound-1);
        }

        long result = 0;
        while(d-->0){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken())-1;
            a[j] = Integer.parseInt(st.nextToken());
            int i = j/segmentLength;
            int bound;
            if(i==segmentN-1) bound=n; else bound = (i+1)*segmentLength;
            best[i] = cal(a, i*segmentLength, bound-1);

            int[][] opt = new int[segmentN+1][2];
            for(i=0; i<segmentN; i++){
                for(int e=0; e<=1; e++){
                    int max = 0;
                    for(int u=0; u<=1; u++){
                        for(int v=0; v<=1-u; v++){
                            max = Math.max(max, opt[i][u]+best[i][v][e]);
                        }
                    }
                    opt[i+1][e] = max;
                }
            }
            result += Math.max(opt[segmentN][0], opt[segmentN][1]);
        }
        System.out.println(result);
        out.close();
    }
}
