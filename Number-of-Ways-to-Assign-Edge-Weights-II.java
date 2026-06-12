1class Solution {
2    static int LOG = 17;
3    static int[][] up;
4    static int[] depth;
5    static List<Integer>[] adj;
6    static long[] pow;
7    static final int MOD = 1_000_000_007;
8    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
9        int n = edges.length + 1;
10        adj = new ArrayList[n + 1];
11        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
12        for (int[] e : edges) {
13            adj[e[0]].add(e[1]);
14            adj[e[1]].add(e[0]);
15        }
16        depth = new int[n + 1];
17        up = new int[n + 1][LOG];
18        dfs(1, 1);
19        for (int j = 1; j < LOG; j++) {
20            for (int i = 1; i <= n; i++) {
21                up[i][j] = up[up[i][j - 1]][j - 1];
22            }
23        }
24        pow = new long[n + 1];
25        pow[0] = 1;
26        for (int i = 1; i <= n; i++) {
27            pow[i] = (pow[i - 1] * 2) % MOD;
28        }
29        int[] ans = new int[queries.length];
30        for (int i = 0; i < queries.length; i++) {
31            int u = queries[i][0];
32            int v = queries[i][1];
33
34            int lcaNode = lca(u, v);
35            int dist = depth[u] + depth[v] - 2 * depth[lcaNode];
36
37            if (dist == 0) ans[i] = 0;
38            else ans[i] = (int) pow[dist - 1];
39        }
40        return ans;
41    }
42    void dfs(int node, int parent) {
43        up[node][0] = parent;
44
45        for (int nei : adj[node]) {
46            if (nei == parent) continue;
47            depth[nei] = depth[node] + 1;
48            dfs(nei, node);
49        }
50    }
51    int lca(int a, int b) {
52        if (depth[a] < depth[b]) {
53            int temp = a;
54            a = b;
55            b = temp;
56        }
57        for (int i = LOG - 1; i >= 0; i--) {
58            if (depth[a] - (1 << i) >= depth[b]) {
59                a = up[a][i];
60            }
61        }
62        if (a == b) return a;
63        for (int i = LOG - 1; i >= 0; i--) {
64            if (up[a][i] != up[b][i]) {
65                a = up[a][i];
66                b = up[b][i];
67            }
68        }
69        return up[a][0];
70    }
71}