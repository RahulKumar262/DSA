class Solution {

    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int left = 0;
        long currSum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {

            currSum += nums[right];

            while (currSum > target) {
                currSum -= nums[left++];
            }

            if (currSum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        return maxLength == -1 ? -1 : n - maxLength;
    }
}