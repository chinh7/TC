package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/6/14.
 */
public class R240D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] result = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int x = Integer.parseInt(st.nextToken());
            int j=x-1;
            while(j<n && result[j]==0){
                result[j]=x;
                j++;
            }
        }
        for(int i=0; i<n; i++){
            if(i==n-1) System.out.println(result[i]); else System.out.print(result[i]+" ");
        }
    }

}
