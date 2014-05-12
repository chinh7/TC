package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/11/14.
 */
public class R245D2A {
    static class Point{
        int x;
        int index;
        int color;
        public Point(int x, int index){
            this.x = x;
            this.index = index;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            points[i] = new Point(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x-o2.x;
            }
        });
        for(int i=0; i<n; i++){
            points[i].color = i%2;
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.index-o2.index;
            }
        });
        for(int i=0; i<n; i++){
            if(i==n-1) System.out.println(points[i].color); else System.out.print(points[i].color+" ");
        }

    }

}

