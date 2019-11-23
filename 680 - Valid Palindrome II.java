class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()<=1)
            return true;
        return isPalindrome(s, false);
    }
    
    public boolean isPalindrome(String s, boolean isDeleted){
        int l=0, r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                if(!isDeleted){
                    StringBuilder sb1 = new StringBuilder(s);
                    sb1.deleteCharAt(l);
                    StringBuilder sb2 = new StringBuilder(s);
                    sb2.deleteCharAt(r);
                    return isPalindrome(sb1.toString(), true) || isPalindrome(sb2.toString(),true);
                }
                else
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }
}


class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()<=1)
            return true;
        return isPalindrome(s, false);
    }
    
    public boolean isPalindrome(String s, boolean isDeleted){
        int l=0, r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                if(!isDeleted){
                    return isPalindrome(s.substring(l+1,r+1), true) || isPalindrome(s.substring(l,r),true);
                }
                else
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()<=1)
            return true;
        return isPalindrome(s, false, 0, s.length()-1);
    }
    
    public boolean isPalindrome(String s, boolean isDeleted, int l, int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                if(!isDeleted){
                    return isPalindrome(s, true, l+1, r) || isPalindrome(s, true, l, r-1);
                }
                else
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }
}