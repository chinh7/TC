package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/19/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class ColorfulCupcakesDivTwo {
    private final int CAP = 1000000007;
    public int countArrangements(String cupcakes){
        int[] color = new int[3];
        int n = cupcakes.length();
        for(int i=0; i<cupcakes.length(); i++){
            int c = cupcakes.charAt(i) - 'A';
            color[c]++;
        }

        int result = 0;
        for(int first=0; first<3; first++){
            int[][][][] min = new int[n][color[0]+1][color[1]+1][3];
            if(color[first]>0){
                if(first==0) min[0][1][0][first] = 1;
                if(first==1) min[0][0][1][first] = 1;
                if(first==2) min[0][0][0][first] = 1;
            }
            int[] start = new int[3];
            start[first]=1;
            for(int i=1; i<n; i++){
                for(int a=start[0]; a<=color[0]; a++){
                    for(int b=start[1]; b<=color[1]; b++){
                        int c=i+1-a-b;
                        if(c>color[2] || c<start[2]) continue;
                        for(int current=0; current<3; current++){
                            int[] used = new int[3];
                            used[current]=1;
                            for(int last=0; last<3; last++)
                                if((i!=n-1 || current!=first) && current!=last && a>=used[0] && b>=used[1] && c>=used[2]){
                                    min[i][a][b][current] += min[i-1][a-used[0]][b-used[1]][last];
                                    min[i][a][b][current] %= CAP;
//                                    System.out.println(first+" "+i+" "+a+" "+b+" "+c+" "+last);
                                }
                        }
                    }
                }
            }
            for(int i=0; i<3; i++){
                result+=min[n-1][color[0]][color[1]][i];
                result%=CAP;
            }
        }
        return result;
    }
}
