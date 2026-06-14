1class Solution {
2    public int pairSum(ListNode head) {
3        List<Integer> list = new ArrayList<>();
4        ListNode node = head;
5        while (node != null) {
6            list.add(node.val);
7            node = node.next;
8        }
9        int ma = Integer.MIN_VALUE, n = list.size();
10        for (int i = 0; i < n / 2; i++) {
11            ma = Math.max(ma, list.get(i) + list.get(n - 1 - i));
12        }
13        return ma;
14    }
15}