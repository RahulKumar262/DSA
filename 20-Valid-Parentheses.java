class Solution {
    public boolean isValid(String s) {
        int n = s.length(), idx = -1;
        char[] st = new char[n];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st[++idx] = ch;
            else {
                if(idx == -1) return false;
                if(ch == ')' && st[idx] != '(') return false;
                else if(ch == '}' && st[idx] != '{') return false;
                else if(ch == ']' && st[idx] != '[') return false; 
                idx--;
            }
        }
        return idx == -1;
    }
}