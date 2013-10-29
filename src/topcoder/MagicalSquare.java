package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/19/13
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class MagicalSquare {
    String[] rowStrings;
    long result = 0;
    String[][] debug = new String[3][3];
    private void find(int r, String[] rowStrings, String[] columnStrings){
        int n = rowStrings[r].length();
        String[] gen = new String[3];
        for(int i=0; i<=n; i++){
            for(int j=i; j<=n; j++){
                gen[0] = rowStrings[r].substring(0,i);
                gen[1] = rowStrings[r].substring(i,j);
                gen[2] = rowStrings[r].substring(j,n);
                boolean valid = true;

                String[] col = Arrays.copyOf(columnStrings, 3);
                for(int c=0; c<3; c++){
                    if(!col[c].startsWith(gen[c])){
                        valid = false;
                        break;
                    } else{
                        col[c] = col[c].replaceFirst(gen[c], "");
                    }
                }
                if(!valid) continue;
//                debug[r] = Arrays.copyOf(gen,3);
                if(r==0){
                    find(1, rowStrings, col);
                } else{
                    String concat = col[0]+col[1]+col[2];
                    if(concat.compareTo(rowStrings[2])==0) result++;
//                    debug[2] = Arrays.copyOf(col, 3);
//                    System.out.println(result);
//                    for(int e=0; e<3; e++){
//                        for(int f=0; f<3; f++){
//                            System.out.print(debug[e][f]+" | ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("-------------------------");
                }
            }
        }

    }
    public long getCount(String[] rowStrings, String[] columnStrings){
        find(0, rowStrings, columnStrings);
        return result;
    }
}
