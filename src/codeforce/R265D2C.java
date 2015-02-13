package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 18/11/2014.
 */
public class R265D2C {
    static boolean valid(char c, int p){
        return (c-'a'<p);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char maxChr = (char)('a'+p-1);
        String s = br.readLine();
        for(int i=n-1; i>=0; i--){
            char[] ret = new char[n];
            for(int j=0; j<i; j++) ret[j]=s.charAt(j);
            for(char candidate=(char)(s.charAt(i)+1); candidate<=maxChr; candidate++){
                if(i>0 && candidate==s.charAt(i-1)) continue;
                if(i>1 && candidate==s.charAt(i-2)) continue;
                ret[i]=candidate;
                break;
            }
            if(ret[i]==0) continue;
            boolean valid=true;
            for(int j=i+1; j<n; j++){
                for(char candidate='a'; candidate<=maxChr; candidate++){
                    if(candidate==ret[j-1]) continue;
                    if(j>1 && candidate==ret[j-2]) continue;
                    ret[j] = candidate;
                    break;
                }
                if(ret[j]==0){
                    valid = false;
                    break;
                }
            }
            if(valid) {
                System.out.println(new String(ret));
                return;
            }
        }
        System.out.println("NO");
    }
}
