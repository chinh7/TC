package topcoder;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/3/13
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeUnion {
    public double expectedCycles(String[] tree1, String[] tree2, int K){
        K-=2;
        StringBuilder sb = new StringBuilder();
        for(String s : tree1) sb.append(s);
        StringTokenizer st = new StringTokenizer(sb.toString());
        int n = st.countTokens()+1;
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j){
                    a[i][j] = n;
                    b[i][j] = n;
                }
            }
        }
        for(int i=1; i<n; i++){
            int j=Integer.parseInt(st.nextToken());
            a[i][j] = a[j][i] = 1;
        }
        sb = new StringBuilder();
        for(String s : tree2) sb.append(s);
        st = new StringTokenizer(sb.toString());
        for(int i=1; i<n; i++){
            int j=Integer.parseInt(st.nextToken());
            b[i][j] = b[j][i] = 1;
        }

        for(int e=0; e<n; e++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(a[i][e]+a[e][j]<a[i][j]) a[i][j] = a[i][e]+a[e][j];
                    if(b[i][e]+b[e][j]<b[i][j]) b[i][j] = b[i][e]+b[e][j];
                }
            }
        }
        int[] da = new int[K];
        int[] db = new int[K];

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(a[i][j]>0 && a[i][j]<K) da[a[i][j]]++;
                if(b[i][j]>0 && b[i][j]<K) db[b[i][j]]++;
            }
        }
        double cycleCount = 0;
        for(int i=1; i<K; i++){
            int j=K-i;
            cycleCount+=da[i]*db[j];
        }
        return cycleCount*2/(n*(n-1)); //cycleCount*(n-2)!/n!
    }
}
