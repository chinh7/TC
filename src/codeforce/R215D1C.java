package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R215D1C {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[m];
//        for(int i=0; i<m; i++){
//            st = new StringTokenizer(br.readLine());
//            st.nextToken();
//            a[i] = Integer.parseInt(st.nextToken());
//        }
        Arrays.sort(a);
        long result=0;
        int last=-1;
        for(int i=1; i*(i/2)+i%2<=n && i<=m; i++){
            result+=a[m-i];
            last = i;
        }
        System.out.println(last);
    }

}
