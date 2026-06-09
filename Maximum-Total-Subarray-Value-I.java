1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int max=nums[0], min=nums[0];
4        for(int num : nums){
5            max=Math.max(max,num);
6            min=Math.min(min,num);
7        }
8        return (long)k*(max-min);
9    }
10}