package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/16/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class IngredientProportions {
    private int[][] graph;
    private Ratio[] values;
    private int n;
    private class Ratio{
        long x, y;
        public Ratio(long xx, long yy){
            x = xx; y = yy;
        }
        public Ratio multiply(long xx, long yy){
            long gcd = gcd(x*xx, y*yy);
            return new Ratio(x*xx/gcd, y*yy/gcd);
        }
    }
    private void visit(int u){
        for(int v=0; v<n; v++){
            if(graph[u][v]!=0 && values[v]==null){
                values[v] = values[u].multiply(graph[v][u], graph[u][v]);
                visit(v);
            }
        }
    }

    long gcd(long n, long m) {
        return m > 0 ? gcd(m, n % m) : n;
    }

    long lcd(long n, long m) {
        return n / gcd(n, m) * m;
    }

    public int[] getMasses(String[] proportions){
        n = proportions.length+1;
        graph = new int[n][n];
        values = new Ratio[n];
        for(String p : proportions){
            String[] params = p.split("#|\\sand\\s|\\sas\\s|:");
            int u = Integer.parseInt(params[1]);
            int v = Integer.parseInt(params[3]);
            int r = Integer.parseInt(params[4]);
            int t = Integer.parseInt(params[5]);
            graph[u][v] = r;
            graph[v][u] = t;
        }
        values[0] = new Ratio(1,1);
        visit(0);
        long lcd = 1;
        for(int i=0; i<n; i++){
            lcd = lcd(lcd, values[i].y);
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = (int) (lcd*values[i].x/values[i].y);
        }
        return result;
    }
}
