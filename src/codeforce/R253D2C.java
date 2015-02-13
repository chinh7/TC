package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by chinh on 11/11/2014.
 */
public class R253D2C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<n; i++) set.add(st.nextToken());
        n = set.size();
        String[] cards = set.toArray(new String[0]);
        char[] hints = {'R', 'G', 'B', 'Y', 'W', '1', '2', '3','4', '5'};
        int m = hints.length;
        int ret = Integer.MAX_VALUE;
        for(int i=0; i<(1<<m); i++){
            int[] cardValues = new int[n];
            int popCount=0;
            for(int pos=0; pos<m; pos++){
                if((i&(1<<pos))>0){
                    popCount++;
                    for(int j=0; j<n; j++){
                        if(hints[pos]==cards[j].charAt(0) || hints[pos]==cards[j].charAt(1)){
                            cardValues[j] += 1<<pos;
                        }
                    }
                }
            }
            Arrays.sort(cardValues);
            boolean valid = true;
            for(int j=0; j<n-1; j++){
                if(cardValues[j]==cardValues[j+1]) valid=false;
            }
            if(valid) ret = Math.min(ret, popCount);
        }
        System.out.println(ret);
    }
}
