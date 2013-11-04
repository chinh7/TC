package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/4/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bar {
    static class Number implements Comparable<Number>{
        int value, index;
        public Number(int value, int index){
            this.value = value;
            this.index = index;
        }
        public int compareTo(Number other){
            return this.value-other.value;
        }
    }
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Bar.input"));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Number> list = new ArrayList<Number>(k);
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int length = Integer.parseInt(st.nextToken());
                while(length-- > 0){
                    list.add(new Number(Integer.parseInt(st.nextToken()), i));
                }
            }
            Collections.sort(list);
            int[] lastIndex = new int[n];
            for(int i=0; i<list.size(); i++){
                int index = list.get(i).index;
                lastIndex[index] = i;
            }
            boolean[] track = new boolean[n];
            int count = 0;
            int result = 0;
            for(int i=0; i<list.size(); i++){
                int index = list.get(i).index;
                if(!track[index]){
                    if(count==k-1){
                        result++;
                        System.out.print(list.get(i).value+" ");
                    }
                    if(count>k-1){
                        int diff = count-k+1;
                        for(int j=0; j<n; j++){
                            if(track[j] && lastIndex[j]>i) diff--;
                            if(diff == 0) break;
                        }
                        if(diff==0){
                            result++;
                            System.out.print(list.get(i).value+" ");
                        }
                    }
                    track[index] = true;
                    count++;
                } else{
                    if(count==k){
                        result++;
                        System.out.print(list.get(i).value+" ");
                    }
                    if(count>k){
                        int diff = count-k;
                        for(int j=0; j<n; j++){
                            if(j!=index && track[j] && lastIndex[j]>i) diff--;
                            if(diff == 0) break;
                        }
                        if(diff==0){
                            result++;
                            System.out.print(list.get(i).value+" ");
                        }
                    }
                }
            }
            System.out.println();
            System.out.println(result);
        }
    }
}
