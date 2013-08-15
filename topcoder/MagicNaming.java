package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/15/13
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MagicNaming {
    public int maxReindeers(String magicName){
        int n = magicName.length();
        String[][] build = new String[n][n];
        build[0][0] = String.valueOf(magicName.charAt(0));
        for(int i=1; i<n; i++){
            String s = String.valueOf(magicName.charAt(i));
            for(int j=0; j<=i; j++){
                String first=null, second=null;
                if(j>0 && build[i-1][j-1]!=null){
                    String source = build[i-1][j-1]+s;
                    for(int e=1; e<source.length(); e++){
                        String start = source.substring(0,e);
                        String end = source.substring(e,source.length());
                        boolean valid = (start.compareTo(end)<=0);
                        int ii=i-2, jj=j-2;
                        while(ii>=0 && jj>=0){
                            if(start.compareTo(build[ii][jj])<0){
                                valid = false;
                                break;
                            }
                            ii--; jj--;
                        }
                        if(valid && (first==null || first.compareTo(end)>0)){
                            first = end;
                            build[i-1][j-1] = start;
                        }
                    }
                }
                if(build[i-1][j]!=null){
                    second = build[i-1][j]+s;
                }
                String chosen = (first != null) ? first : second;
                if(second!=null && second.compareTo(chosen)<0) chosen=second;
                build[i][j] = chosen;
            }
        }
        for(int i=n-1; i>=0; i--)
            if(build[n-1][i]!=null) return(i+1);
        return 0;
    }
}
