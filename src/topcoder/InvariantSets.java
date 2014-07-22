package topcoder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by chinh on 7/22/14.
 */
public class InvariantSets {
    int n;
    int[] f;
    boolean[] visited;
    int[] num, low;
    int count=0;
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

    void number(int i){
        num[i]=low[i]=++count;
        stack.push(i);
        int j = f[i];
        if(num[j]==0){
            number(j);
            low[i]=Math.min(low[i], low[j]);
        } else if(stack.contains(f[i])){
            low[i]=Math.min(low[i], num[j]);
        }
        if(num[i]==low[i]){
            do{
                j = stack.pop();
                for(int e=0; e<n; e++){
                    if(f[e]==j) f[e]=i;
                }
                if(j!=i) f[j]=-1;
            } while(j!=i);
        }
    }

    long calc(int i){
        long ret=1;
        for(int j=0; j<n; j++){
            if(j!=i && f[j]==i) ret*=(calc(j)+1);
        }
        return ret;
    }
    public long countSets(int[] ff){
        f=ff;
        n = f.length;
        visited = new boolean[n];
        num = new int[n];
        low = new int[n];

        for(int i=0; i<n; i++){
            if(num[i]==0){
                number(i);
            }
        }

        long result=1;
        for(int i=0; i<n; i++){
            if(f[i]==i){
                result*=(calc(i)+1);
            }
        }
        return result;
    }
}
