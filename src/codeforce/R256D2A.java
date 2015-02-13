package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R256D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int total = b/10+a/5+(b%10==0?0:1)+(a%5==0?0:1);
        if(n>=total) System.out.println("YES"); else System.out.println("NO");
    }
}
