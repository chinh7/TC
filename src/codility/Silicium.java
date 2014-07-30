package codility;

import java.util.Arrays;

/**
 * Created by chinh on 7/23/14.
 */
public class Silicium {
    int n;
    Integer[] a,b;
    int count(int x){
        int ret=0;
        for(int i=0; i<n; i++){
            int l=0, r=n-1;
            while(l<r){
                int mid = l+(r-l)/2;
                if(a[i]*b[mid]>x) r=mid; else l=mid+1;
            }
            if(a[i]*b[l]<=x) l=n;
            ret += n-l;
        }
        return ret;
    }
    public int solution(int X, int Y, int K, int A[], int B[]) {
        n = A.length+1;
        a = new Integer[n];
        b = new Integer[n];
        for(int i=0; i<n; i++){
            a[i] = i<n-1 ? A[i] : X;
            a[i] -= i>0 ? A[i-1] : 0;
            b[i] = i<n-1 ? B[i] : Y;
            b[i] -= i>0 ? B[i-1] : 0;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int l=a[0]*b[0], r=a[n-1]*b[n-1];
        while(l<r){
            int mid = l+(r-l)/2;
            int greaterCount = count(mid);
            if(greaterCount<K) r=mid; else l=mid+1;
        }
        return l;
    }
}