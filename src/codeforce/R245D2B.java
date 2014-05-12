package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/11/14.
 */
public class R245D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] original = new int[n];
        for(int i=0; i<n; i++){
            original[i] = Integer.parseInt(st.nextToken());
        }
        int i=0;
        int result=0;
        while(i<n-1){
            if(original[i]==x && original[i+1]==x){
                int[] a = original.clone();
                a[i]=a[i+1]=-1;
                int start=0;
                while(start<n){
                    while(start<n && a[start]<0) start++;
                    int end=start;
                    while(end<n && (a[end]==a[start] || a[end]<0)) end++;
                    int count=0;
                    for(int j=start; j<end; j++){
                        if(a[j]>=0) count++;
                    }
                    if(count>2){
                        for(int j=start; j<end; j++) a[j]=-1;
                        start = 0;
                    } else{
                        start=end;
                    }
                }
                int destroyed=0;
                for(int j=0; j<n; j++){
                    if(a[j]<0) destroyed++;
                }
                if(result<destroyed) result=destroyed;
                i+=2;
            } else{
                i++;
            }
        }
        System.out.println(result);
    }

}

