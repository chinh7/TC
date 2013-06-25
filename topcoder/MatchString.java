package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/25/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchString {
    public int placeWords(String matchString, String[] matchWords){
        int n = matchString.length();
        int m = 0;
        for(int i=0; i<n; i++){
            if(m<matchWords[i].length()) m = matchWords[i].length();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            int cost = 0;
            int length = 0;
            for(int j=0; j<n; j++){
                int start = Math.min(i, matchWords[j].length()-1);
                for(int e=start; e>=0; e--){
                    if(matchWords[j].charAt(e) == matchString.charAt(j)){
                        cost+=i-e;
                        length++;
                        break;
                    }
                }
            }
            if(length == n) min = Math.min(min, cost);
        }
        if(min==Integer.MAX_VALUE) return -1; else return min;
    }
}
