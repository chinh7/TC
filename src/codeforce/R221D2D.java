package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */

/*
TLE: N^2Log(N)
 */
public class R221D2D {
    static class Point implements Comparable<Point>{
        int pos;
        int offset;
        int id;

        public Point(int pos, int offset, int id){
            this.pos = pos;
            this.offset = offset;
            this.id = id;
        }
        public int compareTo(Point other){
            if(this.pos!=other.pos) return this.pos - other.pos;
            return this.id - other.id;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Point> points = new ArrayList<Point>();
        int counter = 0;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            int l=0, r = 0;
            while(l<m){
                l = r;
                while(l<m && s.charAt(l)=='0') l++;
                r = l;
                while(r<m && s.charAt(r)=='1') r++;
                if(l<m){
                    // l to r-1;
                    points.add(new Point(l, 1, counter));
                    points.add(new Point(r-1, l-r+1, counter));
                    counter++;
                }
            }
        }

        Collections.sort(points);

        TreeSet<Point> set = new TreeSet<Point>();
        int result = 0;
        int lastPos = -1;
        for(Point p : points){
            if(p.offset>0){
                set.add(p);
            } else{
                int i = p.pos;
                if(i!=lastPos){
                    SortedSet<Point> headSet= set.headSet(new Point(i, 0, Integer.MAX_VALUE));
                    int count = 1;
                    for(Point s : headSet){
                        if(result<count*(i-s.pos+1)){
                            result = count*(i-s.pos+1);
                        }
                        count++;
                    }
                }
                lastPos = i;
                Point start = new Point(p.pos+p.offset, 0, p.id);
                set.remove(start);
            }
        }
        System.out.println(result);
    }


}
