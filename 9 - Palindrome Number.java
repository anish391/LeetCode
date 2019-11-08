class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        char[] a = s.toCharArray();
        int i = 0, j = a.length-1;
        while(i<=j){
            if(a[i]!=a[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}

# Epic Solution

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))
            return false;
        int rev = 0;
        while(x>rev){
            rev = rev*10+x%10;
            x/=10;
        }
        return x==rev || x == rev/10;
    }
}