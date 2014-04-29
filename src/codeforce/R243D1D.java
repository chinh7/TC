package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/27/14.
 */
public class R243D1D {
    static class Point{
        int x; int y;
        public Point(){}
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class yxComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.y!=o2.y) return o1.y-o2.y;
            return o1.x-o2.x;
        }
    }
    static class xyComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.x!=o2.x) return o1.x-o2.x;
            return o1.y-o2.y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Point[] horizontal = new Point[n];
        Point[] vertical = new Point[n];
        HashSet<Long> set = new HashSet<Long>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            horizontal[i] = new Point(x,y);
            vertical[i] = new Point(x,y);
            set.add((long)x*100001+y);
        }
        Arrays.sort(horizontal, new yxComparator());
        Arrays.sort(vertical, new xyComparator());
        int result=0;
        for(int i=0; i<n; i++){
            int u = Arrays.binarySearch(vertical, horizontal[i], new xyComparator());
            int j=i+1;
            int v=u+1;
            while(j<n && v<n && horizontal[j].y==horizontal[i].y && vertical[v].x==vertical[u].x){
                if(horizontal[j].x-horizontal[i].x == vertical[v].y-vertical[u].y){
                    if(set.contains((long)horizontal[j].x*100001+vertical[v].y)) result++;
                    j++; v++;
                }
                else if(horizontal[j].x-horizontal[i].x > vertical[v].y-vertical[u].y){
                    v++;
                }
                else{
                    j++;
                }
            }
        }
        System.out.println(result);
    }
}