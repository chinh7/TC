package topcoder;

import java.util.ArrayList;

/**
 * Created by chinh on 04/11/2014.
 */
public class NarrowPassage2Easy {
    int count=0;
    int n;
    int cutOff;
    ArrayList<Integer[]> permutations = new ArrayList<Integer[]>();
    boolean[] visited;
    void swap(int i, int j, int[] a){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    void gen(int i, int[] a){
        if(i==n){
            Integer[] tmp = new Integer[n];
            for(int j=0; j<n; j++) tmp[j] = a[j];
            permutations.add(tmp);
            return;
        }
        for(int j=i; j<n; j++){
            swap(i,j,a);
            gen(i+1, a);
            swap(i,j,a);
        }
    }
    boolean valid(int i, int j){
        Integer[] a = permutations.get(i);
        Integer[] b = permutations.get(j);
        for(int e=0; e<n-1; e++){
            if(a[e]!=b[e]){
                for(int f=e+2; f<n; f++){
                    if(a[f]!=b[f]) return false;
                }
                return (a[e]+a[e+1]<=cutOff);
            }
        }
        return a[0]+a[1]<=cutOff;
    }
    void dfs(int i){
        count++;
        visited[i] = true;
//        for(int j=0; j<n; j++) System.out.print(permutations.get(i)[j]+" ");
//        System.out.println();
        for(int j=0; j<permutations.size(); j++){
            if(!visited[j] && valid(i, j)){
                dfs(j);
            }
        }
    }
    public int count(int[] size, int maxSizeSum){
        n = size.length;
        cutOff = maxSizeSum;
        gen(0, size);
        visited = new boolean[permutations.size()];
        dfs(0);
        return count;
    }
}
