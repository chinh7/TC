package topcoder.dp;

/**
 * Created by chinh on 3/24/14.
 */
public class TaroCards {
    private int popcount(int x){
        int count = 0;
        while(x>0){
            count+=x%2;
            x/=2;
        }
        return count;
    }
    public long getNumber(int[] first, int[] second, int K) {
        int n = first.length;
        int nUnique = Math.max(0, n - 10);
        int max = (1 << 10) - 1;
        long[][] count = new long[max + 1][nUnique + 1];
        count[0][0] = 1;
        for (int i = 0; i < n; i++) {
            first[i]--; second[i]--;
            for (int u = max; u >= 0; u--) {
                for (int v = nUnique; v >= 0; v--) {
                    int uniqueAdded = 0;
                    int newU = u;

                    if (first[i] > 9) {
                        uniqueAdded++;
                    } else {
                        newU = newU | (1 << first[i]);
                    }

                    if (second[i] > 9) {
                        uniqueAdded++;
                    } else {
                        newU = newU | (1 << second[i]);
                    }
                    if(v+uniqueAdded<=nUnique) count[newU][v + uniqueAdded] += count[u][v];
                }
            }
        }
        long result = 0;
        for (int u = max; u >= 0; u--) {
            for (int v = nUnique; v >= 0; v--) {
                if(popcount(u) + v>K || count[u][v]==0) continue;
                result+=count[u][v];
            }
        }
        return result;
    }
}
