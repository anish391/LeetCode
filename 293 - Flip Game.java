class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList();
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='-')
                continue;
            else{
                if(s.charAt(i+1)=='+'){
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0,i));
                    sb.append("--");
                    sb.append(s.substring(i+2));
                    //String temp = +"--"+s.substring(i+2);
                    result.add(sb.toString());   
                }
            }
        }
        return result;
    }
}