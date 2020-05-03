class Solution {
    public String generateTheString(int n) {
        if(n%2==1)
            return "b".repeat(n);
        else
            return "a"+"b".repeat(n-1);
    }
}