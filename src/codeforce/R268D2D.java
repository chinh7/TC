package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 18/11/2014.
 */
public class R268D2D {
    static class Data implements Comparable<Data>{
        int index, value;
        public Data(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int compareTo(Data other){
            return this.value-other.value;
        }
    }
    static int find(Data[] data, int i, int a){
        int n = data.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(data[mid].value>a-data[i].value) r=mid-1; else
            if(data[mid].value<a-data[i].value) l=mid+1; else return mid;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Data[] data = new Data[n];
        for(int i=0; i<n; i++){
            data[i] = new Data(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(data);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i=0; i<n; i++){
            if(res[data[i].index]>=0) continue;
            int u = find(data, i, a);
            int v = find(data, i, b);
            if(a!=b && u>=0 && res[data[u].index]<0 && v>=0 && res[data[v].index]<0) continue;
            int cur=-1;
            if(u>=0 && res[data[u].index]<0) cur = a;
            if(v>=0 && res[data[v].index]<0) cur = b;
            if(cur<0){
                System.out.println("NO");
                return;
            }
            ArrayList<Integer> chain = new ArrayList<Integer>();
            u = i;
            chain.add(u);
            while(true){
                v = find(data, u, cur);
                if(v!=u && v>=0 && res[data[v].index]<0) u=v; else break;
                chain.add(u);
                if(a==b) break;
                if(cur==a) cur=b; else cur=a;
            }
            for(int j=0; j<chain.size()-1; j+=2){
                if(data[chain.get(j)].value+data[chain.get(j+1)].value==a){
                    res[data[chain.get(j)].index] = 0;
                    res[data[chain.get(j+1)].index] = 0;
                } else{
                    res[data[chain.get(j)].index] = 1;
                    res[data[chain.get(j+1)].index] = 1;
                }
            }
            if(chain.size()%2==1) {
                if (data[chain.get(chain.size() - 1)].value * 2 == a) {
                    res[data[chain.get(chain.size() - 1)].index] = 0;
                } else if (data[chain.get(chain.size() - 1)].value * 2 == b) {
                    res[data[chain.get(chain.size() - 1)].index] = 1;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
        for(int i=0; i<n; i++){
            if(i==n-1) System.out.println(res[i]); else System.out.print(res[i]+" ");
        }
    }
}
