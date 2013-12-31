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
public class R222D2A {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int first=0, draw=0, second=0;
        for(int i=1; i<=6; i++){
            if(Math.abs(a-i)<Math.abs(b-i)){
                first++;
            } else
            if(Math.abs(a-i)>Math.abs(b-i)){
                second++;
            } else{
                draw++;
            }
        }
        System.out.println(first+" "+draw+" "+second);
    }

}
