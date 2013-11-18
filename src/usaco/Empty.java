package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/16/13
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */

public class Empty {
    private static TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    private static int n;
    private static Map.Entry<Integer, Integer> prev(int key){
        Map.Entry<Integer,Integer> entry = map.lowerEntry(key);
        if(entry==null) entry = map.lastEntry();
        return entry;
    }
    private static Map.Entry<Integer, Integer> next(int key){
        Map.Entry<Integer,Integer> entry = map.higherEntry(key);
        if(entry==null) entry = map.firstEntry();
        return entry;
    }
    private static boolean isInside(int key, Map.Entry<Integer, Integer> entry){
        if(entry.getValue()<entry.getKey()){
            return (entry.getKey()<=key && key<=n-1) || (0<=key && key<=entry.getValue());
        } else{
            return (entry.getKey()<=key && key<=entry.getValue());
        }
    }
    private static int end(int key, int length){
        return (key+length-1)%n;
    }
    private static int length(int start, int end){
        if(end<start){
            return n-(start-end+1);
        } else{
            return end-start+1;
        }
    }
    private static int nextAdj(int key){
        return (key+1)%n;
    }
    private static int prevAdj(int key){
        if(key>0) return key-1; else return n-1;
    }
    private static int nextAdj(Map.Entry<Integer, Integer> entry){
        return nextAdj(entry.getValue());
    }
    private static int prevAdj(Map.Entry<Integer, Integer> entry){
        return prevAdj(entry.getKey());
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("empty.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("empty.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            for(int i=1; i<=y; i++){
                int preferred = (int)(A*i+B)%n;
                if(map.isEmpty()){
                    map.put(preferred, end(preferred, x));
                    continue;
                }
                Map.Entry<Integer,Integer> prev = prev(preferred);
                int start, begin, end=0;
                ArrayList<Integer> deleted = new ArrayList<Integer>();
                if(isInside(preferred,prev)){
                    start = nextAdj(prev);
                    begin = prev.getKey();
                    deleted.add(prev.getKey());
                } else{
                    start = preferred;
                    begin = preferred;
                }
                while(x>0){
                    Map.Entry<Integer, Integer> next = next(start);
                    int available = length(start, prevAdj(next));
                    if(x>available){
                        x = x-available;
                        start=nextAdj(next);
                        deleted.add(next.getKey());
                    } else{
                        end = end(start,x);
                        if(end == prevAdj(next)){
                            end = next.getValue();
                            deleted.add(next.getKey());
                        }
                        x = 0;
                    }
                }
                for(int key : deleted) map.remove(key);
                map.put(begin, end);
            }
        }
        int result = Math.min(prevAdj(map.firstEntry()), nextAdj(map.lastEntry()));
        result = Math.min(result, nextAdj(map.firstEntry())); // when first starts at 0;
        out.println(result);
        out.close();
    }
}
