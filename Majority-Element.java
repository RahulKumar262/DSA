1class Solution {
2    public int majorityElement(int[] nums) {
3        HashMap<Integer,Integer>m=new HashMap<>();
4        for(int n:nums){
5            m.put(n,m.getOrDefault(n,0)+1);
6            if(m.get(n)>nums.length/2){
7                return n;
8            }
9        }
10        return -1;
11    }
12}