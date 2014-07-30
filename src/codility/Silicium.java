package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by chinh on 7/23/14.
 */
public class Silicium {
    class Cell implements Comparable<Cell>{
        int x;
        int y;
        int v;
        Cell(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Cell o) {
            return o.v-this.v;
        }
    }
    public int solution(int X, int Y, int K, int A[], int B[]) {
        int n = A.length+1;
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for(int i=0; i<n; i++){
            a[i] = i<n-1 ? A[i] : X;
            a[i] -= i>0 ? A[i-1] : 0;
            b[i] = i<n-1 ? B[i] : Y;
            b[i] -= i>0 ? B[i-1] : 0;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>();
        heap.add(new Cell(n-1,n-1,a[n-1]*b[n-1]));
        HashSet<Integer> set = new HashSet<Integer>();
        set.add((n-1)*n+n-1);
        for(int i=1; i<K; i++){
            Cell c = heap.poll();
            if(c.x>0 && !set.contains((c.x-1)*n+c.y)){
                heap.add(new Cell(c.x-1,c.y,a[c.x-1]*b[c.y]));
                set.add((c.x-1)*n+c.y);
            }
            if(c.y>0 && !set.contains(c.x*n+c.y-1)){
                heap.add(new Cell(c.x,c.y-1,a[c.x]*b[c.y-1]));
                set.add(c.x*n+c.y-1);
            }
        }
        return heap.poll().v;
    }
}