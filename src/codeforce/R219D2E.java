package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class R219D2E {
    static class Pair{
        long first;
        int second;
        public Pair(long first, int second){
            this.first = first;
            this.second = second;
        }
        public String toString(){
            return this.first+" "+this.second;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        long[] prev = new long[n];
        long[] cur = new long[n];
        int pt = 1;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int round = t-pt;
            ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
            for(int i=0; i<n+d*round; i++){
                if(i<n){
                    while(!queue.isEmpty() && queue.peekLast().first<=prev[i]) queue.removeLast();
                    queue.offer(new Pair(prev[i],i));
                }
                while(queue.peekFirst().second<i-2*d*round) queue.removeFirst();
                if(i-d*round>=0){
                    cur[i-d*round] = queue.peekFirst().first+b-Math.abs(a-(i-d*round+1));
                }
            }
            long[] tmp = prev;
            prev = cur;
            cur = tmp;
            pt = t;
        }
        long max = Long.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max<prev[i]) max=prev[i];
        }
        System.out.println(max);
    }

}
