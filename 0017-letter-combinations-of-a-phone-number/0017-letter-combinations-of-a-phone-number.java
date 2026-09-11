class Solution {
    //Refer Notes in leetcode and see that video if any doubt
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)  return new ArrayList<>();
        HashMap<Character, String> words = new HashMap<>();
        words.put('2',"abc");
        words.put('3',"def");
        words.put('4',"ghi");
        words.put('5',"jkl");
        words.put('6',"mno");
        words.put('7',"pqrs");
        words.put('8',"tuv");
        words.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), words, result);
        return result;
    }

    public void backtrack(String digits, int i, StringBuilder temp, Map<Character, String> words, List<String> result){
        
        if(i >= digits.length()){
            result.add(temp.toString());
            return;
        }
        String word = words.get(digits.charAt(i));
        for(char ch : word.toCharArray()){
            temp.append(ch);
            backtrack(digits, i+1, temp, words, result);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
//Time- O(4^l)
//Space- O(n)