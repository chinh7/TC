package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chinh on 6/13/14.
 */
public class ZeptoB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] map = new String[n];
        for(int i=0; i<n; i++){
            map[i] = br.readLine();
        }
        for(int j=0; j<m; j++){
            int total=0;
            for(int i=1; i<n; i++){
                int count = (j-i>=0&&map[i].charAt(j-i)=='R'?1:0)
                           +(j+i<m &&map[i].charAt(j+i)=='L'?1:0)
                           +(i+i<n &&map[i+i].charAt(j)=='U'?1:0);
                total+=count;
            }
            if(j==m-1) System.out.println(total); else System.out.print(total+" ");
        }
    }
}
