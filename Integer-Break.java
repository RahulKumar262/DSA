1class Solution {
2    public int integerBreak(int n) {
3        if(n==2 || n==3) return n-1;
4        int product=1;
5        while(n>4){
6            product *=3;
7            n-=3;
8        }
9        return product*n;
10    }
11}