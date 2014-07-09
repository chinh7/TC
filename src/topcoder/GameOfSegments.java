package topcoder;

/**
 * Created by chinh on 6/12/14.
 */
public class GameOfSegments {
    public int winner(int n){
        int[] win = new int[n+1];
        int[] lose = new int[n+1];
        lose[0] = lose[1] = 1;
        for(int i=2; i<=n; i++){
            boolean mustWin=false;
            boolean mustLose=false;
            boolean both=false;
            boolean either=false;
            for(int j=0; j<=(i-2)/2; j++){
                if(win[j]+lose[j]+win[i-2-j]+lose[i-2-j]==2){
                    if(lose[j]+lose[i-2-j]==2 || win[j]+win[i-2-j]==2) mustWin=true; else mustLose=true;
                } else
                if(win[j]+lose[j]+win[i-2-j]+lose[i-2-j]==3){
                    either=true;
                } else{
                    both=true;
                }
            }
            if(both) win[i]=lose[i]=1;
            if(mustWin) win[i]=1;
            if(mustLose) lose[i]=1;
        }
        for(int i=0; i<=n; i++) System.out.println(i+" "+win[i]+" "+lose[i]);
        if(win[n]==1) return 1; else return 2;
    }
}
