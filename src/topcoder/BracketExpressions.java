package topcoder;

import java.util.ArrayDeque;

/**
 * Created by chinh on 7/22/14.
 */
public class BracketExpressions {

    String brackets = "()[]{}";
    boolean isSpecial(int index, StringBuilder s){
        if(index==s.length()){
            ArrayDeque<Character> stack = new ArrayDeque<Character>();
            for(int i=0; i<index; i++){
                if(brackets.indexOf(s.charAt(i))%2==0) { //opening
                    stack.push(s.charAt(i));
                } else{
                    if(stack.isEmpty() || brackets.charAt(brackets.indexOf(s.charAt(i))-1)!=stack.pop()) return false;
                }
            }
            return stack.isEmpty();
        }
        if(s.charAt(index)=='X'){
            boolean ret = false;
            for(int i=0; i<brackets.length(); i++){
                s.setCharAt(index, brackets.charAt(i));
                if(isSpecial(index+1, s)){
                    ret=true;
                    break;
                }
            }
            s.setCharAt(index, 'X');
            return ret;
        } else{
            return isSpecial(index+1, s);
        }
    }
    public String ifPossible(String expression){
        if(expression.length()%2==1 || !isSpecial(0, new StringBuilder(expression))) return "impossible"; else return "possible";
    }
}
