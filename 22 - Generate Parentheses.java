class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String s, int opening, int closing, int maxBrackets){
        if(s.length()==max*2){
            list.add(s);
            return;
        }
        if(opening<maxBrackets)
            backtrack(list, s+"(", opening+1, closing, maxBrackets);
        if(closing<opening)
            backtrack(list, s+")", opening, closing+1, maxBrackets);
    }
}