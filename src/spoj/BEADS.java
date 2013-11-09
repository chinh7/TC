package spoj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/8/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class BEADS {
    static Integer[] FC;
    static int step, n;
    static class Cmp implements Comparator<Integer> {
        public int compare(Integer a, Integer b){
            if(step==-1 || FC[a]!=FC[b]) return FC[a]-FC[b];
            int aa = (a + (1<<step))%n;
            int bb = (b + (1<<step))%n;
            return FC[aa]-FC[bb];
        }
    }
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String s = br.readLine();
            n = s.length();

            Integer[] SA = new Integer[n];
            FC = new Integer[n];
            for(int i=0; i<n; i++) FC[i] = Integer.valueOf(s.charAt(i));
            for(int i=0; i<n; i++) SA[i] = i;

            Cmp comparator = new Cmp();
            for(step = -1; (1<<step)<n; step++){
                Arrays.sort(SA, comparator);
                Integer[] SC = new Integer[n];
                int count = 0;
                for(int i=0; i<n; i++){
                    if(i>0 && comparator.compare(SA[i-1], SA[i]) < 0) count++;
                    SC[SA[i]] = count;
                }
                FC = SC;
                if(count==n-1) break;
            }
            int result = SA[0];
            int i=1;
            while(i<n && comparator.compare(SA[i-1], SA[i])==0){
                if(SA[i]<result) result = SA[i];
                i++;
            }
            System.out.println(result+1);
        }

    }
}
