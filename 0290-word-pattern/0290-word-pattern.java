class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if(words.length != pattern.length())    return false;
        HashMap<Character,String> charToword = new HashMap<>();
        HashMap<String,Character> wordTochar = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            if(charToword.containsKey(ch) && !charToword.get(ch).equals(word)){
                return false;
            }

            if(wordTochar.containsKey(word) && wordTochar.get(word) != ch){
                return false;
            }

            charToword.put(ch, word);
            wordTochar.put(word, ch);
        }
        return true;
    }
}
//Time- O(n)
//Space- O(n)