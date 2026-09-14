class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, 0, new ArrayList<>(), result);
        //Here pass start = 1 as n starts from 1 not 0
        return result;
    }

    public void backtrack(int n, int k, int start, int count, List<Integer> temp, List<List<Integer>> result){
        if(count == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n;i++){
            temp.add(i);
            count++;
            backtrack(n, k, i+1, count,temp, result);
            temp.remove(temp.size()-1);
            count--;
        }
    }
}
//Time- O(n^k) see the decision tree you drawn and you will understand
//Space- O(n)
