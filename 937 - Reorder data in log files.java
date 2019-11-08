class Solution {
    
    private class LogComparator implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {
            String[] log1 = s1.split(" ",2);
            String[] log2 = s2.split(" ",2);
            boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int cmp = log1[1].compareTo(log2[1]);
                if(cmp!=0)
                    return cmp;
                return log1[0].compareTo(log2[0]);
            }
            return isDigit1 ? (isDigit2?0:1):-1;
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new LogComparator());
        return logs;
    }
}