package usaco;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 1/19/14
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Skicourse {
    static class Pair{
        int x; int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int[][] conf;
    static int[][] getClone(){
        int[][] ret = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ret[i][j] = conf[i][j];
            }
        }
        return ret;
    }
    static int[][] getColSum(int[][] a, int sign){
        int[][] ret = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int added = sign*a[i][j]>0 ? 1 : 0;
                if(i>0) ret[i][j] = added+ret[i-1][j]; else ret[i][j] = added;
            }
        }
        return ret;
    }
    static Pair findPos(int[][] a, int b){
        int[][] posSum = getColSum(a, 1);
        int[][] negSum = getColSum(a, -1);
        int[] posCount = new int[m];
        int[] negCount = new int[m];
        int maxSize = 0;
        int x=0, y=0;
        for(int i=b-1; i<n; i++){
            Arrays.fill(posCount, 0);
            Arrays.fill(negCount, 0);
            for(int j=0; j<m; j++){
                posCount[j] = (j>0?posCount[j-1]:0)+posSum[i][j]- (i>b-1 ? posSum[i-b][j] : 0);
                negCount[j] = (j>0?negCount[j-1]:0)+negSum[i][j]- (i>b-1 ? negSum[i-b][j] : 0);
            }
            for(int j=b-1; j<m; j++){
                int posTot = posCount[j]-(j>b-1?posCount[j-b]:0);
                int negTot = negCount[j]-(j>b-1?negCount[j-b]:0);
                if(posTot+negTot>0 && negTot*posTot==0){
                    if(maxSize<posTot+negTot) maxSize=posTot+negTot;
                    x = i-b+1; y=j-b+1;
                }
            }
        }
        if(maxSize==0) return null;
        return new Pair(x,y);
    }
    static boolean valid(int b){
        int[][] a = getClone();
        Pair pos;
        while((pos=findPos(a, b))!=null){
            for(int i=pos.x; i<pos.x+b; i++){
                for(int j=pos.y; j<pos.y+b; j++){
                    a[i][j] = 0;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j]!=0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("skicourse.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skicourse.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        conf = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                conf[i][j] = s.charAt(j)=='S' ? 1 : -1;
            }
        }
        int l=1, r=Math.min(n,m);
        while(l<r){
            int mid = (r-l+1)/2+l;
            if(valid(mid)) l=mid; else r=mid-1;
        }
        out.println(l);
        out.close();
    }
}
