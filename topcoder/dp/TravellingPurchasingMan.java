package topcoder.dp;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/16/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TravellingPurchasingMan {
    final int INF = Integer.MAX_VALUE / 2;
    class Store{
        int open, close, duration;
        public Store(int o, int c, int d){
            open = o;
            close = c;
            duration = d;
        }
    }
    int[][] parseRoads(int N, String[] roads){
        int[][] time = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(i!=j) time[i][j] = INF;
        for(String road : roads){
            StringTokenizer st = new StringTokenizer(road);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            time[A][B] = length;
            time[B][A] = length;
        }
        return time;
    }
    Store[] parseStores(String[] interestingStores){
        Store[] stores = new Store[interestingStores.length];
        for(int i=0; i<interestingStores.length; i++){
            StringTokenizer st = new StringTokenizer(interestingStores[i]);
            stores[i] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        return stores;
    }
    /**
     *
     * @param N: between 1 and 50, inclusive.
     * @param interestingStores: will contain between 1 and min{16, N} elements, inclusive
     * @param roads: In each road, LENGTH will be between 1 and 604,800, inclusive
     * @return the maximum number of purchases in interesting stores that you can make
     */
    public int maxStores(int N, String[] interestingStores, String[] roads){
        int M = interestingStores.length;
        int[][] time = parseRoads(N, roads);
        Store[] stores = parseStores(interestingStores);
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(time[i][k]+time[k][j]<time[i][j]) time[i][j] = time[i][k]+time[k][j];
                }
            }
        }
        int maskLimit = 1 << M;
        int[][] minTime = new int[M][maskLimit];
        for(int i=0; i<M; i++){
            minTime[i][0] = time[i][N-1];
        }
        for(int mask=1; mask<maskLimit; mask++){
            for(int i=0; i<M; i++){
                minTime[i][mask] = INF;
                if(( (1<<i) & mask ) != 0){
                    int prev = (1<<i) ^ mask;
                    for(int j=0; j<M; j++){
                        int enterTime = Math.max(minTime[j][prev] + time[j][i], stores[i].open);
                        if(enterTime <= stores[i].close)
                            minTime[i][mask] = Math.min(minTime[i][mask], enterTime+stores[i].duration);
                    }
                }
            }
        }

        int result = 0;
        for(int mask=1; mask<maskLimit; mask++){
            int count = 0;
            for(int i=0; i<M; i++){
                if( ((1<<i) & mask) !=0) count++;
            }

            for(int i=0; i<M; i++){
                if(minTime[i][mask] < INF){
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
