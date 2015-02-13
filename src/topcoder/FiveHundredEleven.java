package topcoder;

/**
 * Created by chinh on 27/11/2014.
 */

//incorrect
public class FiveHundredEleven {
    public String theWinner(int[] cards){
        int max = 1<<9;
        boolean[][] existing = new boolean[max][2];
        boolean[][] reachable = new boolean[max][2];
        existing[0][0] = reachable[0][0] = true;
        for(int card : cards){
            boolean[][] tmpE = new boolean[max][2];
            boolean[][] tmpR = new boolean[max][2];
            for(int i=0; i<max; i++){
                tmpE[i][0] = existing[i][0];
                tmpE[i][1] = existing[i][1];
            }
            for(int i=0; i<max; i++){
                tmpE[card|i][0] |= existing[i][1];
                tmpE[card|i][1] |= existing[i][0];
                if(existing[i][1])
                    tmpR[card|i][0] |= !reachable[i][1];
                if(existing[i][0])
                    tmpR[card|i][1] |= !reachable[i][0];
            }
            existing = tmpE;
            reachable = tmpR;
        }
        System.out.println(reachable[7][0]);
        if(!existing[max-1][0] && !existing[max-1][1]){
            if(cards.length%2==1) return "Fox Ciel"; else return "Toastman";
        }
        if(reachable[max-1][0]) return "Fox Ciel"; else return "Toastman";
    }
}
