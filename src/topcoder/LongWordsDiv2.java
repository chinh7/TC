package topcoder;

/**
 * Created by chinh on 4/25/14.
 */
public class LongWordsDiv2 {
    int lcs(String a, String b)
    {
        int[][] lengths = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                    lengths[i+1][j+1] =
                            Math.max(lengths[i+1][j], lengths[i][j+1]);
        return lengths[a.length()][b.length()];
    }

    public String find(String word){
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)<'A' || word.charAt(i)>'Z') return "Dislikes";
        }
        for(int i=0; i<word.length()-1; i++){
            if(word.charAt(i)==word.charAt(i+1)) return "Dislikes";
        }
        for(int i=0; i<word.length()-1; i++){
            for(int j=i+1; j<word.length(); j++){
                String tmp = ""+word.charAt(i)+word.charAt(j)+word.charAt(i)+word.charAt(j);
                if(lcs(word, tmp)==4) return "Dislikes";
            }
        }
        return "Likes";
    }
}
