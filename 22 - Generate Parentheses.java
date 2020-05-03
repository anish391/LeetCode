class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        backtrack(n,n, "");
        System.out.println(result);
        return result;
    }
    
    public void backtrack(int left, int right, String s){
        if(left==0 && right==0){
            result.add(s);
            return;
        }
        if(left<=right && left>=0){
            backtrack(left-1, right, s+"(");
        }
        if(left<right && left>=0){
            backtrack(left,right-1, s+")");
        }
    }
}