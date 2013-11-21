package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/17/13
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */

//follow-up: idea is right, execution is wrong.
//e.g ok() check for 1,2,5 and for 1,2,3,5 is calculated separately.
//if the result for the first is remembered, each check for ok() only run O(k) :)
public class NoChange {
    static int k,n,total,chosenTotal,result=-1;
    static int[] candidates, sum;
    static ArrayList<Integer> chosen = new ArrayList<Integer>();
    static int chosenCount = 0;
    static boolean ok;

    static boolean ok(){
        int[] maxIndex = new int[1<<chosenCount];
        maxIndex[0] = -1;
        for(int i=1; i<(1<<chosenCount); i++){
            for(int pos=0; pos<chosenCount; pos++){
                if((i&(1<<pos))!=0){
                    int j = i^(1<<pos);
                    int offset = 0;
                    if(j!=0) offset = sum[maxIndex[j]];
                    int l = maxIndex[j]+1, r=n-1;
                    while(l<r){
                        int mid = (r-l+1)/2+l;
                        if(sum[mid]-offset<=chosen.get(pos)){
                            l = mid;
                        } else{
                            r = mid-1;
                        }
                    }
                    if(l==n-1) return true;
                    maxIndex[i] = Math.max(maxIndex[i],l);
                }
            }
        }
        return false;
    }

    static void choose(int index){
        if(chosen.size()==chosenCount){
            chosenTotal = 0;
            for(int element : chosen) chosenTotal+=element;
            if(ok() && result<(total-chosenTotal)){
                ok = true;
                result = total - chosenTotal;
            }
            return;
        }
        if(candidates.length-index<chosenCount-chosen.size()) return;
        chosen.add(candidates[index]);
        choose(index+1);
        chosen.remove(chosen.size()-1);
        choose(index+1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("nochange.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nochange.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        candidates = new int[k];
        sum = new int[n];
        for(int i=0; i<k; i++){
            candidates[i] = Integer.parseInt(br.readLine());
            total+=candidates[i];
        }
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());
            sum[i] = value;
            if(i>0) sum[i]+=sum[i-1];
        }
        int l = 1; int r = k;
        while(l<r){
            chosenCount = (r-l)/2+l;
            ok = false;
            choose(0);
            if(ok){
                r=chosenCount;
            } else{
                l=chosenCount+1;
            }
        }
        System.out.println(result);
        out.close();
    }

}
