package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/13/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class DancingCouples {
    private int n, m, k;
    private int[][][] dp;
    private String[] match, select;
    private int[] selectI;
    private int result = 0;

    private void calculate(){
        dp = new int[k][m][m];
        for(int j=0; j<m; j++){
            if(select[0].charAt(j) == 'Y'){
                for(int e=0; e<m; e++){
                    dp[0][j][e] = 1;
                }
            }
        }

        for(int i=1; i<k; i++){
            for(int j=0; j<m; j++){
                if(select[i].charAt(j) == 'Y'){
                    for(int e=0; e<m; e++){
                        for(int p=0; p<m; p++){
                            if(p!=j && p!=e) dp[i][j][e] += dp[i-1][p][e];
                        }
                    }
                }
            }
        }

        for(int j=0; j<m; j++){
            result+=dp[k-1][j][j];
        }
    }
    private void generate(int i, int count){
        if(count==k){
            calculate();
            return;
        }
        if(n-i>k-count){
            generate(i+1, count);
        }
        select[count] =  match[i];
        generate(i+1, count+1);
    }
    public int countPairs(String[] canDance, int K){
        match = canDance;
        n = canDance.length;
        m = canDance[0].length();
        k=K;
        select = new String[K];
        generate(0, 0);
        return result;
    }
}
