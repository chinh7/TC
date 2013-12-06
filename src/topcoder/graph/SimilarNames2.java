package topcoder.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/5/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimilarNames2 {
    static final int MOD = (int)1e9+7;
    boolean[][] b;
    int n;
    boolean[] visited;
    ArrayList<Integer> sorted = new ArrayList<Integer>();

    boolean isPrefix(String pre, String str){
        if(pre.length()>=str.length()) return false;
        for(int i=0; i<pre.length(); i++){
            if(pre.charAt(i)!=str.charAt(i)) return false;
        }
        return true;
    }
    void visit(int i){
        visited[i] = true;
        for(int j=0; j<n; j++){
            if(b[i][j] && !visited[j]){
                visit(j);
            }
        }
        sorted.add(i);
    }
    public int count(String[] names, int L){
        n = names.length;
        b = new boolean[n][n];

        boolean[][] a = new boolean[n][n];
        int[] degree = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isPrefix(names[i], names[j])){
                    a[i][j] = true;
                    b[j][i] = true;
                    degree[i]++;
                }
            }
        }

        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(degree[i]==0){
                visit(i);
            }
        }

        int[][] count = new int[n][L];
        for(int i=0; i<n; i++) count[i][0]=1;
        for(int i : sorted){
            for(int j=0; j<n; j++){
                for(int e=0; e<L-1; e++)
                if(a[i][j]) count[j][e+1] += count[i][e];
            }
        }

        long total=0;
        for(int i=0; i<n; i++){
            total+=count[i][L-1];
        }
        for(int i=2; i<=n-L; i++){
            total = (total*i)%MOD;
        }
        return (int)total;
    }
}
