1/*   
2              MEMOIZTION
3
4class Solution {
5    public int fib(int n) {
6        int dp[]=new int[n+1];
7        Arrays.fill(dp,-1);
8        return helper(dp,n);
9    }
10    public int helper(int[] dp, int n){
11       if(n==0) return 0;
12       if(n==1) return 1;
13       if(dp[n]!=-1) return dp[n];
14       return dp[n]=helper(dp,n-1)+helper(dp,n-2);
15    }
16}
17
18             TABULATION    */
19
20class Solution {
21    public int fib(int n) {
22        int dp[]=new int[n+1];
23        if(n<=1) return n;
24        dp[0]=0;
25        dp[1]=1;
26        for(int i=2;i<=n;i++){
27            dp[i]=dp[i-1]+dp[i-2];
28        }
29        return dp[n];
30    }
31}