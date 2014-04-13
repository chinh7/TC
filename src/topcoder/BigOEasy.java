package topcoder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 2/8/14
 * Time: 1:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class BigOEasy {
    public String isBounded(String[] graph){
        int n = graph.length;
        long[][] a = new long[n][n];
        ArrayList<Long> list = new ArrayList<Long>();
        long sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = graph[i].charAt(j)=='Y' ? 1 : 0;
                sum+=a[i][j];
            }
        }
        list.add(sum);
        long[][] b = a;
        for(int k=0; k<8; k++){
            long[][] c = new long[n][n];
            sum=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    for(int e=0; e<n; e++){
                        c[i][j] += b[i][e]*a[e][j];
                    }
                    sum+=c[i][j];
                }
            }
            list.add(sum);
            b = c;
        }
        double ratio = (double)list.get(1)/list.get(0);
        if(ratio<=1) return "Bounded";
        for(int i=2; i<8; i++){
            if(list.get(i)/list.get(i-1)<ratio) return "Bounded";
        }
        return "Unbounded";
    }
}
