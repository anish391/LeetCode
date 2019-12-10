class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> result = new ArrayList();
        if(low>high)
            return result;
        Queue<Long> queue = new LinkedList();
        for(long i=1;i<=9;i++){
            queue.offer(i);
        }
        if(low==0)
            result.add(0);
        while(!queue.isEmpty()){
            long number = queue.poll();
            if(number<high){
                long digit = number%10;
                if(digit>0)
                    queue.add(number*10 + digit - 1);
                if(digit<9)
                    queue.add(number*10 + digit + 1);
            }
            if(low <= number && number<= high){
                result.add((int) number);
            }
        }
        return result;
    }
}