package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R264D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int ret=-1;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(s>x && y>0) ret = Math.max(ret, 100-y);
            if(s>=x && y==0) ret = Math.max(ret, 0);
        }
        System.out.println(ret);
    }

}
