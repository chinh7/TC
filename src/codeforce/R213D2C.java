package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/28/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */

public class R213D2C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int n = s.length();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++){
                sum+=s.charAt(j)-'0';
                int count = 0;
                if(map.containsKey(sum)){
                    count = map.get(sum);
                }
                map.put(sum, count+1);
            }
        }
        long result=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey()!=0){
                int otherKey = a/entry.getKey();
                if(otherKey*entry.getKey()==a && map.containsKey(otherKey)){
                    result += ((long)entry.getValue())*map.get(otherKey);
                }
            } else
            if(a==0){
                result+= ((long)entry.getValue())*n*(n+1)/2;
            }
        }
        System.out.println(result);
    }

}
