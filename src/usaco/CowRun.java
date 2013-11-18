package usaco;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/17/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */

//failed the tests
public class CowRun {
    static int INF = (int) 1e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("cowrun.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowrun.out")));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> neg = new ArrayList<Integer>();
        ArrayList<Integer> pos = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());
            if(value<0) neg.add(-value); else pos.add(value);
        }
        neg.add(0); pos.add(0);
        Collections.sort(neg);
        Collections.sort(pos);

        int negN = neg.size()-1;
        int posN = pos.size()-1;

        int[][] negTot = new int[negN+1][posN+1];
        int[][] posTot = new int[negN+1][posN+1];

        int[][] negCal = new int[negN+1][posN+1];
        int[][] posCal = new int[negN+1][posN+1];


        for(int i=0; i<=negN; i++){
            for(int j=0; j<=posN; j++){
                if(i+j>0){
                    negCal[i][j] = INF;
                    posCal[i][j] = INF;
                }
                if(i>0){
                    int con = negCal[i-1][j]+negTot[i-1][j]+neg.get(i)-neg.get(i-1); //go from i-1 to i;
                    int rev = posCal[i-1][j]+posTot[i-1][j]+pos.get(j)+neg.get(i); //go from j to i;
                    if(con<rev){
                        negCal[i][j] = con;
                        negTot[i][j] = negTot[i-1][j]+neg.get(i)-neg.get(i-1);
                    } else
                    if(rev<con){
                        negCal[i][j] = rev;
                        negTot[i][j] = posTot[i-1][j]+pos.get(j)+neg.get(i);
                    } else {
                        negCal[i][j] = rev;
                        negTot[i][j] = Math.min(negTot[i-1][j]+neg.get(i)-neg.get(i-1), posTot[i-1][j]+pos.get(j)+neg.get(i));
                    }
                }
                if(j>0){
                    int con = posCal[i][j-1]+posTot[i][j-1]+pos.get(j)-pos.get(j-1);
                    int rev = negCal[i][j-1]+negTot[i][j-1]+neg.get(i)+pos.get(j);
                    if(con<rev){
                        posCal[i][j] = con;
                        posTot[i][j] = posTot[i][j-1]+pos.get(j)-pos.get(j-1);
                    } else
                    if(rev<con){
                        posCal[i][j] = rev;
                        posTot[i][j] = negTot[i][j-1]+neg.get(i)+pos.get(j);
                    } else{
                        posCal[i][j] = rev;
                        posTot[i][j] = Math.min(posTot[i][j-1]+pos.get(j)-pos.get(j-1), negTot[i][j-1]+neg.get(i)+pos.get(j));

                    }

                }
            }
        }
        out.println(Math.min(negCal[negN][posN], posCal[negN][posN]));
        out.close();

    }
}
