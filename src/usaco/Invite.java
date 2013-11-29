package usaco;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/20/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Invite {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("invite.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("invite.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        HashSet<Integer>[] set = new HashSet[g];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<g; i++){
            set[i] = new HashSet<Integer>();
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(s-- > 0){
                int value = Integer.parseInt(st.nextToken());
                set[i].add(value);
                if(map.containsKey(value)){
                    ArrayList<Integer> list = map.get(value);
                    list.add(i);
                } else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    map.put(value, list);
                }
            }
        }
        ArrayDeque<Integer> added = new ArrayDeque<Integer>();
        added.add(1);
        int result = 1;
        while(!added.isEmpty()){
            int value = added.poll();
            ArrayList<Integer> list = map.get(value);
            if(list!=null){
                for(int i=0; i<list.size(); i++){
                    int setIndex = list.get(i);
                    set[setIndex].remove(value);
                    if(set[setIndex].size()==1){
                        int e = set[setIndex].toArray(new Integer[0])[0];
                        if(!added.contains(e)){
                            added.add(e);
                            result++;
                        };
                    }
                }
            }
        }
        System.out.println(result);
        out.close();
    }
}
