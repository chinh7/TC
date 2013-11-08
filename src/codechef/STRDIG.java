package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/8/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class STRDIG {
    static String solve(String Q){
        for(int digitN = 10; digitN>0; digitN--){
            for(int tailL = digitN; tailL>0; tailL--){
                if(tailL >= Q.length()) return "YES";
                int currentIndex = tailL;
                String prev = Q.substring(0, currentIndex);
                boolean valid = true;
                int digitReal = digitN;
                while(currentIndex<Q.length()){
                    if(prev.length()==10 && prev.compareTo("1000000000")>0){
                        valid = false;
                        break;
                    }

                    int prevL = prev.length();
                    int prevV = Integer.parseInt(prev);
                    prev = String.valueOf(prevV+1);
                    while(prev.length()<prevL) prev = "0"+prev;
                    if(prev.length()>prevL){
                        prev = prev.substring(prev.length()-prevL, prev.length());
                        if(prevL == digitReal){
                            digitReal++;
                            if(digitReal>10){
                                valid = false;
                                break;
                            }
                        }
                    }

                    String current = Q.substring(currentIndex, Math.min(currentIndex+digitReal, Q.length()));
                    currentIndex = currentIndex+current.length();

                    while(current.length()<digitReal) current = current+"a";
                    while(prev.length()<digitReal) prev = "a"+prev;
                    for(int i=0; i<digitReal; i++){
                        if(current.charAt(i)!='a' && prev.charAt(i)!='a' && current.charAt(i)!=prev.charAt(i)){
                            valid=false;
                            break;
                        }
                    }

                    if(!valid) break;
                    prev = current;
                }
                if(valid) return "YES";
            }
        }
        return "NO";
    }
    public static void main() throws Exception{
        System.out.println(solve("000000599000001"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        while(T-- > 0){
//            String Q = br.readLine();
//            System.out.println(solve(Q));
//        }
    }
}
