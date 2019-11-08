class Solution {
    public List<String> commonChars(String[] A) {
        //Map<Character, Integer> map = new HashMap<Character, Integer>();
        int[] count = new int[26];
        int[] dict = new int[26];
        for(int i=0;i<A[0].length();i++){
            dict[A[0].charAt(i)-'a']++;
        }
        for(int i=1;i<A.length;i++){
            int[] curr = new int[26];
            for(int j=0;j<A[i].length();j++){
                curr[A[i].charAt(j)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (curr[j] < dict[j]) 
                    dict[j] = curr[j];
            }
        }
        List<String> list = new ArrayList<String>();
        for(int i=0;i<dict.length;i++){
            while(dict[i]-- > 0){
                char c = (char) ('a'+i);
                list.add(String.valueOf(c));    
            }
        }
        return list;
    }
}