package usaco;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/19/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */

//TLE for large tests.
//implement bst to pass 'em all. Or have look at the O(n) sol.
public class Lineup {
    //can be reduced to logN by using a custom built binary search tree which track the size of the left and right subtrees.
    static int rangeCount(TreeMap<Integer, Integer> tree, int lower, int upper){
        return tree.subMap(lower, true, upper, true).size();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();

        int result=1;
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());
            if(map.containsKey(value)){
                ArrayList<Integer> list = map.get(value);
                list.add(i);
                //tree
                int lastSeenAt = list.get(list.size()-2);
                tree.remove(lastSeenAt);
                tree.put(i, value);

                //binary search
                int l=0, r=list.size()-2;
                while(l<r){
                    int mid = (r-l)/2+l;
                    if(rangeCount(tree, list.get(mid), i)-1<=k){
                        r=mid;
                    } else{
                        l=mid+1;
                    }
                }
                if(rangeCount(tree, list.get(l), i)-1<=k){
                    if(result<list.size()-l) result = list.size()-l;
                }
            } else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(value, list);
                tree.put(i, value);
            }
        }
        System.out.println(result);
        out.close();
    }
}
