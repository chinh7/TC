package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/25/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class RookAttack {
    public int howMany(int rows, int cols, String[] cutouts){
        int[] rowCutouts = new int[rows];
        int[] colCutouts = new int[cols];

        for(String coor : cutouts){
            String[] splits = coor.split("\\s");
            int i = Integer.parseInt(splits[0]);
            int j = Integer.parseInt(splits[1]);
            rowCutouts[i]++;
            colCutouts[j]++;
        }
        int validRows=0, validCols=0;
        for(int i=0; i<rows; i++){
            if(rowCutouts[i]<cols) validRows++;
        }
        for(int i=0; i<cols; i++){
            if(colCutouts[i]<rows) validCols++;
        }
        return Math.min(validRows, validCols);
    }
}
