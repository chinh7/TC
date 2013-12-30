package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/31/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class End2013D {
    static class Pair{
        long a, b, c;
        public Pair(long a, long b, long c){
            this.a = a;
            this.b = b;
        }
    }
    static String generate(String s, int n, int x){
        StringBuilder sb = new StringBuilder();
        if(s.equals("AA")){
            if(n>=2*x+1){
                for(int i=0; i<x; i++) sb.append("AC");
                for(int i=0; i<n-2*x; i++) sb.append("A");
            }
        }
        if(s.equals("CC")){
            if(n>=2*x+1){
                for(int i=0; i<n-2*x; i++) sb.append("C");
                for(int i=0; i<x; i++) sb.append("AC");
            }

        }
        if(s.equals("AC")){
            if(n>=2*x){
                for(int i=0; i<x; i++) sb.append("AC");
                for(int i=0; i<n-2*x; i++) sb.append("C");
            }
        }
        if(s.equals("CA")){
            if(n>=2*x+2){
                sb.append("C");
                for(int i=0; i<x; i++) sb.append("AC");
                for(int i=0; i<n-2*x-1; i++) sb.append("A");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        long count = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] strings = {"AA", "AC", "CA", "CC"};
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                Pair u = new Pair(0, 1, 0);
                Pair v = new Pair(1, 0, 0);
                String su = strings[i];
                String sv = strings[j];
                for(int e=3; e<=k; e++){
                    String middle = sv.charAt(1)+""+su.charAt(0);
                    int added = 0;
                    if(middle.equals("AC")) added=1;

                    Pair tmp = v;
                    v = new Pair(u.a+v.a, u.b+v.b, u.c+v.c+added);
                    u = tmp;

                    String sTmp = sv;
                    sv = sv.charAt(0)+""+su.charAt(1);
                    su = sTmp;
                }
                for(int x=0; x<=n/2; x++){
                    for(int y=0; y<=m/2; y++){
                        if(v.a*x+v.b*y+v.c==count){
                            String sa = generate(strings[j],m,x);
                            String sb = generate(strings[i],n,y);
                            if(sa.length()>0 && sb.length()>0){
                                System.out.println(sa);
                                System.out.println(sb);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Happy new year!");

    }
}
