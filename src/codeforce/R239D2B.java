package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/6/14.
 */
public class R239D2B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[] ca = new int['z'-'a'+1];
        int[] cb = new int['z'-'a'+1];
        for(int i=0; i<a.length(); i++) ca[a.charAt(i)-'a']++;
        for(int i=0; i<b.length(); i++) cb[b.charAt(i)-'a']++;
        int ret=0;
        for(char chr='a'; chr<='z'; chr++){
            if(cb[chr-'a']>0 && ca[chr-'a']==0){
                System.out.println(-1);
                return;
            }
            ret+=Math.min(ca[chr-'a'], cb[chr-'a']);
        }
        System.out.println(ret);
    }
}
