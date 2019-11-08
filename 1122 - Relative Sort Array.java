class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i: arr1)
            map.put(i, map.getOrDefault(i,0)+1);
        for(int i: arr2){
            int size = map.get(i);
            for(int j=0;j<size;j++)
                list.add(i);
            map.remove(i);
        }
        for(int i: map.keySet()){
            int size = map.get(i);
            for(int j=0;j<size;j++)
                list.add(i);
        }
        int[] arr3 = new int[list.size()];
        int index=0;
        for(int i: list){
            arr3[index++] = i;
        }
        return arr3;
    }
}

#Solution based on conditions
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for(int i:arr1)
            count[i]++;
        int j=0;
        for(int i:arr2){
            while(count[i]-- > 0)
                arr1[j++] = i;
        }
        for(int i=0;i<count.length;i++){
            while(count[i]-- > 0){
                arr1[j++] = i;
            }
        }
        return arr1;
    }
}