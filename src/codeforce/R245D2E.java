package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/11/14.
 */
public class R245D2E {
    static int n;
    static int[] c;
    static boolean hasNext(int[] cof, int[] a){
        int i=0;
        while(i<=n && cof[i]==a[i]) i++;
        if(i>n) return false;
        cof[i]++;
        while(i>0) cof[--i]=0;
        return true;
    }
    static boolean ok(int[] a, int index){
        if(index>=n){
            for(int i=1; i<n; i++){
                if(a[i]!=0) return false;
            }
            return (a[n]==1);
        }
        if(c[index]==1){
            a[1]++;
            return ok(a, index+1);
        }
        int[] cof = new int[n+1];
        while(hasNext(cof, a)){
            int nodeCount = 0;
            int totalPop = 0;
            for(int i=1; i<=n; i++){
                nodeCount+=i*cof[i];
                totalPop+=cof[i];
            }
            if(totalPop<2) continue;
            if(nodeCount+1==c[index]) {
                int[] next = a.clone();
                for (int j = 1; j <= n; j++) next[j] -= cof[j];
                next[c[index]]++;
                if (ok(next, index + 1)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c);
        int[] a = new int[n+1];
        if(ok(a, 0)) System.out.println("YES"); else System.out.println("NO");
    }

}

