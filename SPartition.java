/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/17/13
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SPartition {
    private int subLength;
    private int numX;
    private char[] generated;
    private char[] string;
    private long total=0;

    private long cal(){
        int length = subLength*2;
        long[][][] dp = new long[length+1][subLength+1][subLength+1];
        dp[0][0][0] = 1;

        for(int k=1; k<=length; k++){
            for(int i=0; i<=subLength; i++){
                int j = k-i;
                if(j<0) break;
                if(j<=subLength){
                    if(i>0 && string[k-1] == generated[i-1]) dp[k][i][j] += dp[k-1][i-1][j];
                    if(j>0 && string[k-1] == generated[j-1]) dp[k][i][j] += dp[k-1][i][j-1];
                    dp[k][i][j] = dp[k][i][j];
                }
            }
        }
        return dp[length][subLength][subLength];
    }


    private void generate(int pos, int xUsed){
        if(pos == subLength){
            if(xUsed != numX) System.out.println("oppps");
            total += cal();
            return;
        }
        if(subLength-pos > numX-xUsed){
            generated[pos] = 'o';
            generate(pos+1, xUsed);
        }
        if(xUsed < numX){
            generated[pos] = 'x';
            generate(pos+1, xUsed+1);
        }
    }
    public long getCount(String s){
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='x') count++;
        }
        if(count%2==1) return 0;
        subLength = s.length()/2;
        numX = count/2;
        generated = new char[subLength];
        string = s.toCharArray();
        generate(0, 0);
        return total;
    }
}
