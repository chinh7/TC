package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class R219D2C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
        int j=n-1;
        int result=n;
        for(int i=(n-2)/2; i>=0; i--){
            if(a[i]!=0 && a[i]*2<=a[j]){
                result--;
                a[i]=0;
                a[j]=0;
                while(j>0 && a[j]==0) j--;
            }
        }
        System.out.println(result);
    }

}
