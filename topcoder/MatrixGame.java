package topcoder;

import javax.security.auth.Subject;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/13/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixGame {
    public String swap(String s, ArrayList<Integer> zeroPos){
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int pos : zeroPos){
            sb.append(cs[pos]);
            cs[pos] = '-';
        }
        for(int i=0; i<cs.length; i++){
            if(cs[i]!='-') sb.append(cs[i]);
        }
        return sb.toString();
    }
    public String minimum(String s, ArrayList<Integer> segments){
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int end : segments){
            int zeros = 0;
            int ones = 0;
            for(int i=start; i<end; i++){
                if(s.charAt(i)=='0') zeros++; else ones++;
            }
            for(int i=0; i<zeros; i++) sb.append('0');
            for(int i=0; i<ones; i++) sb.append('1');
            start = end;
        }
        return sb.toString();
    }
    public String transform(String s, String min, ArrayList<Integer> segments){
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int end : segments){
            String sub = s.substring(start, end);
            ArrayList<Integer> zeroPos = new ArrayList<Integer>();
            for(int i=start; i<end; i++){
                if(min.charAt(i)=='0') zeroPos.add(i-start);
            }
            sb.append(swap(sub, zeroPos));
            start = end;
        }
        return sb.toString();
    }
    public ArrayList<Integer> split(String min, ArrayList<Integer> segments){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int start = 0;
        for(int end : segments){
            int zeros = 0;
            int ones = 0;
            for(int i=start; i<end; i++){
                if(min.charAt(i)=='0') zeros++; else ones++;
            }
            if(zeros != 0 && ones != 0){
                ret.add(zeros+start);
                ret.add(end);
            } else ret.add(end);
            start = end;
        }
        return ret;
    }
    public String[] getMinimal(String[] matrix){
        int n = matrix.length;
        int m = matrix[0].length();
        String[] result = new String[n];
        boolean[] added = new boolean[n];
        ArrayList<Integer> segments = new ArrayList<Integer>();
        segments.add(m);

        for(int time=0; time<n; time++){
            String min = "2";
            int minIndex = -1;
            for(int i=0; i<n; i++){
                if(!added[i]){
                    String sorted = minimum(matrix[i], segments);
                    if(sorted.compareTo(min)<0){
                        min = sorted;
                        minIndex = i;
                    }
                }
            }
            added[minIndex] = true;
            result[time] = min;
            for(int i=0; i<n; i++){
                if(!added[i]){
                    matrix[i] = transform(matrix[i], matrix[minIndex], segments);
                }
            }
            segments = split(matrix[minIndex] ,segments);
        }
        return result;

    }
}
