package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class R224D2C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1; i<n; i++){
            set.add(a[i]-a[i-1]);
            if(set.size()>2){
                System.out.println(0);
                return;
            }
        }
        if(set.size()==0){
            System.out.println(-1);
            return;
        }
        if(set.size()==1){
            int diff = set.toArray(new Integer[0])[0];
            if(diff==0){
                System.out.println(1);
                System.out.println((a[0]));
            }
            if(n==2 && (a[0]+a[1])%2==0){
                System.out.println(3);
                System.out.println((a[0]-diff)+" "+(a[0]+a[1])/2+" "+(a[1]+diff));
            } else{
                System.out.println(2);
                System.out.println((a[0]-diff)+" "+(a[n-1]+diff));
            }
        } else{
            Integer[] values = set.toArray(new Integer[0]);
            int max = (values[0]>values[1]) ? values[0] : values[1];
            int min = (values[0]<values[1]) ? values[0] : values[1];
            if(max%2==1 || max/2!=min){
                System.out.println(0);
                return;
            }
            int left=-1, right=-1;
            for(int i=1; i<n; i++){
                if(a[i]-a[i-1]==max){
                    if(left==-1){
                        left = a[i-1]; right=a[i];
                    } else{
                        System.out.println(0);
                        return;
                    }
                }
            }
            System.out.println(1);
            System.out.println((left+right)/2);
        }
    }

}
