package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/8/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SPOONS {
    private static int MAXK = 64;
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //com[k] = k C k/2
        long[] com = new long[MAXK+1];
        com[0] = 1;
        for(int k=1; k<=MAXK; k++){
            if(k%2==0) com[k] = com[k-1]*2; else{
                com[k] = com[k-1]/(k/2+1)*k;
            }
        }


        while(T-- > 0){
            long n = Long.parseLong(br.readLine());
            int k;
            for(k=0; k<=MAXK; k++){
                if(com[k]>=n) break;
            }
            System.out.println(k);
        }

    }

}
