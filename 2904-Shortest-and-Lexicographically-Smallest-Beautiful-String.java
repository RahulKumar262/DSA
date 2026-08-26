class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0, ones = 0;
        String res = "";
        for(int r = 0; r < s.length(); r++){
            if(s.charAt(r) == '1')
                ones++;
            while(ones > k){
                if(s.charAt(l) == '1')
                    ones--;
                l++;
            }
            if(ones == k){
                while(l < r && s.charAt(l) == '0')
                    l++;
                String cur = s.substring(l, r + 1);
                if(res.equals("") ||
                   cur.length() < res.length() ||
                   (cur.length() == res.length() &&
                    cur.compareTo(res) < 0)){
                    res = cur;
                }
            }
        }
        return res;
    }
}