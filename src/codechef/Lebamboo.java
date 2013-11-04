package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/4/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lebamboo {
    static int solve(int[] b){
        int n = b.length;
        if(n==1){
            if(b[0]<=0) return -b[0]; else return -1;
        }
        if(n==2){
            if(b[0] != -b[1]) return -1;
            return Math.abs(b[0]);
        }

        int sum = 0;
        for(int i=0; i<n; i++) sum+=b[i];
        return sum/(n-2);
    }
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Lebamboo.input"));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                b[i] = Integer.parseInt(st.nextToken()) - b[i];
            }
            System.out.println(solve(b));
        }
    }
}
