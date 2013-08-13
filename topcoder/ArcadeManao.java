package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/17/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArcadeManao {
    private final int INF = Integer.MAX_VALUE / 2;
    class Segment{
        int x, y;
        int level;
        boolean visited = false;
        int min = INF;
        public Segment(){

        }
        public Segment(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
        public int distance(Segment that){
            if(this.x > that.y || that.x > this.y) return INF;
            return Math.abs(this.level - that.level);
        }
    }
    public int shortestLadder(String[] level, int coinRow, int coinColumn){
        coinColumn--;
        coinRow--;
        Segment destination = new Segment();
        ArrayList<Segment> segments = new ArrayList<Segment>();
        for(int i=0; i<level.length; i++){
            int x=-1, y=-1;
            for(int j=0; j<level[i].length(); j++){
                if(level[i].charAt(j) == 'X'){
                    if(x<0) x=j;
                    y=j;
                } else{
                    if(x>=0){
                        segments.add(new Segment(x,y,i));
                        if(i==coinRow && x<=coinColumn && y>=coinColumn){
                            destination = segments.get(segments.size()-1);
                        }
                        x=-1;
                    }
                }
            }
            if(x>=0){
                segments.add(new Segment(x,y,i));
                if(i==coinRow && x<=coinColumn && y>=coinColumn){
                    destination = segments.get(segments.size()-1);
                }
            }
        }
        Segment origin = segments.get(segments.size()-1);
        origin.min = 0;

        ArrayList<Segment> queue = new ArrayList<Segment>();
        queue.add(origin);
        while(true){
            Segment current = new Segment();
            for(Segment segment : segments){
                if(!segment.visited && current.min > segment.min){
                    current = segment;
                }
            }
            if(current.min == INF) break;
            current.visited = true;

            for(Segment next : segments){
                int distance = next.distance(current);
                if(distance!=INF){
                    int max = Math.max(current.min, distance);
                    if(next.min > max){
                        next.min = max;
                    }
                }
            }
        }

        return destination.min;
    }
}
