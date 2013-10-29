package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/23/13
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class BagsQuiz {
    public int checkIfProper(int n, String[] actions){
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(String action : actions){
            String[] splits = action.split(" ");
            if(splits[0].equals("PUT")){
                int i = Integer.parseInt(splits[1])-1;
                int j = Integer.parseInt(splits[3])-1;
                if(parent[i] >= 0 || parent[j] >= 0) return -1;
                parent[i] = j;
            } else
            if(splits[0].equals("SET")){
                int i = Integer.parseInt(splits[1])-1;
                if(parent[i] >= 0) return -1;
                for(int e=0; e<n; e++){
                    if(parent[e] == i) parent[e] = -1;
                }
            } else{
                int i = Integer.parseInt(splits[1])-1;
                int j = Integer.parseInt(splits[3])-1;
                if(parent[i] >= 0 || parent[j] >= 0) return -1;

                int[] clone = Arrays.copyOf(parent, n);

                for(int e=0; e<n; e++){
                    if(clone[e]==i) parent[e] = j;
                }
                for(int e=0; e<n; e++){
                    if(clone[e]==j) parent[e] = i;
                }
            }
        }
        int result=0;
        for(int e=0; e<n; e++){
            if(parent[e] == -1) result++; else
            if(parent[e]<e) return -1;
        }
        return result;
    }
}
