package topcoder;
public class EnclosingTriangleColorful {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        //>0: a->b->this counterclockwise, i.e c is on the left of ab
        //=0: collinear;
        public int ccw(Point a, Point b){
            Point c = this;
            Point ba = b.sub(a);
            Point cb = c.sub(b);
            return (ba.x*cb.y-ba.y*cb.x);
        }
        private Point sub(Point a){
            return new Point(this.x-a.x, this.y-a.y);
        }
    }
    Point getPoint(int i, int section, int m){
        //4 sections, starting from lower horizontal line, going clockwise;
        switch (section){
            case 0:
                return new Point(i, 0);
            case 1:
                return new Point(0, i);
            case 2:
                return new Point(i, m);
            default:
                return new Point(m, m-i);
        }
    }
    boolean allRight(Point a, Point b, Point[] blacks){
        for(int i=0; i<blacks.length; i++){
            if(blacks[i].ccw(a,b)>0) return false;
        }
        return true;
    }
    boolean allLeft(Point a, Point b, Point[] blacks){
        for(int i=0; i<blacks.length; i++){
            if(blacks[i].ccw(a,b)<0) return false;
        }
        return true;
    }

    public int getNumber(int m, int[] x, int[] y){
        int n = x.length;
        Point[] blacks = new Point[n];
        for(int i=0; i<n; i++) blacks[i] = new Point(x[i], y[i]);

        int result=0;
        for(int i=0; i<=1; i++){
            for(int a=1; a<m; a++){
                for(int j=i+1; j<=2; j++){
                    for(int b=1; b<m; b++){
                        Point pa = getPoint(a,i,m);
                        Point pb = getPoint(b,j,m);
                        if(allRight(pa,pb,blacks)){
                            for(int k=j+1; k<=3; k++){
                                int l=1, r=m-1;
                                while(l<r){
                                    int mid = (r-l)/2+l;
                                    if(allLeft(pa, getPoint(mid,k,m), blacks)){
                                        r=mid;
                                    } else{
                                        l=mid+1;
                                    }
                                }
                                if(!allLeft(pa, getPoint(l,k,m), blacks)) continue;
                                int lower = l;
                                l=1; r=m-1;
                                while(l<r){
                                    int mid = (r-l+1)/2+l;
                                    if(allRight(pb, getPoint(mid,k,m), blacks)){
                                        l=mid;
                                    } else{
                                        r=mid-1;
                                    }
                                }
                                if(!allRight(pb, getPoint(l,k,m), blacks)) continue;
                                int upper = l;
                                if(upper>=lower) result+=upper-lower+1;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}