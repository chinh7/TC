package spoj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/11/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class EZDIJKST {
    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[k*2];
            int[] d = new int[k*2];
            int[] next = new int[n+1];


            int[] x = new int[k];
            int[] y = new int[k];
            int[] w = new int[k];

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken()) - 1;
                y[i] = Integer.parseInt(st.nextToken()) - 1;
                w[i] = Integer.parseInt(st.nextToken());
                next[x[i]]++;
                next[y[i]]++;
            }

            for(int i=1; i<=n; i++) next[i]+=next[i-1];
            for(int i=0; i<k; i++){
                a[--next[x[i]]] = y[i];
                a[--next[y[i]]] = x[i];
                d[next[x[i]]] = w[i];
                d[next[y[i]]] = w[i];
            }

//            for(int i=0; i<n; i++){
//                System.out.println(i+1+":");
//                for(int j=next[i]; j<next[i+1]; j++){
//                    System.out.print((a[j]+1)+" ");
//                }
//                System.out.println();
//            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int[] b = new int[n];

            for(int i=0; i<n; i++) b[i] = Integer.MAX_VALUE/2;
            b[s] = 0;

            boolean[] relaxed = new boolean[n];

            while(true){
                int min = Integer.MAX_VALUE/2;
                int target = -1;
                for(int i=0; i<n; i++){
                    if(!relaxed[i] && min>b[i]){
                        min = b[i];
                        target = i;
                    }
                }
                if(target<0) break;
                relaxed[target] = true;
                for(int i=next[target]; i<next[target+1]; i++){
                    if(b[a[i]]>b[target]+d[i]){
                        b[a[i]] = b[target] + d[i];
                    }
                }
            }
            if(b[e]!=Integer.MAX_VALUE/2) System.out.println(b[e]); else System.out.println("NO");
        }

    }

}
