package codeforce;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/31/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class End2013C {
    static class Point implements Comparable<Point>{
        int index, value;
        public Point(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int compareTo(Point other){
            return this.value-other.value;
        }
    }
    static class Data{
        int value;
        ArrayList<Integer> indices;
        public Data(int value){
            this.value = value;
            indices = new ArrayList<Integer>();
        }
        public void add(int index){
            indices.add(index);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point[] p = new Point[n];
        for(int i=0; i<n; i++){
            p[i] = new Point(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(p);

        Data[] d = new Data[n];

        int m=0;
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n && p[j].value==p[i].value) j++;
            d[m] = new Data(p[i].value);
            for(int e=i; e<j; e++) d[m].add(p[e].index);
            m++;
            i = j;
        }
        int[] result = new int[n];
        i=0;
        while(i<m){
            int j=i+1;
            long sum=d[i].indices.size();
            while(j<m && sum>d[j].value-d[i].value){
                sum += d[j].indices.size();
                j++;
            }
            int u = i, v=0;
            for(int value=d[i].value; value<d[i].value+sum; value++){
                int index = d[u].indices.get(v);
                result[index] = value;
                v++;
                if(v==d[u].indices.size()){
                    u++;
                    v=0;
                }
            }
            i = j;
        }
        for(i=0; i<n; i++){
            if(i==n-1) System.out.println(result[i]); else System.out.print(result[i]+" ");
        }
    }
}
