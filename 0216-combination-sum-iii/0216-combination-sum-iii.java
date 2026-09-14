class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, 0, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int k, int n, int start, int sum, int count, List<Integer> temp, List<List<Integer>> result){
        if(k != 0 && k == count){
            if(sum == n){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            temp.add(i);
            sum+=i;
            count++;
            backtrack(k, n, i+1, sum, count, temp,result);
            temp.remove(temp.size()-1);
            sum-=i;
            count--;
        }
    }
}
//Time- O(9 . 9^k) where k is the depth of the tree
//Space- O(n)