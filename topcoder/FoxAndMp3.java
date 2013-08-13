package topcoder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/16/13
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoxAndMp3 {
    ArrayList<String> result = new ArrayList<String>();
    int maxN;
    void gen(int number){
        if(result.size() < 50){
            result.add(number + ".mp3");
            if(number*10 <= maxN) gen(number*10);
            if(number%10 + 1 <= 9 && number+1 <= maxN) gen(number+1);
        }
    }

    public String[] playList(int n){
        maxN=n;
        gen(1);
        String[] ret = new String[result.size()];
        return result.toArray(ret);
    }
}
