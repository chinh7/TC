package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 18/11/2014.
 */
public class R265D2D {
    static boolean valid = false;
    static long distanceSquare(long[][] a, int i, int j){
        long ret=0;
        for(int e=0; e<3; e++) ret+=(a[i][e]-a[j][e])*(a[i][e]-a[j][e]);
        return ret;
    }
    static boolean validCube(long[][] a){
        for(int i=0; i<8; i++){
            long[] distance = new long[7];
            int n=0;
            for(int j=0; j<8; j++){
                if(i!=j){
                    distance[n++] = distanceSquare(a, i, j);
                }
            }
            Arrays.sort(distance);
            if(distance[0]==0) return false;
            int[] template = {1,1,1,2,2,2,3};
            for(int j=0; j<7; j++){
                if(distance[j]%distance[0]>0 || template[j]!=distance[j]/distance[0]) return false;
            }
        }
        return true;
    }
    static void swap(long[] a, int i, int j){
        long tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    static void gen(long[][] a, int i, int j){
        if(j==2){
            if(i==7) valid |= validCube(a); else gen(a, i+1, 0);
            return;
        }
        for(int e=j; e<3; e++){
            if(e>j && a[i][j]==a[i][e]) continue;
            swap(a[i], j, e);
            gen(a, i, j+1);
            if(valid) return;
            swap(a[i], j, e);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] a = new long[8][3];
        for(int i=0; i<8; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        gen(a, 0, 0);
        if(valid){
            System.out.println("YES");
            for(int i=0; i<8; i++){
                System.out.println(a[i][0]+" "+a[i][1]+" "+a[i][2]);
            }
        } else System.out.println("NO");
    }
}
