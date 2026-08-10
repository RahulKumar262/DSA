class Solution {
    Boolean[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return game(n);
    }
    private boolean game(int stones) {
        if (stones == 0) return false;
        if (memo[stones] != null) {
            return memo[stones];
        }
        for (int x = 1; x * x <= stones; x++) {
            if (!game(stones - x * x)) {
                return memo[stones] = true;
            }
        }
    return memo[stones] = false;
    }
}