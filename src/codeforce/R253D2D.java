package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R253D2D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Double> a = new ArrayList<Double>();
        double ret = 0;
        for(int i=0; i<n; i++){
            double x = Double.parseDouble(st.nextToken());
            ret = Math.max(ret, x);
            if(x<0.5f) a.add(x);
        }
        n = a.size();
        Collections.sort(a);
        ArrayList<Double> p = new ArrayList<Double>();
        ArrayList<Double> r = new ArrayList<Double>();
        p.add(0.); r.add(1.);
        for(int i=n-1; i>=0; i--){
            double x = a.get(i);
            int m = p.size();
            for(int j=0; j<m; j++){
                double np = p.get(j)*(1-x)+r.get(j)*x;
                double nr = r.get(j)*(1-x);
                ret = Math.max(ret, np);
                if(nr>np && np>p.get(j)){
                    //why replace? At a later point do we wanna add some value y<x to group j? No because its np would be smaller than the just generated np
                    p.set(j, np); r.set(j, nr);
                }
            }
        }
        System.out.println(ret);

    }
}
