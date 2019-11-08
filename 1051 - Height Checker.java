class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for(int i: heights){
            freq[i]++;
        }
        int result = 0;
        int curr = 0;
        for(int i=0;i<heights.length;i++){
            while(freq[curr]==0){
                curr++;
            }
            if(heights[i]!=curr){
                result++;
            }
            freq[curr]--;
        }
        return result;
    }
}