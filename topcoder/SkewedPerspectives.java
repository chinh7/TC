package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/6/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SkewedPerspectives {
    public String[] areTheyPossible(int[] types, int B, int w, String[] views){
        int n = views.length;
        String[] result = new String[n];
        for(int i=0; i<n; i++){
            String view = views[i];
            int j=0;
            int platform=0;
            int odd = 0;
            int b = B;
            int[] cubes = Arrays.copyOf(types,3);
            boolean valid = true;
            int width = w;
            while(j<view.length()){
                if(view.charAt(j)=='b'){
                    int l = 1; //length of spanned 'b's
                    while(j+l<view.length() && view.charAt(j+l)=='b') l++;
                    b = b - l/2 - l%2;  //use an additional b if l is odd
                    if(b<0){
                        valid = false;
                        break;
                    }
                    if(l%2!=0){
                        if(j==0){  //upfront (block 0)
                            platform++;
                            odd++;
                        } else{    //already have smt in the front
                            odd+=(j-1)%2;
                            platform+=j-1;
                        }

                        width--; //need additional block in this case
                        if(width==0){
                            valid = false;
                            break;
                        }
                    }
                    if(j==0 && l==1){
                        valid = false;
                        break;
                    }
                    j+=l;
                } else{
                    int value = view.charAt(j)-'0';
                    cubes[value]--;
                    if(cubes[value]<0){
                        valid = false;
                        break;
                    }
                    j++;
                }
            }
            if(platform>cubes[0]+cubes[1]+cubes[2]+b*2) valid = false;
            if(odd > cubes[0]+cubes[1]+cubes[2]) valid = false;

            result[i] = valid ? "valid" : "invalid";
        }
        return result;
    }
}
