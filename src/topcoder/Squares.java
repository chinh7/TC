package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/17/13
 * Time: 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Squares {
    private int n,m;
    private String[] map;
    private boolean valid(int i, int j){
        return (i<n&&i>=0&&j<m&&j>=0);
    }
    private boolean different(int i, int j, int u, int v){
        return (map[i].charAt(j) != map[u].charAt(v));
    }
    public int countSquares(String[] field){
        n = field.length;
        m = field[0].length();
        map = field;
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int u=i; u<n; u++){
                    for(int v=j+1; v<m; v++){
                        if(different(i,j,u,v)) continue;
                        int x=u-i, y=v-j;
                        int ii=i+y, jj=j-x;
                        if(!valid(ii,jj) || different(i,j,ii,jj)) continue;
                        int uu=u+y, vv=v-x;
                        if(!valid(uu,vv) || different(i,j,uu,vv)) continue;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
