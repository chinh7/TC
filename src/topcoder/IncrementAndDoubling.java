package topcoder;
/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/22/13
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class IncrementAndDoubling {
    public int getMin(int[] desiredArray){
        int result = 0;
        while(true){
            boolean done = true;
            for(int i=0; i<desiredArray.length; i++){
                if(desiredArray[i]%2==1) result++;
                if(desiredArray[i]>1) done=false;
                desiredArray[i] /= 2;
            }
            if(done) break;
            result++;
        }
        return result;
    }
}
