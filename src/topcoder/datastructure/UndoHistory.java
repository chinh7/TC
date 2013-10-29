package topcoder.datastructure;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/16/13
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class UndoHistory {
    private class TrieNode{
        private TrieNode[] children = new TrieNode[26];

        public TrieNode[] getChildren() {
            return children;
        }
    }

    private class Trie{
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        /**
         * inserts the word to this Trie, and returns the longest match
         * @param word
         * @return
         */
        public int addWord(String word){
            int ret = 0;
            TrieNode current = root;
            for(char c : word.toCharArray()){
                TrieNode[] children = current.getChildren();
                if(children[c-'a']!=null){
                    ret++;
                } else{
                    children[c-'a'] = new TrieNode();
                }
                current = children[c-'a'];
            }
            return ret;
        }

    }
    public int minPresses(String[] lines){
        int pressCount = 0;
        Trie trie = new Trie();
        String prev = "";
        for(String line : lines){
            if(line.startsWith(prev)){
                pressCount+=line.length()-prev.length()+1;
                trie.addWord(line);
            } else{
                pressCount+=line.length()-trie.addWord(line)+3;
            }
            prev = line;
        }
        return pressCount;
    }
}
