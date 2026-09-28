class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> words = new HashMap<>();
        words.put('2',"abc");
        words.put('3',"def");
        words.put('4',"ghi");
        words.put('5',"jkl");
        words.put('6',"mno");
        words.put('7',"pqrs");
        words.put('8',"tuv");
        words.put('9',"wxyz");
        backtrack(digits, 0, words, new StringBuilder(), result);
        return result;
    }

    public void backtrack(String digits, int start, HashMap<Character,String> words, StringBuilder temp, List<String> result){
        if(start >= digits.length()){
            result.add(new String(temp));
            return;
        }
        String word = words.get(digits.charAt(start));
        for(int i=0;i<word.length();i++){
            temp.append(word.charAt(i));
            backtrack(digits, start+1, words, temp, result);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
//Time- O(4^n) 4 -> we have only 3 to 4 choice per level and the depth goes upto n
//Space- O(n) -> this is for stack (recursion) only hashmap space is constant