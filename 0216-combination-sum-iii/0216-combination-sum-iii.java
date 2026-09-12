class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 0, 1, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int k, int n, int count, int start, int sum, List<Integer> temp, List<List<Integer>> result){
        if(count == k && count != 0){
            if(sum == n){
                result.add(new ArrayList<>(temp));
            }
            //else
            return;
        }
        for(int i=start;i<=9;i++){
            temp.add(i);
            sum+=i;
            count++;
            backtrack(k, n, count, i+1, sum, temp, result);
            temp.remove(temp.size()-1);
            sum-=i;
            count--;
        }
    }
}
//Time- O(9^k)
//Space- O(n)
//Note i pass the start initially as 1 and i intialized for start and again recursion happens for i+1