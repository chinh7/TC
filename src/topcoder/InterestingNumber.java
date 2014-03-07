package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 3/4/14
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class InterestingNumber {
    public String isInteresting(String x){
        int n = x.length();
        boolean[] visited = new boolean[n];
        for(int i=0; i<n-1; i++){
            if(!visited[i]){
                visited[i]=true;
                boolean found=false;
                for(int j=i+1; j<n; j++){
                    if(!visited[j] && x.charAt(i)==x.charAt(j) && j-i-1==Integer.parseInt(x.charAt(i)+"")){
                        found=true;
                        visited[j]=true;
                    }
                }
                if(!found) return "Not interesting";
            }
        }
        return visited[n-1] ? "Interesting" : "Not interesting";
    }
}
