package topcoder.graph;

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
    boolean[][] a;
    int n,l;
    boolean isPrefix(String pre, String str){
        if(pre.length()>=str.length()) return false;
        for(int i=0; i<pre.length(); i++){
            if(pre.charAt(i)!=str.charAt(i)) return false;
        }
        return true;
    }
    int visit(int i, int length){
        if(length==l-1){
            return 1;
        }
        int count = 0;
        for(int j=0; j<n; j++){
            if(a[i][j]){
                count += visit(j,length+1);
            }
        }
        return count;
    }
    public int count(String[] names, int L){
        n = names.length;
        a = new boolean[n][n];
        l = L;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isPrefix(names[i], names[j])){
                    a[i][j] = true;
                }
            }
        }
        long total=0;
        for(int i=0; i<n; i++){
            total+=visit(i,0);
        }
        for(int i=2; i<=n-l; i++){
            total = (total*i)%MOD;
        }
        return (int)total;
    }
}
