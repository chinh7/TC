package topcoder;

import java.util.StringTokenizer;

/**
 * Created by chinh on 04/11/2014.
 */
public class NamingConvention {
    public String toCamelCase(String variableName){
        StringTokenizer st = new StringTokenizer(variableName, "_");
        StringBuffer sb = new StringBuffer();
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if(sb.length()==0) sb.append(s); else sb.append(s.substring(0, 1).toUpperCase() + s.substring(1));
        }
        return sb.toString();
    }
}
