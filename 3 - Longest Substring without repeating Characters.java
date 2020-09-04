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

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int start = 0;
        int end = 0;
        int maxLength = 1;
        int length = s.length();
        Set<Character> set = new HashSet();
        while(start<length && end<length){
            char ch = s.charAt(end);
            if(!set.contains(ch)){
                set.add(ch);
                end++;
                maxLength = Math.max(maxLength, set.size());
            }
            else{
                set.remove(s.charAt(start++));
            }
        }
        return maxLength;
    }
}