package topcoder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 3/4/14
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElephantDrinkingEasy {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    class Line{
        Point p0, p1;
        public Line(Point a, Point b){
            this.p0 = a;
            this.p1 = b;
        }
    }
    int ccw(Point p0, Point p1, Point p2)
    {
        int dx1=(p1.x-p0.x), dy1=(p1.y-p0.y);
        int dx2=(p2.x-p0.x), dy2=(p2.y-p0.y);
        if(dy1*dx2 < dy2*dx1) return 1;
        if(dy1*dx2 > dy2*dx1) return -1;
        if(dx1*dx2 < 0 || dy1*dy2 < 0) return -1;
        if((dx1*dx1+dy1*dy1) >= (dx2*dx2+dy2*dy2))
            return 0;
        else
            return 1;
    }
    boolean intersection(Line l1,Line l2)
    {
        return ccw(l1.p0,l1.p1,l2.p0)*ccw(l1.p0,l1.p1,l2.p1) <= 0 &&
                ccw(l2.p0,l2.p1,l1.p0)*ccw(l2.p0,l2.p1,l1.p1) <= 0;
    }

    public int maxElephants(String[] map){
        Line l1 = new Line(new Point(1,0), new Point(0,0));
        Line l2 = new Line(new Point(0,1), new Point(0,3));
        int n = map.length;
        int result=0;
        for(int bits=1; bits<2<<(3*n); bits++){
            ArrayList<Line> lines = new ArrayList<Line>();
            boolean halted = false;
            for(int pos=0; pos<n; pos++){
                if(((bits>>pos)&1)>0){
                    int j = pos;
                    Line line = null;
                    for(int i=0; i<n; i++){
                        if(map[i].charAt(j)=='Y'){
                            line = new Line(new Point(0,j), new Point(i,j));
                            break;
                        }
                    }
                    if(line==null){
                        halted = true;
                        break;
                    }
                    lines.add(line);
                }
            }
            if(halted) continue;

            for(int pos=n; pos<2*n; pos++){
                if(((bits>>pos)&1)>0){
                    int i = pos-n;
                    Line line = null;
                    for(int j=n-1; j>=0; j--){
                        if(map[i].charAt(j)=='Y'){
                            line = new Line(new Point(i,n-1), new Point(i,j));
                            for(Line preLine : lines){
                                if(intersection(line,preLine)){
                                    line = null;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if(line==null){
                        halted = true;
                        break;
                    }
                    lines.add(line);
                }
            }
            if(halted) continue;

            for(int pos=2*n; pos<3*n; pos++){
                if(((bits>>pos)&1)>0){
                    int j = pos-2*n;
                    Line line = null;
                    for(int i=n-1; i>=0; i--){
                        if(map[i].charAt(j)=='Y'){
                            line = new Line(new Point(n-1,j), new Point(i,j));
                            for(Line preLine : lines){
                                if(intersection(line,preLine)){
                                    line = null;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if(line==null){
                        halted = true;
                        break;
                    }
                    lines.add(line);
                }
            }
            if(halted) continue;


            int count=0;
            for(int i=0; i<n; i++){
                Line line = null;
                for(int j=0; j<n; j++){
                    if(map[i].charAt(j)=='Y'){
                        line = new Line(new Point(i,0), new Point(i,j));
                        for(Line preLine : lines){
                            if(intersection(line,preLine)){
                                line = null;
                                break;
                            }
                        }
                        break;
                    }
                }
                if(line!=null) count++;
            }


            for(int pos=0; pos<3*n; pos++){
                if(((bits>>pos)&1)>0) count++;
            }
            if(result<count) result=count;
        }
        return result;
    }
}
