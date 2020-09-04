class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0, high=letters.length;
        while(low<high){
            int mid = low+(high-low)/2;
            if(target<letters[mid])
                high =mid;
            else
                low = mid+1;
        }
        return letters[low>=letters.length?0:low];
    }
}