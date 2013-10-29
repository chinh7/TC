package topcoder;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/4/13
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdealString {
    private class Node{
        //length: sum of indices from root up to the current node
        int index, length;
        public Node(int i, int l){
            index = i;
            length = l;
        }
    }
    private Stack<Node> stack = new Stack<Node>();
    private int target;
    private char[] result;
    private int[] quantity;
    private void find(Node p){
        if(p.index!=0) stack.push(p);
        Node l = new Node(p.length+1, p.length+p.length+1);
        Node r = new Node(p.index+1, p.length+p.index+1);

        if(r.length>target) return;
        if(l.length>=target && r.length<=target){
            //found the least lex path.
            result = new char[target];
            int depth = stack.size()+1;
            quantity = new int[depth];

//            System.out.println(target - p.length);
            quantity[--depth] = target - p.length;
            while(!stack.empty()){
                int index = stack.pop().index;
//                System.out.println(index);
                quantity[--depth] = index;
            }
            for(int i=0; i<quantity.length; i++){
                result[--quantity[i]] = (char) (i+'A');
            }
            int current = 0;

            for(int i=0; i<target; i++){
                if(result[i]==0){
                    while(quantity[current]==0) current++;
                    result[i]=(char) (current+'A');
                    quantity[current]--;
                }
            }
            return;
        }
        find(l);
        if(result!=null) return;
        stack.pop();
        if(r.index != l.index){
            find(r);
            if(result!=null) return;
            stack.pop();
        }
    }
    public String construct(int length){
        target = length;
        find(new Node(0,0));
        if(result==null) return ""; else return new String(result);
    }
}
