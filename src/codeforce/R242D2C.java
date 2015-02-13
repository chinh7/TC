package codeforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R242D2C {
    static int[] xor;
    // i^(i+1)^....^j with i>0
    static int xorRange(int i, int j){
        if(i>j) return 0;
        return xor[j]^xor[i-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        xor = new int[n];
        for(int i=1; i<n; i++){
            xor[i] = i^xor[i-1];
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        for(int i=0; i<n; i++){
            ret ^= Integer.parseInt(st.nextToken());
        }
        for(int i=2; i<=n; i++){
            int round = n/i;
            if(round%2==0){
                ret ^= xorRange(1, n%i);
            } else{
                ret ^= xorRange(n%i+1, i-1);
            }
        }
        System.out.println(ret);
    }
}