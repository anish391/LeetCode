class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        int prev = 0;
        for(String log: logs){
            String[] logArray = log.split(":");
            if(logArray[1].equals("start")){
                if(!stack.isEmpty())
                    result[stack.peek()] += Integer.parseInt(logArray[2]) - prev;
                stack.push(Integer.parseInt(logArray[0]));
                prev = Integer.parseInt(logArray[2]);
            }
            else{
                result[stack.pop()] += Integer.parseInt(logArray[2]) - prev + 1;
                prev = Integer.parseInt(logArray[2])+1;
            }
        }
        return result;
        
    }
}