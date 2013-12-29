package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/28/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class R220D2D {
    static int query(int[] bit, int index){
        int ret = 0;
        while(index>0){
            ret += bit[index-1];
            index -= index&-index;
        }
        return ret;
    }
    static void update(int[] bit, int index, int value){
        int max = bit.length;
        while(index<=max){
            bit[index-1] += value;
            index += index&-index;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int pos[] = new int[m];
        int bit[] = new int[n];
        int a[] = new int[n];
        for(int i=0; i<m; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }
        int k = 0;
        for(int i=0; i<n; i++){
            int v = Integer.parseInt(br.readLine());
            if(v<0){
                ArrayList<Integer> deleted = new ArrayList<Integer>();
                for(int j=0; j<m; j++){
                    int l = 1, r = k;
                    while(l<r){
                        int mid = (r-l)/2+l;
                        if(query(bit, mid)>=pos[j]) r = mid; else l = mid+1;
                    }
                    if(query(bit, l)==pos[j]){
                        deleted.add(l);
                    } else break;
                }
                for(int j : deleted) update(bit, j, -1);
            } else{
                a[k++] = v;
                update(bit, k, 1);
            }
        }
        int prev = 0;
        for(int i=0; i<k; i++){
            int cur = query(bit, i+1);
            if(cur>prev){
                System.out.print(a[i]);
                prev = cur;
            }
        }
        if(prev>0) System.out.println(); else System.out.println("Poor stack!");
    }

}
