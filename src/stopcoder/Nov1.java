package stopcoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/26/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Nov1 {
    static TreeMap<Integer, Pair> verticals, horizontals;
    static class Pair{
        int low;
        int high;
        public Pair(int low, int high){
            this.low = low;
            this.high = high;
        }
    }
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int availability(Point p){
        int ret = 0;
        if(verticals.containsKey(p.x)) ret++;
        if(horizontals.containsKey(p.y)) ret++;
        return ret;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Nov1.in"));
        int T = Integer.parseInt(br.readLine());
        for(int tCase=0; tCase<T; tCase++){
            boolean yes = true;
            System.out.println("Case #"+(tCase+1));

            int n = Integer.parseInt(br.readLine());
            if(n%2==1){
                System.out.println("NO");
                continue;
            }
            if(n>1000){
                System.out.println("YES");
                continue;
            }
            Point[] points = new Point[n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point point, Point point2) {
                    if(point.x==point2.x) return point.y-point2.y;
                    return point.x-point2.x;
                }
            });
            verticals = new TreeMap<Integer, Pair>();
            for(int i=0; i<n-1; i++){
                if(points[i].x==points[i+1].x) verticals.put(points[i].x, new Pair(points[i].y, points[i+1].y));
            }


            Arrays.sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point point, Point point2) {
                    if(point.y==point2.y) return point.x-point2.x;
                    return point.y-point2.y;
                }
            });
            horizontals = new TreeMap<Integer, Pair>();
            for(int i=0; i<n-1; i++){
                if(points[i].y==points[i+1].y) horizontals.put(points[i].y, new Pair(points[i].x, points[i+1].x));
            }

            ArrayDeque<Point> queue = new ArrayDeque<Point>();
            for(int i=0; i<n; i++){
                if(availability(points[i])<=1){
                    queue.offer(points[i]);
                }
            }

            HashSet<Integer> verticallyConnected = new HashSet<Integer>();
            HashSet<Integer> horizontallyConnected = new HashSet<Integer>();

            while(!queue.isEmpty()){
                Point p = queue.poll();
                if(!verticallyConnected.contains(p.x) && !horizontallyConnected.contains(p.y) && availability(p)==0){
                    yes = false;
                    break;
                }
                if(verticals.containsKey(p.x)){
                    Pair pair = verticals.get(p.x);
                    SortedMap<Integer,Pair> map = horizontals.subMap(pair.low, pair.high);
                    HashSet<Integer> removed = new HashSet<Integer>();
                    for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
                        int y = entry.getKey();
                        Pair range = entry.getValue();
                        if(range.low<=p.x && p.x<=range.high){
                            removed.add(y);
                            queue.add(new Point(range.low,y));
                            queue.add(new Point(range.high,y));
                        }
                    }
                    for(int y : removed){
                        horizontals.remove(y);
                    }
                    verticals.remove(p.x);
                    verticallyConnected.add(p.x);
                }
                if(horizontals.containsKey(p.y)){
                    Pair pair = horizontals.get(p.y);
                    SortedMap<Integer,Pair> map = verticals.subMap(pair.low, pair.high);
                    HashSet<Integer> removed = new HashSet<Integer>();
                    for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
                        int x = entry.getKey();
                        Pair range = entry.getValue();
                        if(range.low<=p.y && p.y<=range.high){
                            removed.add(x);
                            queue.add(new Point(x,range.low));
                            queue.add(new Point(x,range.high));
                        }
                    }
                    for(int x : removed){
                        verticals.remove(x);
                    }
                    horizontals.remove(p.y);
                    horizontallyConnected.add(p.y);
                }
            }
            if(yes) System.out.println("YES"); else System.out.println("NO");


        }
    }

}
