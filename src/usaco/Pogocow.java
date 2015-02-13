package usaco;

import sun.security.tools.policytool.PolicyTool;

import java.io.*;
import java.util.*;

public class Pogocow {
    static class Point{
        int x, v;
        public Point(int x, int v){
            this.x = x;
            this.v = v;
        }
    }
    static int find(Point[] points, int i, int d){
        int l=0, r=i;
        while(l<r){
            int mid = (r-l)/2+l;
            if(Math.abs(points[mid].x-points[i].x)<=d) r=mid; else l=mid+1;
        }
        return l;
    }
    static int calc(Point[] points){
        int ret = 0;
        int n = points.length;
        int[][] dp = new int[n][n];
        int[][] best = new int[n][n];
        for(int c=0; c<n; c++){
            dp[c][c] = points[c].v;
            for(int i=c-1; i>=0; i--){
                int j = find(points, i, Math.abs(points[c].x-points[i].x));
                dp[c][i] = Math.max(dp[c][i], best[i][j]+points[c].v);
            }
            for(int i=c; i>=0; i--){
                best[c][i] = Math.max(i<c?best[c][i+1]:0, dp[c][i]);
            }
            ret = Math.max(ret, best[c][0]);
        }
        return ret;
    }
    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new FileReader("pogocow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pogocow.out")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point point2) {
                return point.x-point2.x;
            }
        });
        int result = calc(points);
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point point2) {
                return point2.x-point.x;
            }
        });
        result = Math.max(result, calc(points));
        System.out.println(result);
        out.close();

    }
}
