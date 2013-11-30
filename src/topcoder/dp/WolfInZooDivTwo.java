package topcoder.dp;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/30/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class WolfInZooDivTwo {
    private static final int MOD = (int)1e9+7;
    private class Segment {
        int x, y;
        public Segment(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean contain(int i){
            return this.x<=i && i<=this.y;
        }
    }
    private int findLongest(Segment[] segments, int i){
        int result=i;
        for(Segment segment : segments){
            if(segment.contain(i)){
                if(result>segment.x) result=segment.x;
            }
        }
        return result;
    }
    private int findShortest(Segment[] segments, int i){
        int result=-1;
        for(Segment segment : segments){
            if(segment.contain(i)){
                if(result<segment.x) result=segment.x;
            }
        }
        return result;
    }
    private boolean isCovered(Segment[] segments, int i){
        for(Segment segment : segments){
            if(segment.contain(i)) return true;
        }
        return false;
    }
    public int count(int N, String[] L, String[] R){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<L.length; i++) sb.append(L[i]+" ");
        StringTokenizer stL = new StringTokenizer(sb.toString());
        sb = new StringBuilder();
        for(int i=0; i<R.length; i++) sb.append(R[i]+" ");
        StringTokenizer stR = new StringTokenizer(sb.toString());
        int m = stR.countTokens();
        Segment[] segments = new Segment[m];
        for(int i=0; i<m; i++){
            segments[i] = new Segment(Integer.parseInt(stL.nextToken())+1, Integer.parseInt(stR.nextToken())+1);
        }
        // f[i][j]: number of valid arrangement where there's j wolf at i
        int[][] f = new int[N+1][2];
        f[0][0] = 1;
        for(int i=1; i<=N; i++){
            if(isCovered(segments, i)){
                int j = findLongest(segments, i);
                for(int e=i-1; e>=j; e--){
                    f[i][1] = (f[i][1]+f[e][1])%MOD;
                }
                f[i][1] = ((f[i][1]+f[j-1][0])%MOD+f[j-1][1])%MOD;
                j = findShortest(segments, i);
                for(int e=i-1; e>=j; e--){
                    f[i][0] = (f[i][0]+f[e][1])%MOD;
                }
            } else{
                f[i][1] = f[i][0] = (f[i-1][0]+f[i-1][1])%MOD;
            }
        }
        return (f[N][0]+f[N][1])%MOD;
    }
}
