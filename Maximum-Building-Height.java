1class Solution {
2    public int maxBuilding(int n, int[][] restrictions) {
3        if(restrictions.length==0){
4            return n-1;
5        }
6        Arrays.sort(restrictions,((a,b)->Integer.compare(a[0],b[0])));
7        int m=restrictions.length;
8        restrictions[0][1]=Math.min(restrictions[0][1],restrictions[0][0]-1);
9        for(int i=1;i<m;i++){
10            int dd=restrictions[i][0]-restrictions[i-1][0];
11            restrictions[i][1]=Math.min(restrictions[i][1],restrictions[i-1][1]+dd);
12        }
13        for(int i=m-2;i>=0;i--){
14            int dd=restrictions[i+1][0]-restrictions[i][0];
15            restrictions[i][1]=Math.min(restrictions[i][1],restrictions[i+1][1]+dd);
16        }
17        int ans=0;
18        ans=Math.max(ans,(restrictions[0][0]-1+restrictions[0][1])/2);
19        for(int i=1;i<m;i++){
20            int right=restrictions[i][0];
21            int left=restrictions[i-1][0];
22            int h1=restrictions[i][1];
23            int h2=restrictions[i-1][1];
24            int max=(right-left+h1+h2)/2;
25            ans=Math.max(ans,max);
26        }
27        int lastId=restrictions[m-1][0];
28        int lastH=restrictions[m-1][1];
29        ans=Math.max(ans,lastH+(n-lastId));
30        return ans;
31    }
32}