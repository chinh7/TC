package topcoder.dp;
/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/23/13
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class WinterAndReindeers {
    static String getString(String[] all){
        StringBuilder sb = new StringBuilder();
        sb.append('-');
        for(int i=0; i<all.length; i++) sb.append(all[i]);
        return sb.toString();
    }
    public int getNumber(String[] allA, String[] allB, String[] allC){
        String A = getString(allA);
        String B = getString(allB);
        String C = getString(allC);
        int nA = A.length();
        int nB = B.length();
        int nC = C.length();
        int[][][] best = new int[nA][nB][nC];
        for(int i=1; i<nA; i++){
            for(int j=1; j<nB; j++){
                if(A.charAt(i)==B.charAt(j)){
                    best[i][j][0] = best[i-1][j-1][0]+1;
                } else{
                    best[i][j][0] = Math.max(best[i-1][j][0], best[i][j-1][0]);
                }
                for(int k=1; k<nC; k++){
                    if(A.charAt(i)==B.charAt(j)){
                        if(C.charAt(k)==A.charAt(i)){
                            if(k==1 || best[i-1][j-1][k-1]>0) best[i][j][k] = best[i-1][j-1][k-1]+1;
                        } else{
                            best[i][j][k] = Math.max(best[i-1][j][k], best[i][j-1][k]);
                            if(k==nC-1){
                                if(best[i-1][j-1][k]>0) best[i][j][k] = best[i-1][j-1][k]+1;
                            }
                        }
                    } else{
                        best[i][j][k] = Math.max(best[i-1][j][k], best[i][j-1][k]);
                    }
                }
            }
        }
        return best[nA-1][nB-1][nC-1];
    }
}