package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class R221D2B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] in = new int[n];
        int[] out = new int[n];
        int total=0;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            in[y]+=w;
            out[x]+=w;
            total+=w;
        }
        int deducted=0;
        for(int i=0; i<n; i++) deducted+=Math.min(in[i], out[i]);
        System.out.println(total-deducted);
    }


}
