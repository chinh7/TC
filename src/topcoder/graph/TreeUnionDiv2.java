package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/3/13
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeUnionDiv2 {
    int n,k;
    int[][] d1, d2;
    boolean v[];
    int[] p;
    int result=0;

    void find(int pos){
        if(pos==n){
            int count=0;
            for(int i=1; i<n; i++){
                for(int j=0; j<i; j++){
                    if(d1[i][j]+d2[p[i]][p[j]]+2==k) count++;
                }
            }
            if(result<count) result=count;
            return;
        }
        for(int i=0; i<n; i++){
            if(!v[i]){
                v[i] = true;
                p[pos] = i;
                find(pos+1);
                v[i] = false;
            }
        }
    }
    public int maximumCycles(String[] tree1, String[] tree2, int K){
        k = K;
        n = tree1.length;
        d1 = new int[n][n];
        d2 = new int[n][n];
        v = new boolean[n];
        p = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(tree1[i].charAt(j)=='X'){
                    d1[i][j] = 1;
                } else{
                    d1[i][j] = n;
                }
                if(tree2[i].charAt(j)=='X'){
                    d2[i][j] = 1;
                } else{
                    d2[i][j] = n;
                }
            }
        }
        for(int e=0; e<n; e++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(d1[i][j]>d1[i][e]+d1[e][j]) d1[i][j] = d1[i][e]+d1[e][j];
                    if(d2[i][j]>d2[i][e]+d2[e][j]) d2[i][j] = d2[i][e]+d2[e][j];
                }
            }
        }
        find(0);
        return result;
    }
}
