package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chinh on 6/13/14.
 */
public class ZeptoA {
    static class Sweet implements Comparable<Sweet>{
        int height; int mass;
        public Sweet(int height, int mass){
            this.height = height;
            this.mass = mass;
        }
        public int compareTo(Sweet other){
            return other.mass-this.mass;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Sweet>[] a = new ArrayList[2];
        a[0] = new ArrayList<Sweet>();
        a[1] = new ArrayList<Sweet>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            a[type].add(new Sweet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i=0; i<2; i++){
            Collections.sort(a[i], new Comparator<Sweet>() {
                @Override
                public int compare(Sweet o1, Sweet o2) {
                    return o1.height-o2.height;
                }
            });
        }
        int result=0;
        for(int i=0; i<2; i++){
            int jump=x;
            PriorityQueue<Sweet>[] queues = new PriorityQueue[2];
            queues[0] = new PriorityQueue<Sweet>();
            queues[1] = new PriorityQueue<Sweet>();
            int[] index = new int[2];
            int j=i;
            while(true){
                while(index[j]<a[j].size() && jump>=a[j].get(index[j]).height){
                    queues[j].add(a[j].get(index[j]));
                    index[j]++;
                }
                if(queues[j].isEmpty()) break;
                jump+=queues[j].poll().mass;
                j=1-j;
            }
            if(index[i]>index[1-i])
                result=Math.max(result, index[1-i]*2+1);
            else
                result=Math.max(result, index[i]*2);
        }
        System.out.println(result);
    }
}
