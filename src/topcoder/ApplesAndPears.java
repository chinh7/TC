package topcoder;

/**
 * Created by chinh on 6/12/14.
 */
public class ApplesAndPears {
    static int n;
    static int[][] A, P;

    static int getCount(char chr, int i, int j, int r){
        if(r<0) return 0;
        return chr=='A' ? A[j][r]-(i>0?A[i-1][r]:0) : P[j][r]-(i>0?P[i-1][r]:0);
    }
    static int getCount(char chr, int i, int j, int l, int r){
        if(chr=='.') return (j-i+1)*(r-l+1)-getCount('A', i,j,l,r)-getCount('P',i,j,l,r);
        return getCount(chr, i, j, r)-getCount(chr, i, j, l-1);
    }
    public int getArea(String[] board, int K){
        n = board.length;
        A = new int[n][n];
        P = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                A[i][j] = (board[i].charAt(j)=='A'?1:0) + (i>0?A[i-1][j]:0) + (j>0?A[i][j-1]:0) - (i>0&&j>0?A[i-1][j-1]:0);
                P[i][j] = (board[i].charAt(j)=='P'?1:0) + (i>0?P[i-1][j]:0) + (j>0?P[i][j-1]:0) - (i>0&&j>0?P[i-1][j-1]:0);
            }
        }
        int totalA = A[n-1][n-1];
        int totalP = P[n-1][n-1];
        int totalE = n*n-totalA-totalP;
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                for(int l=0; l<n; l++){
                    for(int r=i; r<n; r++){
                        if(totalE>0){
                            if(totalA>=(j-i+1)*(r-l+1) && getCount('P', i,j,l,r)*2+getCount('.',i,j,l,r)<=K) result = Math.max(result, (j-i+1)*(r-l+1));
                            if(totalP>=(j-i+1)*(r-l+1) && getCount('A', i,j,l,r)*2+getCount('.',i,j,l,r)<=K) result = Math.max(result, (j-i+1)*(r-l+1));
                            if(totalE>=(j-i+1)*(r-l+1) && getCount('A', i,j,l,r)+getCount('P',i,j,l,r)<=K) result = Math.max(result, (j-i+1)*(r-l+1));
                        } else{
                            if(getCount('P',i,j,l,r)==0 || getCount('A', i,j,l,r)==0) result = Math.max(result, (j-i+1)*(r-l+1));
                        }
                    }
                }
            }
        }
        return result;
    }
}
