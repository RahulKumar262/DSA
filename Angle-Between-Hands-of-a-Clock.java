1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double mAngle = 6.0 * minutes;
4        double hAngle = 30.0 * (hour % 12) + 0.5 * minutes;
5        double diff = Math.abs(hAngle - mAngle);
6        return Math.min(diff, 360.0 - diff);
7    }
8}