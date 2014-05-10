package topcoder;

/**
 * Created by chinh on 5/5/14.
 */
public class EmployManager {
    public int maximumEarnings(int[] value, String[] earning){
        int n = value.length;
        int res=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                res-=earning[i].charAt(j)-'0';
            }
        }
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<n; j++) sum+=earning[i].charAt(j)-'0';
            if(sum>value[i]) res+=sum-value[i];
        }
        return res;
    }
}
