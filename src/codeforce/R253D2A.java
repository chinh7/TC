package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/13/14.
 */
public class R253D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "{}, ");
        HashSet<Character> set = new HashSet<Character>();
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if(s.length()==1) set.add(s.charAt(0));
        }
        System.out.println(set.size());
    }
}
