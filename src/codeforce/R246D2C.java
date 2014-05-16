package codeforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 5/16/14.
 */
public class R246D2C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bound = n+2;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i=3; i<bound; i+=2){
            boolean isPrime = true;
            for(int j=0; j<primes.size(); j++){
                int prime = primes.get(j);
                if(prime*prime>i) break;
                if(i%prime==0) isPrime=false;
            }
            if(isPrime) primes.add(i);
        }
        int[] breakdown = new int[bound];
        Arrays.fill(breakdown, 3);
        for(int i=0; i<primes.size(); i++){
            for(int j=i; j<primes.size(); j++){
                if(primes.get(i)+primes.get(j)<bound) breakdown[primes.get(i)+primes.get(j)]=primes.get(j);
            }
        }
        for(int prime : primes){
            if(prime<bound) breakdown[prime]=prime;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a= new int[n];
        int[] pos = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken())-1;
            pos[a[i]] = i;
        }
        ArrayList<Integer> resultI = new ArrayList<Integer>();
        ArrayList<Integer> resultJ = new ArrayList<Integer>();
        for(int i=0; i<n-1; i++){
            if(pos[i]==i) continue;
            int l = pos[i]-i+1;
            if(breakdown[l]==l){

            } else if(l%2==1){
                l++;
            } else{
                int u = pos[i];
                int v = u-1;
                int tmp = a[u];
                a[u] = a[v];
                a[v] = tmp;
                tmp = pos[a[u]];
                pos[a[u]]=pos[a[v]];
                pos[a[v]]=tmp;
                resultI.add(u+1);
                resultJ.add(v+1);
            }
            while(l!=0){
                int u = pos[i];
                int v = u-breakdown[l]+1;
                int tmp = a[u];
                a[u] = a[v];
                a[v] = tmp;
                tmp = pos[a[u]];
                pos[a[u]]=pos[a[v]];
                pos[a[v]]=tmp;
                l-=breakdown[l];
                resultI.add(u+1);
                resultJ.add(v+1);
            }
        }
        System.out.println(resultI.size());
        for(int i=0; i<resultI.size(); i++){
            System.out.println(resultJ.get(i)+" "+resultI.get(i));
        }

    }

}
