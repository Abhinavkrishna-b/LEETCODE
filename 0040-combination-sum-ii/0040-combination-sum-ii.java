class Solution {
    //The catch if you once used a digit in the combination you cannot use that again eg you cannot have combination like [5,3] and [5,2,1] as 5 repeats in both - you can't reuse the element
    //Note you do this same sorting to solve this same in the 3Sum problem
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int candidates[], int target, int start, int sum, List<Integer> temp, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1]){
                //i > start (not i>0) because to make sure in [1,2,2] to make sure we use the 1st 2 at index 1
                continue;
            }
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates, target, i+1, sum, temp, result);
            temp.remove(temp.size()-1);
            sum-=candidates[i];
        }
    }
}
//You cannot reuse an element if it is in a valid combo
//But if you notice the question allows the duplicates eg : [1,2,2,5] 
//So if you considered this same question without duplicates [1,2,5] then we can make sure using a start variable to solve that same problem of resuing [1,7] and [7,1] will not come again 
//I mean resuing the same element is solved by start variable
//How start solve this [1,2,5] if i visited 1 then the start points to only 2 we will not consider the previous values and that's how it works!
//So the problem is cannot reuse element + duplicates in input
//So we just do the same method did for combination sum 1 but skip the duplicates

//Time- O(n . 2^n) - as if duplicates present you had 2 branch include one element and ignore both 
//Space- O(n)