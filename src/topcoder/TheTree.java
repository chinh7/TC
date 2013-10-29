package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 10/29/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheTree {
    public int maximumDiameter(int[] cnt){
        //'current nodes': active, attachable nodes.
        int father = 0, //max distance between from one of the current nodes
            pair = 0; //distance between a pair of current nodes
        for(int count : cnt){
            if(count>1){
                pair+=2;
                father++;
            } else{
                //if there is only one node to attach, we need to reset 'pair'
                father=Math.max(father, pair)+1;
                pair=0;
            }
        }
        return Math.max(father, pair);
    }
}
