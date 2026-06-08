1/*   MEMOIZATION 
2class Solution {
3    public int tribonacci(int n) {
4        int dp[]=new int[n+1];
5        Arrays.fill(dp,-1);
6        return fun(dp,n);  
7    }
8    public int fun(int dp[], int n){
9        if(n>=0 && n<2) return n;
10        if(n==2) return 1;
11        if(dp[n]!=-1) return dp[n];
12        return dp[n]=fun(dp,n-1)+fun(dp, n-2) + fun(dp,n-3);
13    }
14}  
15
16  TABULATION  */
17
18class Solution {
19    public int tribonacci(int n) {
20        int dp[]=new int[n+1];
21        Arrays.fill(dp,-1);
22        if(n==0) return 0;
23        if(n==2 || n==1 ) return 1;
24        dp[0]=0;
25        dp[1]=1;
26        dp[2]=1;
27        for(int i=3;i<=n;i++){
28            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
29        }
30        return dp[n];
31    }
32}