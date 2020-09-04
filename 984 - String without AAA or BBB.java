class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while(A+B>0){
            int currentLength = sb.length();
            if(currentLength>1 && sb.charAt(currentLength-1)==sb.charAt(currentLength-2)){
                if(sb.charAt(currentLength-1)=='a'){
                    sb.append('b');
                    B--;
                }
                else{
                    sb.append('a');
                    A--;
                }
            }
            else{
                if(A>B){
                    sb.append('a');
                    A--;
                }
                else{
                    sb.append('b');
                    B--;
                }
            }
        }
        return sb.toString();
    }
}