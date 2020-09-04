class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list = new LinkedList();
        if(label<=0)
            return list;
        int nodeCount = 1;
        int level = 1;
        while(nodeCount*2<=label){
            nodeCount*=2;
            level++;
        }
        while(label!=0){
            list.addFirst(label);
            int levelMax = (int) Math.pow(2,level) - 1;
            int levelMin = (int) Math.pow(2,level-1);
            label = (levelMax+levelMin-label)/2;
            level--;
        }
        return list;
    }
}