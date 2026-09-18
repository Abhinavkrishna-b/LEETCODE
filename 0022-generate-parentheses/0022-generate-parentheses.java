class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public void backtrack(int n, int cb, int ob, StringBuilder temp, List<String> result){
        if(temp.length() == n*2){
            if(ob == cb){
                result.add(new String(temp));
                return;
            }
            //Else is ())) or ((()
            return;
        }

        // Rule 1: You can add an opening parenthesis if you haven't used up 'n' of them
        if(ob <= n){
            temp.append('(');
            backtrack(n, cb, ob+1, temp, result);
            temp.deleteCharAt(temp.length()-1);
        }


        // Rule 2: You can only add a closing parenthesis if it matches an open one
        if(cb < ob){
            temp.append(')');
            backtrack(n, cb+1, ob, temp, result);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}