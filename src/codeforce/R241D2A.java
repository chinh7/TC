package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/13/14.
 */
public class R241D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(">","<=");
        map.put("<",">=");
        map.put(">=","<");
        map.put("<=",">");
        int lower = -(int)1e9*2;
        int upper = (int)1e9*2;
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            String sign = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            String bool = st.nextToken();
            if(bool.equals("N")){
                sign = map.get(sign);
            }
            if(sign.equals(">")){
                number++;
                sign = sign+"=";
            }
            if(sign.equals("<")){
                number--;
                sign = sign+"=";
            }
            if(sign.equals(">=")){
                lower = Math.max(lower, number);
            }
            if(sign.equals("<=")){
                upper = Math.min(upper, number);
            }
        }
        if(lower<=upper) System.out.println(lower); else System.out.println("Impossible");
    }
}
