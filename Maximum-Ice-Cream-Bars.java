1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        Arrays.sort(costs);
4        int n=costs.length;
5        int ans=0;
6        for(int i=0;i<n;i++){
7            if(coins-costs[i]>=0){
8                coins-=costs[i];
9                ans++;
10            }
11            else break;
12        }
13        return ans;
14    }
15}