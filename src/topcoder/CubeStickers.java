package topcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chinh on 06/11/2014.
 */
public class CubeStickers {
    public String isPossible(String[] sticker){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : sticker){
            if(!map.containsKey(s)) map.put(s, 0);
            map.put(s, map.get(s)+1);
        }
        int total = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            total += Math.min(2, entry.getValue());
        }
        if(total>=6) return "YES"; else return "NO";
    }
}
