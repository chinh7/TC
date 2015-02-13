package topcoder;

/**
 * Created by chinh on 04/11/2014.
 */
public class ShadowSculpture {
    void dfs(int i, int j, int k, boolean[][][] isEmpty, boolean[][][] visited){
        int n = isEmpty.length;
        visited[i][j][k] = true;
        for(int u=0; u<3; u++){
            int[] iter = new int[3];
            for(iter[u]=-1; iter[u]<=1; iter[u]++){
                if(iter[u]==0) continue;
                int ii = i+iter[0];
                int jj = j+iter[1];
                int kk = k+iter[2];
                if(0<=ii && ii<n && 0<=jj && jj<n && 0<=kk && kk<n && !isEmpty[ii][jj][kk] && !visited[ii][jj][kk]){
                    dfs(ii, jj, kk, isEmpty, visited);
                }
            }
            iter[u]=0;
        }
    }
    public String possible(String[] XY, String[] YZ, String[] ZX){
        int n = XY.length;
        boolean[][][] isEmpty = new boolean[n][n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(XY[i].charAt(j)=='N'){
                    for(int k=0; k<n; k++) isEmpty[i][j][k] = true;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(ZX[i].charAt(j)=='N'){
                    for(int k=0; k<n; k++) isEmpty[i][k][j] = true;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(YZ[i].charAt(j)=='N'){
                    for(int k=0; k<n; k++) isEmpty[k][i][j] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(XY[i].charAt(j)=='Y'){
                    boolean valid = false;
                    for(int k=0; k<n; k++) valid |= !isEmpty[i][j][k];
                    if(!valid) return "Impossible";
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(ZX[i].charAt(j)=='Y'){
                    boolean valid = false;
                    for(int k=0; k<n; k++) valid |= !isEmpty[i][k][j];
                    if(!valid) return "Impossible";
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(YZ[i].charAt(j)=='Y'){
                    boolean valid = false;
                    for(int k=0; k<n; k++) valid |= !isEmpty[k][i][j];
                    if(!valid) return "Impossible";
                }
            }
        }
        boolean[][][] visited = new boolean[n][n][n];
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(!isEmpty[i][j][k] && !visited[i][j][k]){
                        if(count>0) return "Impossible";
                        dfs(i,j,k, isEmpty, visited);
                        count++;
                    }
                }
            }
        }
        return "Possible";

    }
}
