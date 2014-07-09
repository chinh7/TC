package topcoder.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by chinh on 5/29/14.
 */
public class Subsets {
    class Pair{
        int a; int b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public int findSubset(int[] numbers){
        HashSet<Long> set = new HashSet<Long>();
        ArrayList<Pair> bags = new ArrayList<Pair>();
        bags.add(new Pair(0, 1));
        for(int number : numbers){
            ArrayList<Pair> newBags = new ArrayList<Pair>();
            for(Pair pair : bags){
                if(pair.b*number-1<=1 || pair.a+number>=pair.b*number){
                    if(!set.contains((pair.a+number)*1000000L+pair.b*number)){
                        newBags.add(new Pair(pair.a + number, pair.b * number));
                        set.add((pair.a+number)*1000000L+pair.b*number);
                    }
                }
            }
            bags.addAll(newBags);
        }
        int result=0;
        for(Pair pair : bags){
            if(pair.a>pair.b) result++;
        }
        return result;
    }
}
