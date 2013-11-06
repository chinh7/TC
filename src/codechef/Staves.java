package codechef;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/5/13
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * (1x1+2x2+3x3+4x4)/(x1+x2+x3+x4) = 2.5
 * -> 1.5x1 + 0.5x2 = 0.5x3 + 1.5x4 :)
 */
public class Staves {
    static int sum(int[] numbers, int i, int j){
        int result = 0;
        for(int u=i; u<=j; u++) result+=numbers[u];
        return result;
    }
    static int forwardSum(int[] numbers, int i, int j){
        int weight=1;
        int result=0;
        for(int u=i; u<=j; u++){
            result+=numbers[u]*weight;
            weight+=2;
        }
        return result;
    }
    static int backwardSum(int[] numbers, int i, int j){
        int weight=1;
        int result=0;
        for(int u=j; u>=i; u--){
            result+=numbers[u]*weight;
            weight+=2;
        }
        return result;
    }

    public static void main() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Staves.input"));
        String s = br.readLine();
        int n = s.length();
        int[] sections = new int[n];
        for(int i=0; i<n; i++){
            sections[i] = Integer.parseInt(s.charAt(i)+"");
        }
        int k = n/2;
        int[] firstIndex = new int[5*k*k];
        for(int l=k; l>0; l--){
            Arrays.fill(firstIndex, -1);
            for(int i=0; i<n-l+1; i++){
                int j=i+l-1;
                int afterL = n-1-j;
                int beforeL = i;
                if(afterL<k && beforeL<k) continue;

                int sum = forwardSum(sections, i, j);
                if(firstIndex[sum]>=0){
                    if(firstIndex[sum]+l<i){
                        System.out.println(firstIndex[sum] + " " + i + " " + l);
                        return;
                    }
                } else{
                    firstIndex[sum] = i;
                }

                sum = backwardSum(sections, i, j);
                if(firstIndex[sum]>=0){
                    if(firstIndex[sum]+l<i){
                        System.out.println(firstIndex[sum] + " " + i + " " + l);
                        return;
                    }
                } else{
                    firstIndex[sum] = i;
                }

            }
        }
    }
}