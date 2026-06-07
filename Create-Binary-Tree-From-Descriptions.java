1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode createBinaryTree(int[][] descriptions) {
18        HashMap<Integer, TreeNode> nodes = new HashMap<>();
19        HashSet<Integer> children = new HashSet<>();
20        for (int[] d : descriptions) {
21            int parent = d[0];
22            int child = d[1];
23            int isLeft = d[2];
24            if (!nodes.containsKey(parent)) {
25                nodes.put(parent, new TreeNode(parent));
26            }
27            if (!nodes.containsKey(child)) {
28                nodes.put(child, new TreeNode(child));
29            }
30            TreeNode parentNode = nodes.get(parent);
31            TreeNode childNode = nodes.get(child);
32            if (isLeft == 1) {
33                parentNode.left = childNode;
34            } else {
35                parentNode.right = childNode;
36            }
37            children.add(child);
38        }
39
40        for (int[] d : descriptions) {
41            int parent = d[0];
42            if (!children.contains(parent)) {
43                return nodes.get(parent);
44            }
45        }
46        return null;
47    }
48}