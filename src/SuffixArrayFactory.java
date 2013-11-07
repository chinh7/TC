import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/6/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SuffixArrayFactory {
    private Integer[] SA, LCP, FC;
    private int step, n;

    public SuffixArrayFactory(){}
    public SuffixArrayFactory(String s){
        process(s);
    }

    public Integer[] getSuffixArray(){
        return Arrays.copyOf(SA, SA.length);
    }


    public Integer[] getLCP(){
        return Arrays.copyOf(LCP, LCP.length);
    }

    public void process(String s){
        n = s.length();

        Integer[] RA = new Integer[n]; //SA inversed
        SA = new Integer[n]; //Suffix Array
        LCP = new Integer[n];

        FC = new Integer[n]; //for comparison

        for(int i=0; i<n; i++) FC[i] = Integer.valueOf(s.charAt(i));
        for(int i=0; i<n; i++) SA[i] = i;

        CustomComparator comparator = new CustomComparator();
        for(step=-1; (1<<step)<n; step++){
            Arrays.sort(SA, 0, n, comparator);
            int cnt=0;
            Integer[] SC = new Integer[n];
            for (int i=0; i<n; i++) {
                if (i>0 && comparator.compare(SA[i-1],SA[i])<0) cnt++;
                SC[SA[i]] = cnt;
            }
            if (cnt==n-1) break;
            FC = SC;
        }
        for (int i=0; i<n; i++) RA[SA[i]] = i;

        int l = 0;
        for(int i=0; i<n; i++){
            int k = RA[i];
            if(k==0) continue;
            int j = SA[k-1];
            while(i+l<n && j+l<n && s.charAt(i+l) == s.charAt(j+l)) l++;
            LCP[k] = l;
            if(l>0) l--;
        }
    }

    private class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (step==-1 || FC[a]!=FC[b]) return FC[a] - FC[b];
            if(a+(1<<step)>=n){
                return -1;
            }
            if(b+(1<<step)>=n){
                return 1;
            }
            return FC[a+(1<<step)] - FC[b+(1<<step)];
        }
    }


}
