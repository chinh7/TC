package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/6/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class CutTheNumbers {
    int getNumber(int bits, int[][] a){
        int n = a.length;
        int m = a[0].length;
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((bits&1)!=0){
                    result = result*10+a[i][j];
                }
                bits = bits>>1;
            }
        }
        return result;
    }
    public int maximumSum(String[] board){
        int n = board.length;
        int m = board[0].length();
        int nBits = n*m;
        int[][] a = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j] = board[i].charAt(j)-'0';
            }
        }
        int[] best = new int[1<<nBits];
        for(int i=1; i<1<<nBits; i++){
            //horizontal
            for(int order=0; order<n; order++){
                for(int l=1; l<=m; l++){
                    int base=(1<<l)-1;
                    for(int pos=0; pos<=m-l; pos++){
                        int bits = (base<<pos) << (order*m);
                        if((i|bits)==i){
                            int number = getNumber(bits, a);
                            best[i] = Math.max(best[i], best[i^bits]+number);
                        }
                    }
                }
            }
            //vertical
            for(int order=0; order<m; order++){
                int base = 0;
                for(int l=0; l<n; l++){
                    base += 1<<(l*m);
                    for(int pos=0; pos<n-l; pos++){
                        int bits = (base<<(pos*m)) << order;
                        if((i|bits)==i){
                            int number = getNumber(bits, a);
                            best[i] = Math.max(best[i], best[i^bits]+number);
                        }
                    }
                }
            }
        }
        return best[(1<<nBits)-1];
    }
}
