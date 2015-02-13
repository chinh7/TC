package codeforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R275D1B {
    static class SegmentTree{
        int[] a;
        int[] nodes;
        public SegmentTree(int[] a){
            this.a = a;
            nodes = new int[4*a.length];
            initialize(0, 0, a.length-1);
        }
        void initialize(int nodeIndex, int l, int r){
            if(l>r) return;
            if(l==r) {
                nodes[nodeIndex] = a[l];
                return;
            }
            initialize(2*nodeIndex+1, l, (l+r)/2);
            initialize(2*nodeIndex+2, (l+r)/2+1, r);
            nodes[nodeIndex] = nodes[nodeIndex*2+1]&nodes[nodeIndex*2+2];
        }
        int query(int nodeIndex, int l, int r, int i, int j){
            if(i>r || j<l) return Integer.MAX_VALUE;
            if(i<=l && r<=j) return nodes[nodeIndex];
            int left = query(2*nodeIndex+1, l, (l+r)/2, i, j);
            int right = query(2*nodeIndex+2, (l+r)/2+1, r, i, j);
            return left&right;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] l = new int[m];
        int[] r = new int[m];
        int[] q = new int[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken())-1;
            r[i] = Integer.parseInt(st.nextToken())-1;
            q[i] = Integer.parseInt(st.nextToken());
        }

        int a[] = new int[n];
        int[] mark = new int[n+1];
        for(int pos=0; pos<32; pos++){
            Arrays.fill(mark, 0);
            for(int i=0; i<m; i++){
                if(((q[i]>>pos)&1)>0){
                    mark[l[i]]++;
                    mark[r[i]+1]--;
                }
            }
            int cur=0;
            for(int i=0; i<n; i++){
                cur+=mark[i];
                if(cur>0) a[i] |= 1<<pos;
            }
        }
        SegmentTree tree = new SegmentTree(a);
        for(int i=0; i<m; i++){
            if(tree.query(0, 0, a.length-1, l[i], r[i])!=q[i]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        for(int i=0; i<n; i++){
            if(i==n-1) System.out.println(a[i]); else System.out.print(a[i]+" ");
        }
    }

}