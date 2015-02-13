import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/3/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Randomness {
    static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    static int partition(int[] array, int left, int right){
        int pivotIndex = left+ (int)Math.random()*(right-left+1);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int ret = left;
        for(int i=left; i<right; i++){
            if(array[i]<=pivot){
                swap(array, i, ret);
                ret++;
            }
        }
        swap(array, ret, right);
        return ret;
    }
    static int select(int[] array, int left, int right, int k){
        if(k>right-left+1) return Integer.MIN_VALUE;
        if(left==right) return array[left];
        int pivotIndex = partition(array, left, right);
        int pivotDist = pivotIndex-left;
        if(pivotDist==k-1) return array[pivotIndex];
        if(pivotDist>k-1) return select(array, left, pivotIndex-1, k);
        else return select(array, pivotIndex+1, right, k-1-pivotDist);
    }
    static void qs(int[] array, int left, int right){
        if(left>=right) return;
        int pivotIndex = partition(array, left, right);
        qs(array, left, pivotIndex-1);
        qs(array, pivotIndex+1, right);
    }

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

    static boolean isSubString(String x, String s){
        for(int i=0; i<s.length()-x.length()+1; i++){
            boolean matched = true;
            for(int j=0; j<x.length(); j++){
                if(x.charAt(j)!=s.charAt(j+i)){
                    matched = false;
                    break;
                }
            }
            if(matched) return true;
        }
        return false;
    }

    static void merge(int[] a, int left, int mid, int right){
        int[] tmp = new int[right-left+1];
        int lc = left, rc = mid+1;
        for(int i=0; i<right-left+1; i++){
            if(rc>right || (lc<=mid && a[lc]<=a[rc])){
                tmp[i] = a[lc];
                lc++;
            } else{
                tmp[i] = a[rc];
                rc++;
            }
        }
        for(int i=left; i<=right; i++){
            a[i] = tmp[i-left];
        }
    }
    static void mergeSort(int[] a, int left, int right){
        if(left>=right) return;
        int mid = (left+right)/2;
        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);
        merge(a, left, mid, right);
    }

    //add without using +
    static int add(int a, int b){
        int carry = 0;
        int result = 0;
        int i;
        for(i=0; a>0||b>0; i++){
            int ba = a&1;
            int bb = b&1;
            result = result|((carry^ba^bb)<<i);
            carry = (ba&bb) | (bb&carry) | (carry&ba);
            a = a>>1;
            b = b>>1;
        }
        return result|(carry<<i);
    }

    public static void main(String[] args){
//        int[] a = {33, 34, 10019, 10020, 3, 35, 10021, 10022, 5, 10023, 4, 10024, 6, 7, 10025, 8};
//        System.out.println(longestInterval(a));
//        SuffixArrayFactory saf = new SuffixArrayFactory("abab");
//        Integer[] sa = saf.getSuffixArray();
//        Integer[] lcp = saf.getLCP();
//        int result = 0;
//        int n = sa.length;
//        result = n-sa[0];
//        for(int i=1; i<n; i++){
//            result+=n-sa[i]-lcp[i];
//        }
//        System.out.println(result);

//        int[] a = {33, 34, 10019, 10020, 3, 35, 10021, 10022, 5, 10023, 4, 10024, 6, 7, 10025, 8};
//        mergeSort(a, 0, a.length-1);
//        for(int i=0; i<a.length; i++) System.out.println(a[i]);

        int[] a = {5,1,7,5,0,1,2,3,2};
//        int pos = 0;
//        for(int i=0; i<a.length; i++){
//            boolean valid = true;
//            for(int j=i-1; j>=0; j--){
//                if(a[i]==a[j]) valid=false;
//            }
//            if(valid) a[pos++]=a[i];
//        }
//        for(int i=0; i<pos; i++) System.out.print(a[i]+" ");

//        for(int i=0; i<slot; i++) System.out.print(a[i]+ " ");
//        System.out.println();
//        int pos = 0;
//        for(int i=0; i<a.length; i++){
//            boolean valid = true;
//            for(int j=i-1; j>=0; j--){
//                if(a[i]==a[j]) valid=false;
//            }
//            if(valid) a[pos++]=a[i];
//        }
//        for(int i=0; i<pos; i++) System.out.print(a[i]+" ");
//        int[] a = {2,3,3};
//        qs(a, 0, a.length-1);
//        System.out.println(select(a, 0, a.length-1, 3));

        int n = 4;
        ArrayList<StringBuilder>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) list[i] = new ArrayList<StringBuilder>();
        list[0].add(new StringBuilder(""));


        StringBuilder open = new StringBuilder("(");
        StringBuilder close = new StringBuilder(")");

        for(int l=1; l<=n; l++){
            for(int j=0; j<l; j++){
                int i = l-j-1;
                for(StringBuilder si : list[i]){
                    for(StringBuilder sj : list[j]){
                        StringBuilder sb = new StringBuilder();
                        sb.append(open);
                        sb.append(si);
                        sb.append(close);
                        sb.append(sj);
                        list[l].add(sb);
                    }
                }
            }
        }
        for(int i=0; i<list[n].size(); i++) System.out.println(list[n].get(i));
    }
}
