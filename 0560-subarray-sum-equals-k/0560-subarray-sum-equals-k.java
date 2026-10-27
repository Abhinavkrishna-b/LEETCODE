//Why sliding window fails here - refer leetcode notes
//The hashmap solution is confusing refer neetcode or Nikhil Lohia and editorial is also free for this
//Note neetcode solution explaination has a mistake that is explained in the comment
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
//Time- O(n)
//Space- O(n)