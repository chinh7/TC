package topcoder;

/**
 * Created by chinh on 03/11/2014.
 */
public class TheNumberGame {
    public String determineOutcome(int A, int B){
        String sA = A+"";
        String sB = B+"";
        if(sA.indexOf(sB)>=0) return "Manao wins"; else return "Manao loses";

    }
}
