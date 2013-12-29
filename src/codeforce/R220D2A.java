package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/19/13
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class R220D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] u = {1,n,n,1};
        int[] v = {m,1,m,1};
        int result = Integer.MAX_VALUE;
        for(int e=0; e<4; e++){
            int x = Math.abs(u[e]-i);
            int y = Math.abs(v[e]-j);
            if(x==0 && y==0) result=0;
            if(x%a==0 && y%b==0){
                if((x/a)%2==(y/b)%2){
                    if(a<n&&b<m) result = Math.min(result, Math.max(x/a, y/b));
                }
            }
        }
        if(result==Integer.MAX_VALUE) System.out.println("Poor Inna and pony!"); else System.out.println(result);
    }
}
