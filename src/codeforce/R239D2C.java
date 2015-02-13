package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/6/14.
 */
public class R239D2C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for(int i=1; i<a; i++){
            int j = (int)Math.sqrt(a*a-i*i);
            if(i*i+j*j==a*a){
                if(i*b%a==0 && j*b%a==0){
                    int ii = i*b/a;
                    int jj = j*b/a;
                    if(ii*ii+jj*jj==b*b && j!=ii && j!=-i){
                        System.out.println("YES");
                        System.out.println("0 0");
                        System.out.println(-i+" "+j);
                        System.out.println(jj+" "+ii);
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
