package topcoder;

/**
 * Created by chinh on 4/25/14.
 */
import java.util.Arrays;
public class MovingRooksDiv2 {
    static boolean[] visited = new boolean[76543211];
    static boolean[] found = new boolean[76543211];
    int value(int[] Y1){
        int result=0;
        for(int i=0; i<Y1.length; i++) result=result*10+Y1[i];
        return result;
    }
    boolean find(int[] Y1, int[] Y2){
        visited[value(Y1)] = true;
        int n=Y1.length;
        boolean found=true;
        for(int i=0; i<n; i++){
            if(Y1[i]!=Y2[i]) found=false;
        }

        if(found) return true;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(Y1[i]>Y1[j]){
                    int[] clone = Arrays.copyOf(Y1, n);
                    int tmp = clone[i];
                    clone[i]=clone[j];
                    clone[j]=tmp;
                    if(!visited[value(clone)]) found |= find(clone, Y2);
                }
            }
        }
        return found;
    }
    public String move(int[] Y1, int[] Y2){
        if(find(Y1, Y2)) return "Possible"; else return "Impossible";
    }
}