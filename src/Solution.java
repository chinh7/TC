import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/4/13
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    static class Suffix implements Comparable<Suffix>{
        String string;
        int index;
        public Suffix(String string, int index){
            this.string = string;
            this.index = index;
        }
        public int compareTo(Suffix other){
            return this.string.compareTo(other.string);
        }
    }
    static int[] getSuffixArray(String s){
        int n = s.length();
        Suffix[] suffices = new Suffix[n];
        for (int i=0; i<n; i++){
            suffices[i] = new Suffix(s.substring(i), i);
        }
        Arrays.sort(suffices);
        int[] suffixArray = new int[n];
        for(int i=0; i<n; i++) suffixArray[i] = suffices[i].index;
        return suffixArray;
    }
    static int lcp(String s, int ai, int bi) {
        String a = s.substring(ai);
        String b = s.substring(bi);
        int n = Math.min(a.length(), b.length());
        for(int i=0; i<n; i++){
            if(a.charAt(i)!=b.charAt(i)) return i;
        }
        return n;
    }
    static int count(String s){
        int[] suffixArray = getSuffixArray(s);
        int n = s.length();
        int result = n-suffixArray[0];
        for(int i=1; i<n; i++){
            result += n-suffixArray[i]-lcp(s,suffixArray[i],suffixArray[i-1]);
        }
        return result;
    }
    public static void main() throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(count(s));
    }
}