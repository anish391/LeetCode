class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int depth = 0;
        for(int i=0;i<result.length;i++){
            if(seq.charAt(i)=='(')
                depth++;
            result[i] = depth%2;
            if(seq.charAt(i)==')')
                depth--;
        }
        return result;
    }
}