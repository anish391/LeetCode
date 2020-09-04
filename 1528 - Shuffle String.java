class Solution {
    public String restoreString(String s, int[] indices) {
        char[] cArray = new char[s.length()];
        for(int i=0;i<indices.length;i++){
            cArray[indices[i]] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cArray.length;i++){
            sb.append(cArray[i]);
        }
        return sb.toString();
    }
}