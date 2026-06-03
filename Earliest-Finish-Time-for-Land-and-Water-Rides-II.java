1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3                                  int[] waterStartTime, int[] waterDuration) {
4
5        return Math.min(
6            solve(landStartTime, landDuration, waterStartTime, waterDuration),
7            solve(waterStartTime, waterDuration, landStartTime, landDuration)
8        );
9    }
10
11    private int solve(int[] first, int[] firstDuration,
12                      int[] second, int[] secondDuration) {
13
14        int finish1 = Integer.MAX_VALUE;
15
16        for (int i = 0; i < first.length; i++) {
17            finish1 = Math.min(finish1, first[i] + firstDuration[i]);
18        }
19
20        int finish2 = Integer.MAX_VALUE;
21
22        for (int i = 0; i < second.length; i++) {
23            finish2 = Math.min(
24                finish2,
25                Math.max(finish1, second[i]) + secondDuration[i]
26            );
27        }
28
29        return finish2;
30    }
31}