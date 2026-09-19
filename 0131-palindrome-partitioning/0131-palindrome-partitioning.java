class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(String s, int start, List<String> temp, List<List<String>> result){
        if(start >= s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(palindrome(s, start, i)){
                temp.add(s.substring(start, i+1));
                backtrack(s, i+1, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean palindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
//Time- O(n . 2^n)
//Space- O(n)
