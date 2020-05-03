// Merge Sort

class Solution {
    public List<Integer> sortArray(int[] nums) {
        nums = mergeSort(nums);
        List<Integer> result = new ArrayList();
        for(int i: nums)
            result.add(i);
        return result;
    }
    
    public int[] mergeSort(int[] nums){
        if(nums.length==1)
            return nums;
        int mid = nums.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left, right);
    }
    
    public int[] merge(int[] left, int[] right){
        int[] ans = new int[left.length+right.length];
        int index = 0;
        int l=0,r=0;
        while(l<left.length && r<right.length){
            if(left[l]<=right[r])
                ans[index++] = left[l++];
            else
                ans[index++] = right[r++];
            
        }
        while(l<left.length)
            ans[index++] = left[l++];
        while(r<right.length)
            ans[index++] = right[r++];
        return ans;
    }
}


// Heap Sort

class Solution {
    
    public class Heap{
        private int[] heap;
        private int size;
        private int maxSize;
        
        public Heap(int maxSize){
            this.size = 0;
            this.maxSize = maxSize;
            heap = new int[maxSize+1];
            heap[size]= Integer.MIN_VALUE;
        }
        
        public void insert(int element){
            heap[++size]= element;
            int current = size;
            while(heap[current] < heap[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            }
        }
        
        public int getMin(){
            int popped = heap[1];
            heap[1] = heap[size];
            heapify(1);
            size--;
            return popped;
            
        }
        
        public void heapify(int pos){
            if(isLeaf(pos)){
                return;
            }
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                }
                else{
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }
        }
        
        public void swap(int i, int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        
        public int leftChild(int pos){
            return pos*2;
        }
        
        public int rightChild(int pos){
            return (pos*2)+1;
        }
        
        public int parent(int pos){
            return pos/2;
        }
        
        public boolean isLeaf(int pos){
            if(pos>=(size+1)/2 && pos<=size+1)
                return true;
            return false;
        }
        
    }
    
    public List<Integer> sortArray(int[] nums) {
        Heap heap = new Heap(nums.length+1);
        List<Integer> result = new ArrayList();
        for(int i: nums)
            heap.insert(i);
        for(int i=0;i<nums.length;i++)
            result.add(heap.getMin());
        //System.out.println(result);
        return result;
    }
}


// Quick Sort

class Solution {
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        List<Integer> list = new ArrayList();
        for(int i:nums)
            list.add(i);
        return list;
    }
    
    public void quickSort(int[] nums, int start, int end){
        int p = partition(nums, start, end);
        if(start<p-1)
            quickSort(nums, start, p-1);
        if(p<end)
            quickSort(nums, p, end);
    }
    
    public int partition(int[] nums, int start, int end){
        int mid = start+(end-start)/2;
        int pivot = nums[mid];
        while(start<=end){
            while(nums[start]<pivot)
                start++;
            while(nums[end]>pivot)
                end--;
            if(start<=end){
                swap(nums, start, end);
                start++;
                end--;
            }
                
        }
        return start;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}