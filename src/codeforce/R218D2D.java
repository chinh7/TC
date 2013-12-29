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

/**
 * Unlike R220D2D, this problem can be solved by just using a TreeSet instead of a BIT, since we have the original index for update operation.
 * In R220D2D, we are given the "real-time" index, so counting using BIT is quite a must. Anyhow, the solution below reconfirmed
 * BIT's capacity to solve this kind of deleted-in-real-time problem.
 */
public class R218D2D {
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] o = new int[n];
        int[] bit = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            o[i] = a[i];
            update(bit, i+1, 1);
        }
        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1){
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                while(value>0){
                    if(a[index-1]==0){
                        int l=1; int r=n;
                        int realIndex = query(bit, index);
                        while(l<r){
                            int mid = (r-l)/2+l;
                            if(query(bit, mid)>realIndex) r=mid; else l=mid+1;
                        }
                        if(query(bit, l)>realIndex){
                            index = l;
                        } else{
                            value = 0;
                        }
                    } else{
                        if(value>=a[index-1]){
                            value -= a[index-1];
                            a[index-1] = 0;
                            update(bit, index, -1);
                        } else{
                            a[index-1] -= value;
                            value = 0;
                        }
                    }
                }
            } else{
                int index = Integer.parseInt(st.nextToken());
                System.out.println(o[index-1]-a[index-1]);
            }
        }
    }

}
