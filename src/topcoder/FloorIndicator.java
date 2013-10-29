package topcoder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/26/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FloorIndicator {

    //i : (0,i*4) -> (4,i*4+2)
    private final String[] numbers ={
            "###...#.###.###.#.#.###.###.###.###.###",
            "#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
            "#.#...#.###.###.###.###.###...#.###.###",
            "#.#...#.#.....#...#...#.#.#...#.#.#...#",
            "###...#.###.###...#.###.###...#.###.###",
    };

    private Integer[] match(int i, String[] board){
        ArrayList<Integer> matched = new ArrayList<Integer>();
        for(int j=0; j<=9; j++){
            boolean valid = true;
            for(int row=0; row<5; row++){
                for(int e=0; e<3; e++){
                    if(board[row].charAt(i*4+e)=='#' && numbers[row].charAt(j*4+e) == '.') valid = false;
                }
            }
            if(valid) matched.add(j);
        }
        return matched.toArray(new Integer[0]);
    }
    public double averageFloor(int N, String[] indicator){
        Integer[][] map = new Integer[N][];
        double result = 0;

        for(int i=N-1; i>=0; i--){
            Integer[] matches = match(i, indicator);
            if(matches.length==0) return -1.0;
            map[N-1-i] = matches;
        }

        int level = 1;
        for(int i=0; i<N; i++){
            double sum=0;
            for(int j=0; j<map[i].length; j++){
                sum+=map[i][j];
            }
            result += sum*level/map[i].length;
            level*=10;
        }
        return result;
    }
}
