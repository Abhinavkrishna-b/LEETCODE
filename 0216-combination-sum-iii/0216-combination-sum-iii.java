class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 0, 0, 1, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int k, int n, int count, int sum, int start, List<Integer> temp, List<List<Integer>> result){
        if(count == k){
            if(sum == n){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            temp.add(i);
            sum+=i;
            count++;
            backtrack(k, n, count, sum, i+1, temp, result);
            count--;
            sum-=i;
            temp.remove(temp.size()-1);
        }
    }
}
//Time- O(9 . 9^k)
//Space- O(n)