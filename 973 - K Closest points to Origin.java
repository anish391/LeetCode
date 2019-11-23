class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Set<Point> set = new TreeSet();
        for(int i=0;i<points.length;i++){
            set.add(new Point(points[i][0],points[i][1]));
        }
        Iterator<Point> pointIterator = set.iterator();
        int idx = 0;
        int[][] result = new int[K][2];
        while(pointIterator.hasNext() && idx<K){
            Point p = pointIterator.next();
            result[idx][0] = p.x;
            result[idx][1] = p.y;
            idx++;
        }
        return result;
    }
    
    public class Point implements Comparable<Point>{
        private int distance;
        private int x;
        private int y;
        
        public Point(int x, int y){
            this.x=x;
            this.y=y;
            this.distance = x*x + y*y;
        }
        
        @Override
        public int compareTo(Point p){
            return this.distance<p.distance?-1:1;
        }
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1,p2)->(p2[0]*p2[0]+p2[1]*p2[1]-p1[0]*p1[0]-p1[1]*p1[1]));
        for(int[] p: points){
            pq.offer(p);
            if(pq.size()>K)
                pq.poll();
        }
        int i=0;
        int[][] result = new int[K][2];
        while(i<K){
            result[i++] = pq.poll();
        }
        return result;
    }
}