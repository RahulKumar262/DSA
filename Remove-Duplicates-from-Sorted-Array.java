1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int k = 1;
4        for (int i = 1; i < nums.length; i++) {
5            if (nums[i] != nums[k - 1]) {
6                nums[k] = nums[i];
7                k++;
8            }
9        }
10        return k;
11    }
12}