package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by chinh on 7/13/14.
 */
public class R234D2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String s = br.readLine();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int a=1; a<=12; a++){
                if(12%a>0) continue;
                int b=12/a;
                for(int j=0; j<b; j++){
                    boolean valid=true;
                    for(int i=0; i<a; i++){
                        if(s.charAt(j+i*b)!='X') valid=false;
                    }
                    if(valid){
                        list.add(a);
                        break;
                    }
                }
            }
            System.out.print(list.size());
            for(int a : list) System.out.print(" "+a+"x"+(12/a));
            System.out.println();
        }

    }
}
