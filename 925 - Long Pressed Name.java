class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameLen = name.length();
        int typedLen = typed.length();
        int i = 0;
        for(int j=0;j<typedLen;j++){
            if(i<nameLen && name.charAt(i)==typed.charAt(j)){
                i++;
            }
            else if(j==0 || typed.charAt(j)!=typed.charAt(j-1))
                return false;
        }
        return i==nameLen;
    }
}