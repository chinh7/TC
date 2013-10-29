package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/2/13
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeGame {
    private class Data implements Comparable<Data>{
        String str;
        int value;
        public Data(String str, int value){
            this.str = str;
            this.value = value;
        }
        public int compareTo(Data o){
            return o.value - this.value;
        }
    }
    private boolean compatible(String a, String b){
        int l = a.length();
        for(int i=0; i<l; i++)
            if(a.charAt(i)!=b.charAt(l-i-1)) return false;
        return true;
    }
    public int getMaximum(String[] front, int[] back){
        int n = front.length;
        Data[] data = new Data[n];
        for(int i=0; i<n; i++){
            data[i] = new Data(front[i], back[i]);
        }
        boolean[] checked = new boolean[n];
        Arrays.sort(data);
        int result = 0;
        for(int i=0; i<n-1; i++){
            if(!checked[i]){
                checked[i] = true;
                for(int j=i+1; j<n; j++){
                    if(compatible(data[i].str, data[j].str)){
                        checked[j] = true;
                        result+=data[i].value+data[j].value;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
