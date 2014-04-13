package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class R224D2A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("\\|");
        String left = strings.length>0 ? strings[0] : "";
        String right = strings.length>1 ? strings[1] : "";
        String remain = br.readLine();
        int n = left.length()+right.length()+remain.length();
        if(n%2==1 || Math.max(left.length(), right.length())>n/2){
            System.out.println("Impossible");
            return;
        }
        right += remain.substring(n/2-left.length(), remain.length());
        left += remain.substring(0, n/2-left.length());
        System.out.println(left+"|"+right);
    }
}
