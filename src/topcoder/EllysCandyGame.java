package topcoder;

/**
 * Created by chinh on 4/1/14.
 */
public class EllysCandyGame {
    class Score{
        int first, second;
        public Score(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    Score getScores(int[] sweets){
        Score optimal = null;
        for(int i=0; i<sweets.length; i++){
            if(sweets[i]!=0){
                int[] newSweets = new int[sweets.length];
                for(int j=0; j<sweets.length; j++){
                    if(Math.abs(i-j)==1) newSweets[j] = sweets[j]*2; else newSweets[j] = sweets[j];
                }
                newSweets[i]=0;
                Score score = getScores(newSweets);
                int tmp = score.first;
                score.first = score.second+sweets[i];
                score.second = tmp;
                if(optimal == null || optimal.first-optimal.second<score.first-score.second) optimal = score;
            }
        }
        if(optimal==null) return new Score(0,0); else return optimal;
    }
    public String getWinner(int[] sweets){
        Score score = getScores(sweets);
        if(score.first>score.second) return "Elly";
        else if(score.first<score.second) return "Kris";
        else return "Draw";
    }
}
