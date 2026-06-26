1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        Fenwick bit = new Fenwick(2 * n + 5);
5        int offset = n + 2;
6        int prefix = 0;
7        long ans = 0;
8        bit.add(offset, 1);
9        for (int x : nums) {
10            prefix += (x == target) ? 1 : -1;
11            ans += bit.query(prefix + offset - 1);
12            bit.add(prefix + offset, 1);
13        }
14
15        return ans;
16    }
17    static class Fenwick {
18        int[] tree;
19        Fenwick(int n) {
20            tree = new int[n + 2];
21        }
22        void add(int i, int v) {
23            while (i < tree.length) {
24                tree[i] += v;
25                i += i & -i;
26            }
27        }
28        int query(int i) {
29            int s = 0;
30            while (i > 0) {
31                s += tree[i];
32                i -= i & -i;
33            }
34            return s;
35        }
36    }
37}