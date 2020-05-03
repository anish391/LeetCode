public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            String length = Integer.toString(str.length());
            sb.append(length+"/");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        int index = 0;
        while(index<s.length()){
            int slashIndex = s.indexOf("/", index);
            int length = Integer.parseInt(s.substring(index, slashIndex));
            index = slashIndex + length + 1;
            String string = s.substring(slashIndex+1, index);
            result.add(string);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));