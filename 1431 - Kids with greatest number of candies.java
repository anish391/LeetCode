class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList();
        int max = findMax(candies);
        for(int c: candies){
            if(c+extraCandies>=max)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
    
    public int findMax(int[] candies){
        int max = Integer.MIN_VALUE;
        for(int c: candies)
            // Using Math.max on every element of array is slower.
            if(max<c)
                max = c;
        return max;
    }
}