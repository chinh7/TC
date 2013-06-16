import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/13/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class PenLift {
    private class Point{
        int x, y;
    }
    private enum Direction{
        VERTICAL,
        HORIZONTAL
    }
    private class Segment implements Comparable<Segment>{
        Point start = new Point();
        Point end = new Point();
        Direction direction;
        Segment parent;
        //root only
        int visited;
        int oddDeduction;
        int segmentCount;

        public int compareTo(Segment o) {
            if(this.direction != o.direction){
                if(this.direction == Direction.VERTICAL) return 1; else return -1;
            } else{
                if(this.direction == Direction.HORIZONTAL){
                    if(this.start.y != o.start.y) return (this.start.y - o.start.y);
                    if(this.start.x != o.start.x) return (this.start.x - o.start.x);
                    return (this.end.x - o.end.x);
                } else{
                    if(this.start.x != o.start.x) return (this.start.x - o.start.x);
                    if(this.start.y != o.start.y) return (this.start.y - o.start.y);
                    return (this.end.y - o.end.y);
                }
            }
        }
    }

    private Segment find(Segment s){
        if(s == s.parent) return s.parent;
        s.parent = find(s.parent);
        return s.parent;
    }

    private void union(Segment s, Segment e, int deduction){
        Segment ss = find(s);
        Segment ee = find(e);
        if(ss != ee){
            ee.parent = ss;
            ss.segmentCount = ss.segmentCount + ee.segmentCount;
            ss.oddDeduction = ss.oddDeduction + ee.oddDeduction + deduction;

        } else{
            ss.oddDeduction = ss.oddDeduction + deduction;
//            System.out.println("Same parent:" + ss);
        }
//        System.out.println("OddDeduction: "+ss.oddDeduction);

    }

    /**
     *
     * @param h : horizontal
     * @param v : vertical
     * @return
     */
    private int intersect(Segment h, Segment v){
        long r1 = (long)(h.start.x - v.start.x)*(h.end.x - v.start.x);
        long r2 = (long)(v.start.y - h.start.y)*(v.end.y - h.start.y);
        if(r1<=0 && r2<=0){
            if(r1==0 && r2==0) return 2; else return 0;
        }
        else return -1;
    }

    private Segment[] parse(String[] segments){
        int length = segments.length;
        Segment[] sl = new Segment[length];
        for(int i=0; i<length; i++){
            StringTokenizer st = new StringTokenizer(segments[i]);
            sl[i] = new Segment();

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sl[i].start.x = Math.min(x1, x2);
            sl[i].start.y = Math.min(y1, y2);
            sl[i].end.x = Math.max(x1, x2);
            sl[i].end.y = Math.max(y1, y2);

            sl[i].direction = (x1==x2) ? Direction.VERTICAL : Direction.HORIZONTAL;
        }
        return sl;
    }

    public int numTimes(String[] segments, int n){
        int ret = 0;
        int length = segments.length;
        Segment[] parsedSegments = parse(segments);

        Arrays.sort(parsedSegments);

        ArrayList<Segment> unifiedSegments = new ArrayList<Segment>();
        Segment unified = parsedSegments[0];
        for(int i=1; i<length; i++){
            Segment current = parsedSegments[i];
            if(unified.direction == current.direction){
                if(unified.direction == Direction.HORIZONTAL){
                    if(unified.start.y == current.start.y && unified.end.x >= current.start.x){
                        unified.end.x = Math.max(unified.end.x, current.end.x);
                    } else{
                        unifiedSegments.add(unified);
                        unified = current;
                    }
                } else{
                    if(unified.start.x == current.start.x && unified.end.y >= current.start.y){
                        unified.end.y = Math.max(unified.end.y, current.end.y);
                    } else{
                        unifiedSegments.add(unified);
                        unified = current;
                    }
                }
            } else{
                unifiedSegments.add(unified);
                unified = current;
            }
        }
        unifiedSegments.add(unified);
        length = unifiedSegments.size();
        for(Segment s : unifiedSegments){
            s.parent = s;
            s.segmentCount = 1;
        }

        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                if(unifiedSegments.get(i).direction != unifiedSegments.get(j).direction){
                    int d = intersect(unifiedSegments.get(i), unifiedSegments.get(j));
                    if(d>=0){
//                        System.out.println((i+1)+" "+(j+1)+": "+d);
                        union(unifiedSegments.get(i), unifiedSegments.get(j), d);
                    }
                }
            }
        }

        int componentCount = 0;
        for(Segment s : unifiedSegments){
            Segment r = find(s);
            if(r.visited == 0){
                r.visited = 1;
                componentCount ++;
                int penLift = (r.segmentCount*2-r.oddDeduction)/2;
                if(penLift == 0) penLift = 1;
                ret += (penLift == 0) ? 1 : penLift;
            }
        }
        if(n%2==0) ret = componentCount;
        return ret-1;
    }
}
