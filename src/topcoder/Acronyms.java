package topcoder;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/26/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Acronyms {
    private String join(String[] words, String delimiter){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<words.length; i++){
            if(i!=0) builder.append(delimiter);
            builder.append(words[i]);
        }
        return builder.toString();
    }
    private boolean isCapitalized(String word){
        if(word.length() == 0) return false;
        return (word.charAt(0)>='A' && word.charAt(0)<='Z');
    }
    public String acronize(String[] document){
        String oneSpace = " ";
        String twoSpace = "  ";
        String doc = join(document,oneSpace);
        String[] sentences = doc.split(twoSpace);
        ArrayList<String> acronizedSentences = new ArrayList<String>();
        for(String sentence :  sentences){
            String[] words = sentence.split(oneSpace);
            ArrayList<String> buffer = new ArrayList<String>();
            int countLowercase = 0;

            int start = 0, end=0, last = 0;
            for(int i=1; i<words.length; i++){
                if(isCapitalized(words[i])){
                    countLowercase = 0;
                    if(start<=0){
                        start = i;
                        for(int j=last; j<i; j++) buffer.add(words[j]);
                        last = i;
                    }
                    end = i;
                } else{
                    countLowercase++;
                    if(countLowercase>1 && start>0){
                        for(int j = last; j<start; j++) buffer.add(words[j]);
                        if(end-start>0){
                            StringBuilder acronym = new StringBuilder();
                            for(int j=start; j<=end; j++){
                                if(isCapitalized(words[j])){
                                    acronym.append(words[j].replaceAll("[^A-Z]", ""));
                                }
                            }
                            String lastChar = String.valueOf(words[end].charAt(words[end].length() - 1));
                            if(lastChar.matches("[^A-Za-z]")) acronym.append(lastChar);
                            buffer.add(acronym.toString());
                        } else buffer.add(words[start]);
                        last = end+1;
                        start = 0;
                    }
                }
            }

            if(start>0){
                for(int j = last; j<start; j++) buffer.add(words[j]);
                if(end-start>0){
                    StringBuilder acronym = new StringBuilder();
                    for(int j=start; j<=end; j++){
                        if(isCapitalized(words[j])){
                            acronym.append(words[j].replaceAll("[^A-Z]", ""));
                        }
                    }
                    String lastChar = String.valueOf(words[end].charAt(words[end].length() - 1));
                    if(lastChar.matches("[^A-Za-z]")) acronym.append(lastChar);
                    buffer.add(acronym.toString());
                } else buffer.add(words[start]);
                last = end+1;
                start = 0;
            }

            if(last<words.length)
                for(int j=last; j<words.length; j++) buffer.add(words[j]);

            acronizedSentences.add(join(buffer.toArray(new String[0]),oneSpace));
        }

        return join(acronizedSentences.toArray(new String[0]), twoSpace);
    }
}
