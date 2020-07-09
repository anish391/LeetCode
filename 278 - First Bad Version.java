/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(0, n);
    }
    
    public int binarySearch(int low, int high){
        if(low<high){
            int mid = low+(high-low)/2;
            if(isBadVersion(mid))
                return binarySearch(low, mid);
            else
                return binarySearch(mid+1, high);
        }
        return low;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=0, high=n;
        while(low<high){
            int mid = low+(high-low)/2;
            if(isBadVersion(mid))
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }
}