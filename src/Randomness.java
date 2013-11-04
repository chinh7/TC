import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
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
    static long delish(long[] values){
        long[] maxInfo = maxSum(values, 0, values.length-1, 1);
        long[] minInfo = maxSum(values, 0, values.length-1, -1);
        if(maxInfo[2]<minInfo[1] || maxInfo[1]>minInfo[2]){
            return maxInfo[0]-minInfo[0];
        }
        long best = Long.MIN_VALUE;
        if(minInfo[1]-1>=0){
            long[] leftMaxInfo =  maxSum(values, 0, (int)minInfo[1]-1, 1);
            best = Math.max(best, leftMaxInfo[0] - minInfo[0]);
        } else{
            best = Math.max(best, 2*values[0]-minInfo[0]);
        }
        if(minInfo[2]+1<values.length){
            long[] rightMaxInfo =  maxSum(values, (int)minInfo[2]+1, values.length-1, 1);
            best = Math.max(best, rightMaxInfo[0] - minInfo[0]);
        } else{
            best = Math.max(best, 2*values[values.length-1]-minInfo[0]);
        }
        if(maxInfo[1]-1>=0){
            long[] leftMinInfo =  maxSum(values, 0, (int)maxInfo[1]-1, -1);
            best = Math.max(best, maxInfo[0] - leftMinInfo[0]);
        } else{
            best = Math.max(best, maxInfo[0] - 2*values[0]);
        }
        if(maxInfo[2]+1<values.length){
            long[] rightMinInfo =  maxSum(values, (int)maxInfo[2]+1, values.length-1, -1);
            best = Math.max(best, maxInfo[0] - rightMinInfo[0]);
        } else{
            best = Math.max(best, maxInfo[0] - 2*values[values.length-1]);
        }
        return best;
    }
    static void invert(long[] values){
        for(int i=0; i<values.length/2; i++){
            long tmp = values[i];
            values[i] = values[values.length-1-i];
            values[values.length-i-1] = tmp;
        }
    }
    static void findMax(long[] values, long[] best, int inverted){
        int start = 0, end = values.length-1;
        int lBest = start, rBest = start;
        int l = start, r = start;
        long currentSum = values[start], max = values[start];
        best[start] = currentSum;
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
            best[i] = currentSum;
        }
    }
    static long delish2(long[] values){
        int n = values.length;
        long[] leftMax = new long[n];
        long[] leftMin = new long[n];
        long[] rightMax = new long[n];
        long[] rightMin = new long[n];
        findMax(values, leftMax, 1);
        findMax(values, leftMin, -1);
        invert(values);
        findMax(values, rightMax, 1);
        findMax(values, rightMin, -1);
        invert(rightMax); invert(rightMin);
        long result = Long.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            result = Math.max(result,Math.abs(leftMax[i]-rightMin[i+1]));
            result = Math.max(result,Math.abs(rightMax[i+1]-leftMin[i]));
        }
        return result;
    }
    public static void exec(){
//        int[] a = {33, 34, 10019, 10020, 3, 35, 10021, 10022, 5, 10023, 4, 10024, 6, 7, 10025, 8};
//        System.out.println(longestInterval(a));
        try{
            BufferedReader br = new BufferedReader(new FileReader("delish.input"));
            int T = Integer.parseInt(br.readLine());
            while(T-- > 0){
                int N = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                long[] values = new long[N];
                for(int i=0; i<N; i++){
                    values[i] = Long.parseLong(st.nextToken());
                }
                System.out.println(delish2(values));
            }
        }catch (Exception e){

        }

    }
}
