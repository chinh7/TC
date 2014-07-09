package topcoder;

/**
 * Created by chinh on 5/20/14.
 */
public class TwoWaysSorting {
    public String sortingMethod(String[] stringList){
        boolean lexSorted = true;
        boolean lengthSorted = true;
        int n = stringList.length;
        for(int i=0; i<n-1; i++){
            if(stringList[i].length()>stringList[i+1].length()) lengthSorted=false;
            if(stringList[i].compareTo(stringList[i+1])>0) lexSorted=false;
        }
        if(lexSorted && lengthSorted) return "both";
        if(lexSorted) return "lexicographically";
        if(lengthSorted) return "lengths";
        return "none";
    }
}
