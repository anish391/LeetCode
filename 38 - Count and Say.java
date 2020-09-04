class Solution {
    public String countAndSay(int n) {
        if(n<0)
            return "-1";
        if(n==1)
            return "1";
        String result = "1";
        for(int i=1;i<n;i++){
            result = createSequence(result);
        }
        return result;
    }
    
    public String createSequence(String seq){
        StringBuilder sb = new StringBuilder();
        char currentChar = seq.charAt(0);
        int count = 0;
        for(int i=0;i<seq.length();i++){
            if(currentChar==seq.charAt(i)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(currentChar);
                currentChar = seq.charAt(i);
                count=1;
            }
        }
        sb.append(count);
        sb.append(currentChar);
        return sb.toString();
    }
}