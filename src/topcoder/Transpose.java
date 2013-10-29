package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/26/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */

//permutation cycle
public class Transpose {
    int m,n;
    private int valueAt(int index){
        return index/m + (index%m)*n;
    }
    public int numSwaps(int M, int N){
        m = M;
        n = N;
        boolean[] checked = new boolean[m*n];
        int index = 0;
        int result = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int value = index;
                int count=0;
                while(!checked[value]){
                    count++;
                    checked[value] = true;
                    value = valueAt(value);
                }
                result+=(count>0)? count-1 : 0;
                index++;
            }
        }
        return result;
    }
}
