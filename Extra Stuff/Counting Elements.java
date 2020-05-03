
class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet();
        int count = 0;
        for(int i: arr)
            set.add(i);
        for(int i: arr){
            if(set.contains(i+1))
                count++;
        }
        return count;
    }
}