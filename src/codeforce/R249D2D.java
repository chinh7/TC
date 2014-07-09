package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/30/14.
 */
//WA
public class R249D2D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] white = new boolean[n][m];
        for(int i=0; i<n; i++){
            String row = br.readLine();
            for(int j=0; j<m; j++){
                if(row.charAt(j)=='0') white[i][j]=true; else white[i][j]=false;
            }
        }

        int[][][] extent = new int[n][m][4];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!white[i][j]) continue;
                int ii=-1, jj=-1, count=0;
                while(i+ii>=0 && j+jj>=0 && white[i+ii][j+jj]){
                    ii--;
                    jj--;
                    count++;
                }
                extent[i][j][0]=count;

                ii=-1; count=0;
                while(i+ii>=0 && white[i+ii][j]){
                    ii--;
                    count++;
                }
                extent[i][j][1]=count;

                ii=-1; jj=1; count=0;
                while(i+ii>=0 && j+jj<m && white[i+ii][j+jj]){
                    ii--;
                    jj++;
                    count++;
                }
                extent[i][j][2]=count;

                jj=1; count=0;
                while(j+jj<m && white[i][j+jj]){
                    jj++;
                    count++;
                }
                extent[i][j][3]=count;
            }
        }


        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!white[i][j]) continue;

                int ii=-1, jj=1, count=0;
                while(i+ii>=0 && j+jj<m){
                    if(extent[i][j+jj][0]<count+1) break;
                    ii--;
                    jj++;
                    count++;
                }
                result+=count;

                ii=1; jj=1; count=0;
                while(i+ii<n && j+jj<m){
                    if(extent[i+ii][j][2]<count+1) break;
                    ii++;
                    jj++;
                    count++;
                }
                result+=count;

                ii=1; jj=-1; count=0;
                while(i+ii<n && j+jj>=0){
                    if(extent[i+ii][j][0]<count+1) break;
                    ii++;
                    jj--;
                    count++;
                }
                result+=count;

                ii=-1; jj=-1; count=0;
                while(i+ii>=0 && j+jj>=0){
                    if(extent[i][j+jj][2]<count+1) break;
                    ii--;
                    jj--;
                    count++;
                }
                result+=count;


                ii=-1; int jj1=-1, jj2=1; count=0;
                while(i+ii>=0 && j+jj1>=0 && j+jj2<m){
                    if(extent[i+ii][j+jj1][3]<2*(count+1)) break;
                    ii--;
                    jj1--;
                    jj2++;
                    count++;
                }
                result+=count;

                jj=1; int ii1=-1, ii2=1; count=0;
                while(j+jj<m && i+ii1>=0 && i+ii2<n){
                    if(extent[i+ii2][j+jj][1]<2*(count+1)) break;
                    jj++;
                    ii1--;
                    ii2++;
                    count++;
                }
                result+=count;

                ii=1; jj1=-1; jj2=1; count=0;
                while(i+ii<n && j+jj1>=0 && j+jj2<m){
                    if(extent[i+ii][j+jj1][3]<2*(count+1)) break;
                    ii++;
                    jj1--;
                    jj2++;
                    count++;
                }
                result+=count;

                jj=-1; ii1=-1; ii2=1; count=0;
                while(j+jj>=0 && i+ii1>=0 && i+ii2<n){
                    if(extent[i+ii2][j+jj][1]<2*(count+1)) break;
                    jj--;
                    ii1--;
                    ii2++;
                    count++;
                }
                result+=count;

            }
        }
        System.out.println(result);
    }
}
