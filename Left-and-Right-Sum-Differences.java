1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n=nums.length;
4        int leftsum=0;
5        int totalsum=0;
6        int answer [] = new int [n];
7        for(int i=0;i<n;i++){
8            totalsum += nums[i];
9        }
10        for(int i=0;i<n;i++){
11            int rightsum = totalsum - leftsum - nums[i];
12            answer[i] = Math.abs(leftsum - rightsum);
13            leftsum +=nums[i]; 
14        }
15        return answer;
16    }
17}