package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/18/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Partition {
    static int n, k, chosenN;
    static ArrayList<Integer> chosen = new ArrayList<Integer>();
    static int[][] a, cols;
    static int result = Integer.MAX_VALUE;
    static int maxSum(int u, int v){
        int max = 0;
        for(int i=0; i<=chosenN; i++){
            int sum = 0;
            for(int j=u; j<=v; j++){
                sum+=cols[j][i];
            }
            if(max<sum) max=sum;
        }
        return max;
    }
    static int findBest(){
        int remain = k - chosenN;
        int[][] best = new int[n][remain+1];
        for(int i=0; i<n; i++){
            best[i][0] = maxSum(0, i);
            for(int used=1; used<=remain; used++){
                best[i][used] = Integer.MAX_VALUE;
                for(int j=0; j<i; j++){
                    int max = Math.max(maxSum(j+1, i), best[j][used-1]);
                    if(best[i][used]>max) best[i][used] = max;
                }
            }
        }
        return best[n-1][remain];
    }
    static void choose(int current){
        if(chosen.size()==chosenN){
            boolean[] selected = new boolean[n-1];
            for(int i=0; i<chosenN; i++) selected[chosen.get(i)] = true;
            cols = new int[n][chosenN+1];
            for(int i=0; i<n; i++){
                int sum = 0;
                int block = 0;
                for(int j=0; j<n; j++){
                    sum+=a[i][j];
                    if((j<n-1 && selected[j]) || j==n-1){
                        cols[i][block] = sum;
                        sum=0;
                        block++;
                    }
                }
            }
            int min = findBest();
            if(result>min) result = min;
            return;
        }
        if(n-1-current<chosenN-chosen.size()) return;
        chosen.add(current);
        choose(current+1);
        chosen.remove(chosen.size()-1);
        choose(current+1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("partition.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("partition.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(chosenN=0; chosenN<=k; chosenN++){
            choose(0);
        }
        out.println(result);
        out.close();
    }
}
