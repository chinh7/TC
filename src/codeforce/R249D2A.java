package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/30/14.
 */
public class R249D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int total=m;
        int count=0;
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(total+x<=m) total+=x; else{
                total=x;
                count++;
            }
        }
        System.out.println(count);
    }
}
