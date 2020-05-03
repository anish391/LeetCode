class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        helper(S,"", 0, result);
        return result;
    }
    
    public void helper(String S, String perm, int index, List<String> result){
        if(index==S.length())
            result.add(perm);
        else{
            if(Character.isLetter(S.charAt(index))){
                helper(S, perm+Character.toLowerCase(S.charAt(index)), index+1, result);
                helper(S, perm+Character.toUpperCase(S.charAt(index)), index+1, result);
            }
            else{
                helper(S, perm+S.charAt(index), index+1, result);
            }
        }
        
    }
}