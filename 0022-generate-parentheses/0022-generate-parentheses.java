class Solution {
    public List<String> generateParenthesis(int n) {
        //You must know the 2 rules to solve this - those are in the leetcode notes
        List<String> result = new ArrayList<>();
        backtrack(n, new StringBuilder(), result, 0, 0);
        return result;
    }

    public void backtrack(int n, StringBuilder temp, List<String> result, int ob, int cb){
        if(temp.length() == n*2){
            //An important edge case
            if(ob == cb){
                result.add(new String(temp));
                return;
            }
            //Else is ())) or ((() or ((((
            return;
        }

        if(ob < n){
            temp.append('(');
            backtrack(n, temp, result, ob+1, cb);
            temp.deleteCharAt(temp.length()-1);
            // ob--; It is not needed because i never updated it directly i only passed ob+1 no update
        }
        if(cb < ob){
            temp.append(')');
            backtrack(n, temp, result, ob, cb+1);
            temp.deleteCharAt(temp.length()-1);
            // cb--;
        }
    }
}