package stopcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Nov3 {
    static class Pair implements Comparable<Pair>{
        int index;
        int value;
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int compareTo(Pair other){
            return this.value-other.value;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tCase=0; tCase<T; tCase++){
            System.out.println("Case #"+(tCase+1));
            int n = Integer.parseInt(br.readLine());
            Pair[] a = new Pair[n];
            int[] result = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                a[i] = new Pair(i, Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(a);
            TreeSet<Integer> set = new TreeSet<Integer>();
            set.add(-n); set.add(2*n);
            for(int i=n-1; i>=0; i--){
                int index = a[i].index;
                int ceiling = set.ceiling(index);
                int floor = set.floor(index);
                if(ceiling-index<index-floor){
                    result[index] = ceiling;
                } else{
                    result[index] = floor;
                }
                if(i>0 && a[i].value>a[i-1].value){
                    int j = i;
                    while(j<n && a[j].value==a[i].value){
                        set.add(a[j].index);
                        j++;
                    }
                }
            }
            for(int i=0; i<n; i++){
                if(i<n-1) System.out.print(result[i]+" "); else System.out.println(result[i]);
            }
        }
    }

}
