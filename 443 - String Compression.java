class Solution {
    public int compress(char[] chars) {
        int write = 0, anchor = 0;
        for(int read = 0; read<chars.length;read++){
            if(read+1==chars.length || chars[read]!=chars[read+1]){
                chars[write++] = chars[anchor];
                if(read>anchor){
                    for(char c: (""+(read-anchor+1)).toCharArray())
                        chars[write++] = c;
                }
                anchor = read+1;
            }
        }
        return write;
    }
}