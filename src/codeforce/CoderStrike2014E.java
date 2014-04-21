package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/20/14.
 */
public class CoderStrike2014E {
    static final int MAX = Integer.MAX_VALUE-2;
    static int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] map = new String[2];
        for(int i=0; i<2; i++){
            map[i] = br.readLine();
        }

        int[][] distant = new int[2][n];
        Arrays.fill(distant[0],MAX);
        Arrays.fill(distant[1],MAX);
        int[][] group = new int[2][n];
        int groupCount=0;
        for(int j=0; j<n; j++){
            group[0][j]=group[1][j]=groupCount;
            for(int i=0; i<2; i++){
                if(map[i].charAt(j)=='.'){
                    if(j>0 && group[i][j-1]>=0) distant[i][j] = Math.min(distant[i][j], distant[i][j-1]+1);
                    if(j>0 && group[1-i][j]>=0 && map[1-i].charAt(j)=='.') distant[i][j] = Math.min(distant[i][j], distant[1-i][j-1]+2);
                } else{
                    group[i][j]=-1;
                }
            }
            if(map[0].charAt(j)=='.' && distant[0][j]==MAX){
                distant[0][j] = 0;
                group[0][j] = ++groupCount;
                if(map[1].charAt(j)=='.'){
                    distant[1][j] = 1;
                    group[1][j]=groupCount;
                }
            }
            else if(map[1].charAt(j)=='.' && distant[1][j]==MAX){
                distant[1][j] = 0;
                group[1][j] = ++groupCount;
            }
        }
//        for(int i=0; i<2; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(distant[i][j]==MAX ? "x " : distant[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for(int i=0; i<2; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(group[i][j]+" ");
//            }
//            System.out.println();
//        }

        int[] checkPoint = new int[n];
        Arrays.fill(checkPoint, -1);
        for(int j=0; j<n; j++){
            if((long)group[0][j]*group[1][j]<0){
                int i=j;
                while(i>=0 && checkPoint[i]<0){
                    checkPoint[i]=j;
                    i--;
                }
            }
        }
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xi=(x-1)/n;
            int xj=(x-1)%n;
            int yi=(y-1)/n;
            int yj=(y-1)%n;
            if(xj>yj){
                int tmp=xj;
                xj=yj;
                yj=tmp;
                tmp=xi;
                xi=yi;
                yi=tmp;
            }
            if(group[xi][xj]!=group[yi][yj]){
                System.out.println(-1);
            } else{
                int cj = checkPoint[Math.min(xj, yj)];
                int ci = 0;
                if(cj>=0 && group[ci][cj]<0) ci=1;
                if(xj<=cj && cj<=yj){
                    System.out.println(distant[yi][yj]-distant[ci][cj]+Math.abs(ci-xi)+Math.abs(cj-xj));
                } else{
                    System.out.println(Math.abs(xi-yi)+Math.abs(xj-yj));
                }
            }
        }
    }

}

