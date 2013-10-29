package topcoder.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/18/13
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */

// Lowest common ancestor
// O(N^2) to construct, O(NlogN) for each query)
// better algorithm exists: O(N) O(logN) respectively. Would be overkill for this problem though.
public class PermissionTree {
    private int n;
    private boolean[][] graph;
    private int[] parent;
    private boolean[][] children;
    private void visit(int i){
        children[i] = new boolean[n];
        children[i][i] = true;
        for(int j=0; j<n; j++){
            if(graph[i][j]){
                visit(j);
                for(int e=0; e<n; e++) children[i][e] = children[i][e] || children[j][e];
            }
        }
    }
    public int[] findHome(String[] folders, String[] users){
        HashMap<String, ArrayList<Integer>> userMap = new HashMap<String, ArrayList<Integer>>();
        n = folders.length;
        graph = new boolean[n][n];
        parent = new int[n];
        children = new boolean[n][];
        for(int i=0; i<n; i++){
            String[] parsed = folders[i].split("\\s");
            int index = Integer.parseInt(parsed[0]);
            graph[index][i] = true;
            parent[i] = index;
            String[] contained = parsed[1].split(",");
            for(String user : contained){
                ArrayList<Integer> indexList;
                if(userMap.containsKey(user)){
                    indexList = userMap.get(user);
                } else{
                    indexList = new ArrayList<Integer>();
                    userMap.put(user, indexList);
                }
                indexList.add(i);
            }
        }
        graph[0][0] = false;
        visit(0);

        int m = users.length;
        int[] result = new int[m];
        Arrays.fill(result, -1);
        for(int i=0; i<m; i++){
            if(userMap.containsKey(users[i])){
                ArrayList<Integer> indexList = userMap.get(users[i]);
                int sample = indexList.get(0);
                while(true){
                    boolean valid = true;
                    for(int j=1; j<indexList.size(); j++){
                        if(!children[sample][indexList.get(j)]){
                            valid = false;
                            break;
                        }
                    }
                    if(valid) result[i] = sample;
                    if(valid || sample==0) break;
                    sample = parent[sample];
                }
            }
        }
        return result;
    }
}
