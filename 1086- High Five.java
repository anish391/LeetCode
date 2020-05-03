class Solution {
    public int[][] highFive(int[][] items) {
        PriorityQueue<Integer>[] scores = new PriorityQueue[1001];
        for(int i=0;i<scores.length;i++)
            scores[i] = new PriorityQueue(5, new ScoreComparator());
        Set<Integer> set = new HashSet();
        for(int i=0;i<items.length;i++){
            int index = items[i][0];
            int score = items[i][1];
            set.add(index);
            scores[index].add(score);
            if(scores[index].size()>5)
                scores[index].poll();
            //System.out.println(scores[index]);
        }
        int[][] result = new int[set.size()][2];
        int index = 0;
        // for(List<Integer> score: scores)
        //     System.out.println(score);
        for(int i=0;i<scores.length;i++){
            if(scores[i].size()!=0){
                int size = scores[i].size();
                int sum = 0;
                for(int score: scores[i])
                    sum+=score;
                result[index][0] = i;
                result[index][1] = (int)(sum/size);
                index++;
             }
            
        }
        return result;
    }
    
    public class ScoreComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return a-b;
        }
    }
}