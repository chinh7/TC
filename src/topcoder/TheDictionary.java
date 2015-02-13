package topcoder;

/**
 * Created by chinh on 28/11/2014.
 */
public class TheDictionary {
    public String find(int n, int m, int k){
        int[][] C = new int[n+m][n+m];
        for(int i=0; i<n+m; i++) C[i][0]=1;
        for(int i=1; i<n+m; i++){
            for(int j=1; j<=i; j++){
                C[i][j] = C[i][j-1]<0 || C[i-1][j-1]<0 ? -1 : C[i-1][j]+C[i-1][j-1];
                if(C[i][j]>k) C[i][j]=-1;
            }
        }
        StringBuilder ret = new StringBuilder();
        int ca=n, cz=m;
        while(ca+cz>0){
            if(ca==0){
                ret.append('z');
                cz--;
            } else
            if(cz==0){
                ret.append('a');
                ca--;
            } else{
                if(C[ca+cz-1][cz]>=0 && C[ca+cz-1][cz]<k){
                    ret.append('z');
                    k -= C[ca+cz-1][cz];
                    cz--;
                } else{
                    ret.append('a');
                    ca--;
                }
            }
        }
        if(k>1) ret = new StringBuilder();
        return ret.toString();
    }
}
