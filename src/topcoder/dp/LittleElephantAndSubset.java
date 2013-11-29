package topcoder.dp;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/21/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class LittleElephantAndSubset {
    final int MOD = (int)1e9+7;

    Integer[] digits;
    int[][] dp = new int[10][1<<10];
    boolean[] used;
    int size;

    int factorial(int x){
        int result = 1;
        for(int i=2; i<=x; i++) result *= i;
        return result;
    }

    int assertedCount(int x){
        int count = 0;
        while(x>0){
            count += x%2;
            x/=2;
        }
        return count;
    }

    boolean isAsserted(int i, int digit){
        return (i&(1<<digit))>0;
    }

    int firstAsserted(int i){
        int result = 0;
        while(i%2==0){
            i=i/2;
            result++;
        }
        return result;
    }

    void count(int i, int pos){
        for(int digit=0; digit<=digits[pos]; digit++){
            if(pos==digits.length-1 && digit==0) continue;
            if(isAsserted(i, digit) && !used[digit]){
                if(digit<digits[pos]){
                    dp[1][i]+= factorial(pos);
                } else{
                    if(pos>0){
                        used[digit] = true;
                        count(i, pos-1);
                        used[digit] = false;
                    } else dp[1][i]++;
                }
            }
        }
    }
    void split(int i, int digit, int value){
        if(digit>9){
            dp[size][i] = (dp[size][i] + dp[1][value]*dp[size-1][i-value])%MOD;
            return;
        }
        if(isAsserted(i, digit)){
            split(i, digit+1, value+(1<<digit));
        }
        split(i, digit+1, value);
    }
    public int getNumber(int N){
        ArrayList<Integer> digitsList = new ArrayList<Integer>();
        while(N>0){
            digitsList.add(N%10);
            N/=10;
        }
        digits = digitsList.toArray(new Integer[0]);
        for(int i=2; i<(1<<10); i++){
            int count = assertedCount(i);
            if(count<digits.length){
                if(i%2==0){ //don't have 0
                    dp[1][i] = factorial(count);
                } else{
                    dp[1][i] = factorial(count)-factorial(count-1);
                }
            } else
            if(count==digits.length){
                used = new boolean[10];
                count(i, digits.length-1);
            }
        }
        for(size=2; size<=9; size++){
            for(int i=2; i<(1<<10); i++){
                if(assertedCount(i)-i%2<size) continue;
                int loc = firstAsserted(i);
                split(i,loc+1, 1<<loc);
            }
        }
        int result = 0;
        for(size=1; size<=9; size++){
            for(int i=2; i<(1<<10); i++){
                if(dp[size][i]>0){
                    result = (result+dp[size][i])%MOD;
                }
            }
        }
        return result;
    }
}
