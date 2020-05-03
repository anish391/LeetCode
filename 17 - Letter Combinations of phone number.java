class Solution {
    public List<String> letterCombinations(String digits) { 
        List<String> result = new ArrayList();
        if(digits.length()==0 || digits==null)
            return result;
        Map<Character, String> map = new HashMap();
        initializeMap(map);
        StringBuilder sb = new StringBuilder();
        letterCombinations(digits, map, 0, sb, result);
        return result;
    }
    
    public void letterCombinations(String digits, Map<Character, String> map, int index, StringBuilder sb, List<String> result){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        for(char c: map.get(digit).toCharArray()){
            sb.append(c);
            letterCombinations(digits, map, index+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public void initializeMap(Map<Character, String> map){
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}