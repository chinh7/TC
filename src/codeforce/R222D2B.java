package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R222D2B {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        int ia=0, ib=0;
        while(ia+ib<n){
            if(a[ia]<b[ib]) ia++; else ib++;
        }
        for(int i=0; i<Math.max(ia, n/2); i++) System.out.print(1);
        for(int i=Math.max(ia, n/2); i<n; i++) System.out.print(0);
        System.out.println();
        for(int i=0; i<Math.max(ib, n/2); i++) System.out.print(1);
        for(int i=Math.max(ib, n/2); i<n; i++) System.out.print(0);
        System.out.println();
    }

}
