package codeforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by chinh on 7/19/14.
 */
public class R242D2D {
    static int[][] a;
    static int[][] rowRight, rowLeft, colUp, colDown;
    static int n, m, t, tp, tu, td;
    static int value(int i, int j){
        if(j>i) return tu; else
        if(j<i) return td; else return tp;
    }
    static int colValueDown(int c, int i, int j){
        return colDown[j][c]-colDown[i][c];
    }
    static int colValueUp(int c, int i, int j){
        return colUp[j][c]-colUp[i][c];
    }
    static int rowValueRight(int r, int i, int j){
        return rowRight[r][j]-rowRight[r][i];
    }
    static int rowValueLeft(int r, int i, int j){
        return rowLeft[r][j]-rowLeft[r][i];
    }

    static void prep(){
        colUp = new int[n][m];
        colDown = new int[n][m];
        rowLeft = new int[n][m];
        rowRight = new int[n][m];

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                colDown[i][j] = colDown[i-1][j] + value(a[i-1][j], a[i][j]);
            }
        }
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<m; j++){
                colUp[i][j] = colUp[i+1][j] + value(a[i+1][j], a[i][j]);
            }
        }
        for(int j=1; j<m; j++){
            for(int i=0; i<n; i++){
                rowRight[i][j] = rowRight[i][j-1] + value(a[i][j-1], a[i][j]);
            }
        }
        for(int j=m-2; j>=0; j--){
            for(int i=0; i<n; i++){
                rowLeft[i][j] = rowLeft[i][j+1] + value(a[i][j+1], a[i][j]);
            }
        }
    }

    static class Data implements Comparable<Data>{
        int value;
        int index;
        public Data(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int compareTo(Data other){
            return this.value - other.value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tp = Integer.parseInt(st.nextToken());
        tu = Integer.parseInt(st.nextToken());
        td = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        prep();
        int min = Integer.MAX_VALUE;
        int x=0,y=0,u=0,v=0;
        for(int i=0; i<n; i++){
            for(int j=i+2; j<n; j++){
                TreeSet<Data> set = new TreeSet<Data>();
                for(int e=2; e<m; e++){
                    set.add(new Data(e-2, colValueUp(e-2, j, i) - rowValueRight(i, 0, e-2) - rowValueLeft(j, e-2, 0)));
                    int ts = rowValueRight(i, 0, e) + colValueDown(e, i, j) + rowValueLeft(j, e, 0);
                    Data data = set.ceiling(new Data(0, t-ts));
                    if(data!=null){
                        if(Math.abs(ts+data.value-t)<min){
                            min = Math.abs(ts+data.value-t);
                            x=i; u=j; y=data.index; v=e;
                        }
                    }
                    data = set.floor(new Data(0, t-ts));
                    if(data!=null){
                        if(Math.abs(ts+data.value-t)<min){
                            min = Math.abs(ts+data.value-t);
                            x=i; u=j; y=data.index; v=e;
                        }
                    }
                }
            }
        }
        System.out.println((x+1)+" "+(y+1)+" "+(u+1)+" "+(v+1));
    }
}