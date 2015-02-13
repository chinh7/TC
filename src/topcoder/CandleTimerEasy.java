package topcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by chinh on 04/11/2014.
 */
public class CandleTimerEasy {
    public int differentTime(int[] A, int[] B, int[] len){
        HashSet<Double> timeSet = new HashSet<Double>();
        int m = A.length;
        int n = m+1;
        int[] cursor = new int[n+1];
        for(int i=0; i<m; i++){
            cursor[A[i]]++;
            cursor[B[i]]++;
        }
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            if(cursor[i]==1) leaves.add(i);
        }
        for(int i=0; i<n; i++) cursor[i+1] += cursor[i];
        int[] edges = new int[2*m];
        int[] lengths = new int[2*m];
        for(int i=0; i<m; i++){
            edges[--cursor[A[i]]] = B[i];
            edges[--cursor[B[i]]] = A[i];
            lengths[cursor[A[i]]] = len[i];
            lengths[cursor[B[i]]] = len[i];
        }
        int nLeaves = leaves.size();
        for(int bits=1; bits<(1<<nLeaves); bits++){
            ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

            for(int i=0; i<nLeaves; i++){
                if(((bits>>i)&1)>0) queue.add(leaves.get(i));
            }
            int[] time = new int[n];
            Arrays.fill(time, -1);
            for(int i : queue) time[i]=0;
            while(!queue.isEmpty()){
                int i = queue.poll();
                for(int e=cursor[i]; e<cursor[i+1]; e++){
                    int j = edges[e];
                    if(time[j]<0){
                        queue.add(j);
                        time[j] = time[i]+lengths[e];
                    } else{
                        time[j] = Math.min(time[j], time[i]+lengths[e]);
                    }
                }
            }
            double duration = 0;
            for(int i=0; i<m; i++){
                duration = Math.max(duration, (len[i]-Math.abs(time[A[i]]-time[B[i]]))/2.0+Math.max(time[A[i]], time[B[i]]));
            }
            timeSet.add(duration);
        }
        return timeSet.size();
    }
}
