package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/20/14.
 */
public class CoderStrike2014B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[] sentCount = new int[n];
        int[] receivedCount = new int[m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int sender = Integer.parseInt(st.nextToken())-1;
            int receiver = Integer.parseInt(st.nextToken())-1;
            sentCount[sender]++;
            receivedCount[receiver]++;
        }
        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<m; j++){
                if(a[i][j]==1) count+=receivedCount[j];
            }
            count-=sentCount[i];
            if(i==n-1) System.out.println(count); else System.out.print(count+" ");
        }

    }

}
