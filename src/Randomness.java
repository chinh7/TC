/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/2/13
 * Time: 4:14 PM
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
    public static void exec(){
//        int[] K = {4,7,9,10,15};
//        System.out.println(randomNumber(16, K));

    }
}
