package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/29/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContractWork {
    private final int INF = Integer.MAX_VALUE/2;
    public int minimumCost(String[] costs, int numTasks){
        int numCompanies = costs.length;
        int[][] map = new int[numCompanies][numTasks];
        for(int i=0; i<numCompanies; i++){
            String[] cost = costs[i].split(" ");
            assert cost.length == numTasks;
            for(int j=0; j<numTasks; j++) map[i][j] = Integer.parseInt(cost[j]);
        }
        //min[i][j] the min cost to complete up to task j with company i as the last worker
        int[][] min = new int[numCompanies][numTasks];
        for(int j=0; j<numTasks; j++){
            for(int i=0; i<numCompanies; i++){
                min[i][j] = INF;
                for(int e=0; e<numCompanies; e++){
                    if(e!=i){
                        int prevOne = j>0 ? min[e][j-1]+map[i][j] : map[i][j];
                        int prevTwo = j>1 ? min[e][j-2]+map[i][j]+map[i][j-1] : (j>0 ? map[i][j]+map[i][j-1] : map[i][j]);
                        min[i][j] = Math.min(min[i][j], prevOne);
                        min[i][j] = Math.min(min[i][j], prevTwo);
                    }
                }
            }
        }
        int result = INF;
        for(int i=0; i<numCompanies; i++){
            result = Math.min(result, min[i][numTasks-1]);
        }
        return result;
    }
}
