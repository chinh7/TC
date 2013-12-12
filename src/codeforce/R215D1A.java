package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R215D1A {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[][] count = new int[n+1][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++) count[i+1][j] = count[i][j];
            count[i+1][s.charAt(i)-'x']++;
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int x = count[r][0]-count[l-1][0];
            int y = count[r][1]-count[l-1][1];
            int z = count[r][2]-count[l-1][2];
            int min = Math.min(x,Math.min(y,z));
            x -= min; y-=min; z-=min;
            if((x<2 && y<2 && z<2) || (r-l)<2) System.out.println("YES"); else System.out.println("NO");
        }
    }

}
