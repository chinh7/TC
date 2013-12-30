package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/31/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class End2013B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            for(int j=0; j<value; j++){
                if(i<n-1){
                    if(j<value-1) System.out.print("PRL"); else System.out.print("P");
                } else{
                    if(j<value-1) System.out.print("PLR"); else System.out.print("P");
                }
            }
            if(i<n-1) System.out.print("R");
        }
        System.out.println();
    }
}
