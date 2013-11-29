package topcoder;

import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/23/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */

//partially-scored
public class PackingSquares {
    public long leastArea(int[] a){
        int n = a.length;
        boolean[] discard = new boolean[n];
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        while(true){
            boolean found = false;
            int i,j;
            if(stack.isEmpty()) i=-1; else i = stack.peek();
            for(j=i+1; j<n; j++){
                if(!discard[j] && (i==-1 || a[j]>=a[i])){
                    found = true;
                    break;
                }
            }
            if(!found) break;

            if(i==-1 || a[j]>a[i]){
                i = j;
                stack.push(i);
            } else{
                discard[stack.pop()] = true;
            }
        }
        long result = 0;
        while(!stack.isEmpty()){
            long side = 1<<a[stack.pop()];
            result += side*side;
        }
        return result;
    }
}
