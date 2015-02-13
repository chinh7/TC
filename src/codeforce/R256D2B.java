package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R256D2B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();
        int[] countS = new int['z'-'a'+1];
        int[] countT = new int['z'-'a'+1];
        for(int i=0; i<s.length; i++){
            countS[s[i]-'a']++;
        }
        for(int i=0; i<t.length; i++){
            countT[t[i]-'a']++;
        }
        for(char chr='a'; chr<='z'; chr++){
            if(countT[chr-'a']>countS[chr-'a']){
                System.out.println("need tree");
                return;
            }
        }
        int j=0;
        for(int i=0; i<s.length; i++){
            if(j<t.length && s[i]==t[j]) j++;
        }
        if(j==t.length){
            System.out.println("automaton");
            return;
        }
        Arrays.sort(s);
        Arrays.sort(t);
        if(String.valueOf(s).equals(String.valueOf(t))){
            System.out.println("array");
        } else System.out.println("both");
    }
}
