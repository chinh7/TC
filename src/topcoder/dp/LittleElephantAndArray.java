package topcoder.dp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/24/13
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class LittleElephantAndArray {
    final int MOD = (int)1e9+7;

    class Pair implements Comparable<Pair>{
        long number;
        int value;
        public Pair(long number, int value){
            this.number = number;
            this.value = value;
        }
        public int compareTo(Pair other){
            if(this.number>other.number) return 1; else
            if(this.number<other.number) return -1; else return 0;
        }
    }

    StringBuilder generated;
    ArrayList<Pair> numbers;

    void generate(int index, String number){
        if(index>=number.length()){
            if(generated.length()==0) return;
            numbers.add(new Pair(Long.parseLong(generated.toString()), 0));
            return;
        }
        generated.append(number.charAt(index));
        generate(index + 1, number);
        generated.deleteCharAt(generated.length()-1);
        generate(index+1, number);
    }
    public int getNumber(long A, int N){
        ArrayList<Pair> prev = new ArrayList<Pair>();
        prev.add(new Pair(0,1));
        for(int i=0; i<=N; i++){
            generated = new StringBuilder();
            numbers = new ArrayList<Pair>();
            generate(0, String.valueOf(A + i));
            Collections.sort(numbers);
            int index = 0;
            int sum = 0;
            for(int j=0; j<numbers.size(); j++){
                Pair thisPair = numbers.get(j);
                while(index<prev.size()){
                    Pair prevPair = prev.get(index);
                    if(prevPair.number>thisPair.number) break;
                    sum = (sum+prevPair.value)%MOD;
                    index++;
                }
                thisPair.value = sum;
            }
            prev = numbers;
        }
        int result = 0;
        for(int i=0; i<numbers.size(); i++){
            result = (result+numbers.get(i).value)%MOD;
        }
        return result;
    }
}
