1class Solution {
2    public int numberOfArithmeticSlices(int[] nums) {
3        if(nums.length<=2) {
4            return 0;
5        }
6        int ans=0;
7        int cur=0;
8        for(int i=2;i<nums.length;i++){
9            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
10                cur=cur+1;
11                ans +=cur;
12            }else{
13                cur=0;
14            }
15        }
16        return ans;
17    }
18}