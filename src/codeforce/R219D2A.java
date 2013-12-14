package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/13/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class R219D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] a = new int[9];
        for(int i=0; i<4; i++){
            String s = br.readLine();
            for(int j=0; j<4; j++){
                if(s.charAt(j)!='.') a[s.charAt(j)-'1']++;
            }
        }
        for(int i=0; i<9; i++){
            if(a[i]>2*k){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
