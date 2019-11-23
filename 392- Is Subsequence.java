public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null || t==null)
            return false;
        Map<Character, List<Integer>> map = new HashMap();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))
                map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }
        int prev = -1;
        //System.out.println(map);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c)==null)
                return false;
            else{
                List<Integer> list = map.get(c);
                prev = binarySearch(prev, list, 0, list.size()-1);
                if(prev==-1)
                    return false;
                prev++;
            }
        }
        return true;
    }
    
    public int binarySearch(int index, List<Integer> list, int start, int end){
        //System.out.println(list);
        while(start<=end){
            int mid = start + (end-start)/2;
            if(list.get(mid)<index)
                start = mid+1;
            else
                end = mid-1;
        }
        return start == list.size() ? -1:list.get(start);
    }
    
}