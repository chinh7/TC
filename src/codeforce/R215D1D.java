package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R215D1D {
    static int getNumber(int[] count){
        int m = count.length;
        int ret=(1<<m)-1;
        for(int i=0; i<count.length; i++){
            if(count[i]>0) ret=ret^(1<<i);
        }
        return ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] id = new int[n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int count=Integer.parseInt(st.nextToken());
            while(count-->0){
                id[Integer.parseInt(st.nextToken())-1]=i;
            }
        }
        boolean[] bad = new boolean[1<<m];
        int[] count = new int[m];
        for(int j=0; j<d; j++) count[id[j]]++;
        bad[getNumber(count)] = true;
        for(int i=1; i<n-d+1; i++){
            count[id[i-1]]--;
            count[id[i-1+d]]++;
            bad[getNumber(count)] = true;
        }
        int result = m;
        for(int i=((1<<m)-2); i>0; i--){
            int popCount=0;
            for(int j=0; j<m; j++){
                if((i&(1<<j))>0){
                    popCount++;
                    if(bad[i]) bad[i^(1<<j)]=true;
                }
            }
            if(!bad[i] && result>popCount) result=popCount;
        }
        System.out.println(result);
    }
}
