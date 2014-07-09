package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by chinh on 6/13/14.
 */
public class ZeptoE {
    static long query(long[] bit, int index){
        index++;
        long ret = 0;
        while(index>0){
            ret += bit[index-1];
            index -= index&-index;
        }
        return ret;
    }
    static void update(long[] bit, int index, long value){
        index++;
        int max = bit.length;
        while(index<=max){
            bit[index-1] += value;
            index += index&-index;
        }
    }

    static class Round{
        int a, b, originalIndex, index, extendedIndex;
        public Round(int a, int b, int originalIndex){
            this.a = a;
            this.b = b;
            this.originalIndex = originalIndex;
        }
    }
    static class Derive{
        int value, type, index;
        public Derive(int value, int type, int index){
            this.value = value;
            this.type = type;
            this.index = index;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        Round[] rounds = new Round[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            rounds[i] = new Round(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(rounds, new Comparator<Round>() {
            @Override
            public int compare(Round o1, Round o2) {
                return o1.b-o2.b;
            }
        });

        Derive[] d = new Derive[2*n];
        for(int i=0; i<n; i++){
            d[2*i] = new Derive(rounds[i].a, 0, i);
            d[2*i+1] = new Derive(rounds[i].b-rounds[i].a, 1, i);
        }
        Arrays.sort(d, new Comparator<Derive>() {
            @Override
            public int compare(Derive o1, Derive o2) {
                return o1.value-o2.value;
            }
        });

        long[] bitA = new long[2*n];
        long[] bitP = new long[2*n];
        for(int i=0; i<2*n; i++){
            if(d[i].type==0){
                rounds[d[i].index].index = i;
                update(bitA, i, d[i].value);
                update(bitP, i, 1);
            } else{
                rounds[d[i].index].extendedIndex = i;
            }
        }

        long result=Long.MAX_VALUE;
        long baseSum = 0;
        int bestIndex = -1;
        for(int i=-1; i<n; i++){
            if(i>=0){
                baseSum+=rounds[i].a;
                update(bitA, rounds[i].index, -d[rounds[i].index].value);
                update(bitA, rounds[i].extendedIndex, d[rounds[i].extendedIndex].value);
                update(bitP, rounds[i].index, -1);
                update(bitP, rounds[i].extendedIndex, 1);
            }
            int required = w-(i+1);
            int l=0, r=2*n-1;
            while(l<r){
                int mid = (r-l)/2+l;
                if(query(bitP, mid)>=required) r=mid; else l=mid+1;
            }
            if(query(bitP, l)<required) continue;
            long addedSum = query(bitA, l);
            if(result>baseSum+addedSum){
                result=baseSum+addedSum;
                bestIndex=i;
            }
        }
        int[] picks = new int[n];
        for(int i=0; i<=bestIndex; i++){
            picks[rounds[i].originalIndex]=1;
            rounds[i].a = rounds[i].b-rounds[i].a;
        }
        Arrays.sort(rounds, new Comparator<Round>() {
            @Override
            public int compare(Round o1, Round o2) {
                return o1.a-o2.a;
            }
        });
        int required = w-(bestIndex+1);
        for(int i=0; i<required; i++){
            picks[rounds[i].originalIndex]++;
        }
        System.out.println(result);
        for(int i=0; i<n; i++){
            if(i==n-1) System.out.println(picks[i]); else System.out.print(picks[i]);
        }
    }
}
