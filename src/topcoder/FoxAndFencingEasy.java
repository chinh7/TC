package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/29/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class FoxAndFencingEasy {
    public String WhoCanWin(int mov1, int mov2, int d){
        if(mov1>=d || mov1>2*mov2) return "Ciel";
        if(mov2>2*mov1) return "Liss";
        return "Draw";
    }
}
