import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/3/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Randomness {
    static void quicksort(int[] array, int left, int right){
        if(left>=right) return;
        int pivot = array[left+ (int)Math.random()*(right-left+1)];
        int l = left, r = right;
        while(l<=r){
            while(array[l]<pivot) l++;
            while(array[r]>pivot) r--;
            if(l<=r){
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
                l++; r--;
            }
        };
        quicksort(array, left, r);
        quicksort(array, l, right);
    }
    /**
     * @param N
     * @param K: sorted
     * @return random number between [0,N) not in K
     * probability of generated number should be 1/(N-K.length) and not 1/N
     */
    static int randomNumber(int N, int[] K){
        int n = N-K.length;
        int target = (int)(Math.random()*n);
        int l=0, r=K.length-1;
        while(l<r){
            int mid = (r-l+1)/2+l;
            if(K[mid]-mid-1<target){
                l = mid;
            } else{
                r = mid - 1;
            }
        }
        if(K[l]-l-1<target) return target+l+1;
        else return target;
    }
    
    static int longestInterval(int[] array){
        HashMap<Integer, Integer> end = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> begin = new HashMap<Integer, Integer>();
        int result = 0;
        for(int value : array){
            if(begin.containsKey(value)) continue;
            begin.put(value, 1);
            end.put(value, 1);
            if(begin.containsKey(value+1)){
                int forward = begin.get(value+1);
                begin.put(value, begin.get(value)+forward);
                end.put(value+forward, end.get(value+forward)+1);
                if(result<begin.get(value)){
                    result = begin.get(value);
                    System.out.println(value);
                }
            }
            if(end.containsKey(value-1)){
                int backward = end.get(value-1);
                int forward = begin.get(value);
                begin.put(value-backward, begin.get(value-backward)+forward);
                end.put(value+forward-1, end.get(value+forward-1)+backward);
                if(result<begin.get(value-backward)){
                    result = begin.get(value-backward);
                    System.out.println(value-backward);
                }
            }
        }
        return result;
    }
    static long[] maxSum(long[] values, int start, int end, int inverted){
        int lBest = start, rBest = start;
        int l = start, r = start;
        long currentSum = values[start], max = values[start];
        for(int i = start+1; i<=end; i++){
            long value = values[i];
            if(currentSum*inverted >= 0){
                currentSum += values[i];
                r = i;
            } else{
                l = r = i;
                currentSum = values[i];
            }
            if(currentSum*inverted > max*inverted){
                max = currentSum;
                lBest = l;
                rBest = r;
            }
        }
        long[] result = {max, lBest, rBest};
        return result;
    }

    static final int MAXN = 20;
    static Integer[] RA, SA, LCP, FC, SC;
    static int step, n;

    static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (step==-1 || FC[a]!=FC[b]) return FC[a] - FC[b];
            if(a+(1<<step)>=n || b+(1<<step)>=n) System.out.println("overflow");
            return FC[a+(1<<step)] - FC[b+(1<<step)];
        }

    }
    static void suffixArray(String s){
        RA = new Integer[MAXN];
        SA = new Integer[MAXN];
        LCP = new Integer[MAXN];

        n = s.length();
        for(int i=0; i<n; i++) RA[i] = Integer.valueOf(s.charAt(i));
        for(int i=0; i<n; i++) SA[i] = i;

        CustomComparator comparator = new CustomComparator();
        for(FC=RA, SC=LCP, step=-1; (1<<step)<n; step++){
            Arrays.sort(SA, 0, n, comparator);
            int cnt=0;
            SC = new Integer[MAXN];
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
            int k = SC[i];
            if(k==0) continue;
            int j = SA[k-1];
            while(s.charAt(i+l) == s.charAt(j+l)) l++;
            LCP[k] = l;
            if(l>0) l--;
        }
        l = 0;
    }

    public static void exec(){
//        int[] a = {33, 34, 10019, 10020, 3, 35, 10021, 10022, 5, 10023, 4, 10024, 6, 7, 10025, 8};
//        System.out.println(longestInterval(a));

        suffixArray("bobocel");
    }
}
