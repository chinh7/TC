package topcoder.graph;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 10/31/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeColorabilityEasy {
    public String isColorable(String[] cells){
        int m = cells.length;
        int n = cells[0].length();

        int[][] colored = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(cells[i].charAt(j)=='N'){
                    if(colored[i][j]==0){
                        //first one
                        colored[i][j] = 1;
                        colored[i+1][j+1] = 2;
                        colored[i+1][j] = colored[i][j+1] = 3;
                    } else{
                        if(colored[i+1][j]!=colored[i][j+1]){
                            if(colored[i+1][j]*colored[i][j+1]!=0) return "No";
                            int tmp = colored[i+1][j]+colored[i][j+1];
                            colored[i+1][j] = colored[i][j+1] = tmp;
                        }
                        colored[i+1][j+1] = 6 - colored[i][j] - colored[i+1][j];
                    }
                } else{
                    if(colored[i][j]==0){
                        //first one
                        colored[i][j] = colored[i+1][j+1] = 1;
                        colored[i+1][j] = 2;
                        colored[i][j+1] = 3;
                    } else{
                        colored[i+1][j+1] = colored[i][j];
                        if(colored[i+1][j] == 0){
                            colored[i+1][j] = 6 - colored[i][j+1] - colored[i][j];
                        } else
                        if(colored[i][j+1] == 0){
                            colored[i][j+1] = 6 - colored[i+1][j] - colored[i][j];
                        } else
                        if(colored[i][j+1]==colored[i+1][j]){
                            return "No";
                        }
                    }
                }
            }
        }
        return "Yes";
    }
}
