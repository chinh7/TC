package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/13/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */

///WA - editorial solution is too domain-specific, wont fix
public class CHEFGM {
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                long[] values = new long[n];
                for(int j=0; j<n; j++){
                    values[j] = Long.parseLong(st.nextToken());
                }
                Arrays.sort(values);
                //remove dups
                n = 0;
                for(int j=0; j<values.length; j++){
                    if(j==values.length-1 || values[j]!=values[j+1]) values[n++] = values[j];
                }
                //
                int count = 0;
                for(int j=n-1; j>=0; j--){
                    if(values[j]%2==1){
                        if(count<0) count=0; else count++;
                    } else{
                        if(count>0) count=0; else count--;
                    }
                }
                if(values[0]%2==1) count++; else count--;
                sum+=count;
            }
            if(sum==0) System.out.println("DON'T PLAY"); else
            if(sum>0) System.out.println("ODD"); else System.out.println("EVEN");
        }

    }

}
