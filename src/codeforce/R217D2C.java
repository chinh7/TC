package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/28/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */

public class R217D2C {
    static class MittenPair{
        int left, right;
        public MittenPair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    static void swap(MittenPair x, MittenPair y){
        int tmp = x.right;
        x.right = y.right;
        y.right = tmp;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        MittenPair[] a = new MittenPair[n];
        for(int i=0; i<n; i++){
            int color = Integer.parseInt(st.nextToken());
            a[i] = new MittenPair(color, color);
        }
        Arrays.sort(a, new Comparator<MittenPair>() {
            @Override
            public int compare(MittenPair o1, MittenPair o2) {
                return o1.left-o2.left;
            }
        });
        for(int i=0; i<n/2; i++) swap(a[i], a[n-1-i]);
        int j=0;
        for(int i=0; i<n; i++){
            if(a[i].left==a[i].right){
                while(j<n && (a[j].left==a[i].left || a[j].right==a[i].right)) j++;
                if(j>=n) break;
                swap(a[i],a[j]);
            }
        }
        int result=0;
        for(int i=0; i<n; i++)
            if(a[i].left!=a[i].right) result++;
        System.out.println(result);
        for(int i=0; i<n; i++) System.out.println(a[i].left+" "+a[i].right);
    }

}
