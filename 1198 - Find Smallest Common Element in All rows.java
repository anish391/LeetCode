class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap();
        int small = Integer.MAX_VALUE;
        int freq = Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int value = map.getOrDefault(mat[i][j],0)+1;
                map.put(mat[i][j], value);
                if(value>freq){
                    freq = value;
                    small = mat[i][j];
                }
            }
        }
        return freq==mat.length?small:-1;
    }
}

class Solution {
    public int smallestCommonElement(int[][] mat) {
        for(int j=0;j<mat[0].length;j++){
            boolean found = true;
            for(int i=1;i<mat.length && found;i++){
                found = Arrays.binarySearch(mat[i],mat[0][j])>=0;
            }
            if(found)
                return mat[0][j];
        }
        return -1;
    }
}