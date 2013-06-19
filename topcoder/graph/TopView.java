package topcoder.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/19/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TopView {

    private int n;
    private int m;
    private String[] g;
    private HashMap<Character, Vertex> map = new HashMap<Character, Vertex>();


    private class Vertex implements Comparable<Vertex>{
        char label;
        StringBuilder out = new StringBuilder("");
        StringBuilder in = new StringBuilder("");


        public Vertex(char label){
            this.label = label;
        }

        public void addOut(char c){
            if(out.indexOf(c+"") < 0){
                out.append(c);
            }
        }

        public void removeOut(char c){
            out.deleteCharAt(out.indexOf(c+""));
        }

        public void addIn(char c){
            in.append(c);
        }


        public int compareTo(Vertex o) {
            int ret = this.out.length() - o.out.length();
            if(ret == 0) ret = o.label - this.label;
            return ret;
        }
    }

    private Vertex createVertex(char cell){
        final int INF = Integer.MAX_VALUE;
        int x1=INF, y1=INF, x2=-1, y2=-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(cell==g[i].charAt(j)){
                    if(x1>i) x1=i;
                    if(y1>j) y1=j;
                    if(x2<i) x2=i;
                    if(y2<j) y2=j;
                }
            }
        }
        Vertex v = new Vertex(cell);
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(g[i].charAt(j)=='.') return null;
                if(g[i].charAt(j) != cell)
                    v.addOut(g[i].charAt(j));
            }
        }
        return v;
    }

    public String findOrder(String[] grid){
        g = grid;
        n = grid.length;
        if(n==0) return "";
        m = grid[0].length();
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char cell = grid[i].charAt(j);
                if(grid[i].charAt(j)!='.' && !map.containsKey(cell)){
                    Vertex v = createVertex(cell);
                    if(v==null) return "ERROR!";
                    vertices.add(v);
                    map.put(cell, v);
                }
            }
        }

        for(Vertex v : vertices){
            for(int i=0; i<v.out.length(); i++){
                char out = v.out.charAt(i);
                Vertex u = map.get(out);
                u.addIn(v.label);
            }
        }

        StringBuilder result = new StringBuilder("");
        while(vertices.size()>0){
            Collections.sort(vertices);

            int to = -1;
            for(int i=vertices.size()-1; i>=0; i--){
                if(vertices.get(i).out.length() == 0){
                    to = i;
                    break;
                }
            }

            if(to<0) return "ERROR!";


            for(int i=0; i<=to; i++){
                Vertex v = vertices.get(i);
                for(int j=0; j<v.in.length(); j++){
                    char in = v.in.charAt(j);
                    Vertex u = map.get(in);
                    u.removeOut(v.label);
                }
                result.insert(0, v.label);
            }

            for(int i=0; i<=to; i++) vertices.remove(0);
        }
        return result.toString();
    }
}
