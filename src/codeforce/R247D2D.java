package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/22/14.
 */
public class R247D2D {
    static final int MAX_BIT=64;
    static long[][] map = new long[MAX_BIT+1][MAX_BIT+1];

    static int log2(long x){
        int i=0;
        while((1L<<i)<=x) i++;
        return i-1;
    }
    static long[] submap(long n){
        long[] ret = new long[MAX_BIT+1];
        n++;
        long family=0;
        while(n!=0){
            int lvl = log2(n);
            int asserted=0;
            for(int j=lvl; j<=MAX_BIT; j++) asserted+=(family&(1L<<j))!=0?1:0;
            for(int i=asserted; i<=MAX_BIT; i++) ret[i]+=map[lvl][i-asserted];
            n-=1L<<lvl;
            family+=1L<<lvl;
        }
        return ret;
    }
    static long count(long n, int k){
        long[] toN = submap(n);
        long[] to2N = submap(2*n);
        long[] sub = new long[MAX_BIT+1];
        for(int j=0; j<=MAX_BIT; j++) sub[j]=to2N[j]-toN[j];
        return sub[k];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map[0][0]=1;
        for(int i=1; i<=MAX_BIT; i++){
            for(int j=0; j<=MAX_BIT; j++){
                map[i][j] = map[i-1][j];
                if(j>0) map[i][j] += map[i-1][j-1];
            }
        }
        long l=1, r=(long)1e18;
        while(l<r){
            long mid=(r-l)/2+l;
            long amount = count(mid, k);
            if(amount==m){
                l=mid;
                break;
            } else if(amount<m) l=mid+1; else r=mid-1;
        }
        System.out.println(l);
    }
}


