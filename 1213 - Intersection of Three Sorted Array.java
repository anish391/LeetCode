class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList();
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length && k<arr3.length){
            int min = Math.min(arr1[i],Math.min(arr2[j],arr3[k]));
            if(arr1[i]==min && arr2[j]==min && arr3[k]==min)
                result.add(min);
            if(arr1[i]==min)
                i++;
            if(arr2[j]==min)
                j++;
            if(arr3[k]==min)
                k++;
        }
        return result;
    }
}