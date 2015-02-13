package codeforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R242D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int up=0, down=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='x') down++; else up++;
        }
        StringBuilder sb = new StringBuilder();
        int ret=0;
        for(int i=0; i<n; i++){
            if(up>down){
                sb.append('x');
                if(s.charAt(i)=='X'){
                    ret++;
                    up--;
                    down++;
                }
            } else
            if(up<down){
                sb.append('X');
                if(s.charAt(i)=='x'){
                    ret++;
                    down--;
                    up++;
                }
            } else{
                sb.append(s.charAt(i));
            }
        }
        System.out.println(ret);
        System.out.println(sb.toString());
    }

}