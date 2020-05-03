class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, left=0, right=0;
        Set<Character> set = new HashSet();
        while(left<n && right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, right-left);
            }
            else{
                set.remove(s.charAt(left++));
            }
        }
        return ans;
    }
}