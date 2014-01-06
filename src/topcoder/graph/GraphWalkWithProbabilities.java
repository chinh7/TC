package topcoder.graph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 1/7/14
 * Time: 1:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class GraphWalkWithProbabilities {
    public double findprob(String[] graph, int[] winprob, int[] looseprob, int Start){
        int n = graph.length;
        double best[] = new double[n];
        boolean[] visited = new boolean[n];
        double result = winprob[Start]/(double)(winprob[Start]+looseprob[Start]);
        Arrays.fill(best, -1);
        best[Start] = 0;
        while(true){
            double max=-1;
            int i=-1;
            for(int j=0; j<n; j++){
                if(!visited[j] && max<best[j]){
                    max=best[j];
                    i=j;
                }
            }
            if(i<0) break;
            visited[i] = true;
            double contProb = (100-winprob[i]-looseprob[i])/(double)100;
            if(i==Start) contProb=1;
            for(int j=0; j<n; j++){
                if(j!=i && graph[i].charAt(j)=='1'){
                    if(best[j]<best[i]+contProb*winprob[j]/100){
                        best[j]=best[i]+contProb*winprob[j]/100;
                        if(result<best[i]+contProb*winprob[j]/(winprob[j]+looseprob[j])){
                            result = best[i]+contProb*winprob[j]/(winprob[j]+looseprob[j]);
                        }
                    }
                }
            }
        }
        return result;
    }
}
