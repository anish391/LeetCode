class Solution {
    public String reverseWords(String s) {
        String[] sArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sArray.length;i++){
            StringBuilder temp = new StringBuilder(sArray[i]);
            temp = temp.reverse();
            sb.append(temp);
            if(i!=sArray.length-1)
                sb.append(" ");
        }
        return sb.toString();
    }
}