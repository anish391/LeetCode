class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String s: strs){
            String original = s;
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String key = new String(chArray);
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(original);
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList();
        for(String key: map.keySet()){
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }
}

// Less Complexity. Slower on Leetcode.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String s: strs){
            String original = s;
            int[] chArray = new int[26];
            for(char c: original.toCharArray()){
                chArray[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i: chArray){
                sb.append("#");
                sb.append(i);
            }
            String key = sb.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(original);
//             List<String> list = map.getOrDefault(key, new ArrayList());
            
//             list.add(original);
//             map.put(key, list);
        }
        List<List<String>> result = new ArrayList();
        for(String key: map.keySet()){
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }
}