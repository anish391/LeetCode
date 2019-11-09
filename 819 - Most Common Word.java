class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> banList = new ArrayList(Arrays.asList(banned));
        int max = Integer.MIN_VALUE;
        String maxString = "";
        Map<String, Integer> map = new HashMap();
        String[] pArray = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");;
        for(String s: pArray){
            if(!banList.contains(s)){
                int value = map.getOrDefault(s,0)+1;
                if(max<value){
                    max = value;
                    maxString = s;
                }
                map.put(s,value);
            }
        }
        return maxString;
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> set = new HashSet(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap();
        int max = Integer.MIN_VALUE;
        String maxWord = "";
        StringBuilder sb = new StringBuilder();
        for(char c: paragraph.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
            else if(sb.length()>0){
                String word = sb.toString();
                if(!set.contains(word)){
                    int value = map.getOrDefault(word,0)+1;
                    if(value>max){
                        max = value;
                        maxWord = word;
                    }
                    map.put(word, value);    
                }
                sb = new StringBuilder();
            }
        }
        return maxWord;
    }
}