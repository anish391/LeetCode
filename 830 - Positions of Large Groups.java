class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int left = 0;
        int right = 0;
        int index = 0;
        List<List<Integer>> result = new ArrayList();
        while(index< S.length()-1){
            if(S.charAt(index)==S.charAt(index+1)){
                int start = index;
                int length = 0;
                while(index< S.length()-1 && S.charAt(index)==S.charAt(index+1)){
                    index++;
                    length++;
                }
                if(length>=2)
                    result.add(Arrays.asList(start, start+length));
            }
            else
                index++;
        }
        return result;
    }
}