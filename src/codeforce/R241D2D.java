package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/13/14.
 */
public class R241D2D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long constant = null;
        Integer unknownStart = null;

        int index=-1;
        long value=-1;
        int result=1;
        for(int i=0; i<n; i++){
            long current = Long.parseLong(st.nextToken());
            if(current>0){
                if(index>=0){
                    if(constant!=null){
                        if(current-value != constant*(i-index)){
                            constant=null;
                            unknownStart=null;
                            result++;
                        }
                    } else{
                        if((current-value)%(i-index)==0){
                            constant = (current-value)/(i-index);
                            if(unknownStart!=null){
                                if(current+(unknownStart-i)*constant<1) {
                                    constant=null;
                                    unknownStart=null;
                                    result++;
                                }
                            }
                        } else{
                            unknownStart=null;
                            result++;
                        }
                    }
                }
                value = current;
                index = i;
            } else{
                if(constant!=null){
                    if(value+(i-index)*constant<1){
                        index=-1;
                        constant = null;
                        unknownStart = i;
                        result++;
                    }
                } else
                if(unknownStart==null){
                    unknownStart=i;
                }
            }
        }
        System.out.println(result);
    }
}
