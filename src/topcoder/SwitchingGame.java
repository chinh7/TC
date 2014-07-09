package topcoder;

/**
 * Created by chinh on 6/12/14.
 */
public class SwitchingGame {
    public int timeToWin(String[] states){
        int n = states.length;
        int m = states[0].length();
        int[] cur = new int[m];
        int result=n;
        for(int i=0; i<n; i++){
            int[] next = new int[m];
            int onOff = 0;
            int offOn = 0;
            for(int j=0; j<m; j++){
                if(states[i].charAt(j)=='?'){
                    int e=i+1;
                    while(e<n && states[e].charAt(j)=='?') e++;
                    next[j]=cur[j];
                    if(e<n) next[j] = states[e].charAt(j)=='+' ? 1 : 0;
                } else{
                    next[j] = states[i].charAt(j)=='+' ? 1 : 0;
                }
                if(cur[j]>next[j]) onOff=1;
                if(cur[j]<next[j]) offOn=1;
            }
            result+=onOff+offOn;
            cur = next;
        }
        return result;
    }
}
