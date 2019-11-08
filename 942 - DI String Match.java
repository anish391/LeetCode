class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] result = new int[n+1];
        int left = 0;
        int right = n;
        for(int i=0;i<S.length();i++){
            result[i] = S.charAt(i)=='I' ? left++:right--;
        }
        result[n] = left;
        return result;
    }
}